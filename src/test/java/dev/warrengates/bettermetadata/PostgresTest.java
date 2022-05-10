package dev.warrengates.bettermetadata;

import org.apache.commons.dbutils.handlers.MapListHandler;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.testcontainers.containers.JdbcDatabaseContainer;
import org.testcontainers.containers.PostgreSQLContainer;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

@Disabled
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PostgresTest extends DatabaseTest {

    private JdbcDatabaseContainer container;
    private Connection conn;
    private DatabaseMetaData metadata;
    private Database wrapper;

    @BeforeAll
    public void setUp() throws SQLException, ClassNotFoundException {
        this.container = new PostgreSQLContainer(PostgreSQLContainer.IMAGE);
        container.start();
        var url = container.getJdbcUrl();
        var username = container.getUsername();
        var password = container.getPassword();

        Class.forName(container.getDriverClassName());
        conn = DriverManager.getConnection(url, username, password);
        metadata = conn.getMetaData();
        wrapper = new Database(metadata);
        var disabledTests = Arrays.asList("getSuperTypeTests",
                "getSuperTableTests",
                "testTablePrimaryKeyColumnCount",
                "testTablePseudoColumnCount",
                "getTableIndexTests",
                "getTablePrimaryKeyTests",
                "getTablePseudoColumnTests");
        super.setUp(metadata, wrapper, disabledTests);
    }

    @AfterAll
    public void tearDown() throws SQLException {
        super.tearDown();
        conn.close();
        container.stop();
    }

    @TestFactory
    public List<DynamicTest> testNotImplementedFeatures() {
        return Arrays.asList(
                dynamicTest("metadata.getSuperTables", () -> assertThrows(SQLFeatureNotSupportedException.class, () -> metadata.getSuperTables(null, null, null))),
                dynamicTest("metadata.getSuperTypes", () -> assertThrows(SQLFeatureNotSupportedException.class, () -> metadata.getSuperTypes(null, null, null))),
                dynamicTest("metadata.getPseudoColumns", () -> assertThrows(SQLFeatureNotSupportedException.class, () -> metadata.getPseudoColumns(null, null, null, null)))
        );
    }

    @ParameterizedTest
    @MethodSource("tableProvider")
    public void testPostgresTablePrimaryKeyColumnCount(Table table) throws SQLException {
        assertEquals(getResultSetSize(metadata.getPrimaryKeys(table.getCatalog(), table.getSchema(), table.getName())),
                table.getPrimaryKey().getColumns().size());
    }
    @TestFactory
    public List<DynamicTest> getPgTableIndexTests() throws SQLException, InvocationTargetException, IllegalAccessException {
        var tests = new ArrayList<DynamicTest>();
        tests.addAll(getPgTableIndexTests(true, true));
        tests.addAll(getPgTableIndexTests(false, true));
        tests.addAll(getPgTableIndexTests(true, false));
        tests.addAll(getPgTableIndexTests(false, false));
        return tests;
    }

    public List<DynamicTest> getPgTableIndexTests(boolean unique, boolean approximate)
            throws SQLException, InvocationTargetException, IllegalAccessException {
        var tests = new ArrayList<DynamicTest>();

        var tables = wrapper.getTables(null,"pg_catalog",null, null);
        for (var table : tables) {
            var wrapperObjects = table.getIndexes(unique, approximate);
            var rs = metadata.getIndexInfo(table.getCatalog(), table.getSchema(), table.getName(), unique, approximate);
            // need different mapper because the PostgreSQL driver doesn't always return the types defined by
            // the DatabaseMetaData.getIndexInfo documentation.  The custom mapper just returns the values as the
            // correct type
            var maphandler = new MapListHandler(new ConvertingRowProcessor(Index.class));
            var mapList = maphandler.handle(rs);

            var rsRowCount = 0;
            var indexColumnCount = 0;
            for (var wrapperObject : wrapperObjects) {
                var nonUnique = wrapperObject.getNonUnique();
                var type = wrapperObject.getType().getValue();
                var name = valueOrDefault(wrapperObject.getName(),"");


                var valueMaps = mapList.stream().filter(
                        s -> s.get("NON_UNIQUE").equals(nonUnique) &&
                                s.get("TYPE").equals(type) &&
                                valueOrDefault(s.get("INDEX_NAME"), "").equals(name)
                ).collect(Collectors.toList());

                for (int i = 0; i < valueMaps.size(); i++) {
                    var valueMap = valueMaps.get(i);
                    tests.addAll(getObjectPropertyTests(wrapperObject, valueMap));
                    tests.addAll(getObjectPropertyTests(wrapperObject.getIndexColumns().get(i), valueMap));
                    rsRowCount++;
                }
                indexColumnCount += wrapperObject.getIndexColumns().size();
            }

            int finalrsRowCount = rsRowCount;
            int finalIndexColumnCount = indexColumnCount;
            tests.add(dynamicTest("Table index count", () -> assertEquals(finalrsRowCount, finalIndexColumnCount)));
        }

        return tests;
    }

    @TestFactory
    public List<DynamicTest> getPgTablePrimaryKey() throws SQLException, InvocationTargetException, IllegalAccessException {
        var tests = new ArrayList<DynamicTest>();

        var tables = wrapper.getTables(null,"pg_catalog",null, null);
        for (Table table : tables) {
            var count = 0;
            var rs = metadata.getPrimaryKeys(table.getCatalog(), table.getSchema(), table.getName());
            var maphandler = new MapListHandler(new ConvertingRowProcessor(PrimaryKey.class));
            var mapList = maphandler.handle(rs);
            var primaryKey = table.getPrimaryKey();
            for (int i = 0; i < mapList.size(); i++) {
                tests.addAll(getObjectPropertyTests(primaryKey, mapList.get(i)));
                tests.addAll(getObjectPropertyTests(primaryKey.getColumns().get(i), mapList.get(i)));
                count++;
            }
            int finalCount = count;
            tests.add(dynamicTest("Table primary key count for table:" + table.getName(), () -> assertEquals(finalCount, mapList.size())));

        }
        return tests;
    }

    private Stream<Table> tableProvider() {
        return wrapper.getTables().stream().filter(table -> !table.getName().contains("toast"));
    }
}
