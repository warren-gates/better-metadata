package dev.warrengates.bettermetadata;

import org.apache.commons.dbutils.RowProcessor;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.condition.DisabledIf;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.testcontainers.containers.JdbcDatabaseContainer;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.sql.JDBCType.NULL;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public abstract class DatabaseTest {
    private DatabaseMetaData metadata;
    private Database wrapper;
    private JdbcDatabaseContainer container;
    private Connection conn;
    private List<String> disabledTests;
    private List<Table> tables;
    private List<Function> functions;
    private List<Procedure> procedures;

    private boolean functionsExist() {
        return functionProvider().count() > 0;
    }

    private Stream<Function> functionProvider() {
        if (functions == null) {
            functions = wrapper.getFunctions();
        }
        return functions.stream();
    }

    @Test
    public void getCatalogTests() throws SQLException {
        var wrapperCatalogs = wrapper.getCatalogs().toArray();
        var rs = metadata.getCatalogs();
        var metadataCatalogs = new ArrayList<String>();
        while (rs.next()) {
            metadataCatalogs.add(rs.getString("TABLE_CAT"));
        }
        assertArrayEquals(metadataCatalogs.toArray(), wrapperCatalogs);
    }

    @TestFactory
    public List<DynamicTest> getClientInfoPropertyTests() throws SQLException, InvocationTargetException, IllegalAccessException {
        var clientInfoProperties = wrapper.getClientInfoProperties();
        var rs = metadata.getClientInfoProperties();
        return getTests(clientInfoProperties, rs, ClientInfoProperties.class);
    }

    protected List<DynamicTest> getTests(List<?> wrapperObjects, ResultSet rs, Class<?> wrapperObjectClass) throws SQLException, InvocationTargetException, IllegalAccessException {
        var tests = new ArrayList<DynamicTest>();
        var maphandler = new MapListHandler(new ConvertingRowProcessor(wrapperObjectClass));
        var mapList = maphandler.handle(rs);
        tests.add(dynamicTest(wrapperObjectClass.getName() + " count test", () -> assertEquals(mapList.size(), wrapperObjects.size())));
        for (int i = 0; i < mapList.size(); i++) {
            var wrapperObject = wrapperObjects.get(i);
            var map = mapList.get(i);
            tests.addAll(getObjectPropertyTests(wrapperObject, map));
        }
        return tests;
    }

    protected List<DynamicTest> getObjectPropertyTests(Object obj, Map<String, Object> valueMap) throws InvocationTargetException, IllegalAccessException {
        var tests = new ArrayList<DynamicTest>();
        var objectClass = obj.getClass();
        var methods = objectClass.getMethods();
        for (var method : methods) {
            if (method.isAnnotationPresent(SourceColumn.class)) {
                var annotation = method.getAnnotation(SourceColumn.class);
                String columnName = annotation.name();

                Object methodValue = method.invoke(obj);
                Object rsValue = valueMap.get(columnName);
                if (rsValue == null) {
                    continue;
                }

                if (methodValue instanceof IntegerEnum) {
                    methodValue = ((IntegerEnum) methodValue).getValue();
                } else if (methodValue instanceof StringEnum) {
                    methodValue = ((StringEnum) methodValue).getValue();
                } else if (methodValue instanceof Integer) {
                    rsValue = Integer.valueOf(rsValue.toString());
                }
                Object finalMethodValue = methodValue;
                Object finalRsValue = rsValue;
                tests.add(
                        dynamicTest(obj.toString() + ":" + columnName, () -> assertEquals(finalMethodValue, finalRsValue))
                );
            }
        }
        return tests;
    }

    private boolean getDisabled(ExtensionContext ext) {
        return disabledTests.contains(ext.getRequiredTestMethod().getName());
    }

    @TestFactory
    public List<DynamicTest> getFunctionTests() throws SQLException, InvocationTargetException, IllegalAccessException {
        var wrapperObjects = wrapper.getFunctions();
        var rs = metadata.getFunctions(null, null, null);
        return getTests(wrapperObjects, rs, Function.class);
    }

    @TestFactory
    public List<DynamicTest> getProcedureTests() throws SQLException, InvocationTargetException, IllegalAccessException {
        var wrapperObjects = wrapper.getProcedures();
        var rs = metadata.getProcedures(null, null, null);
        return getTests(wrapperObjects, rs, Procedure.class);
    }

    @TestFactory
    public List<DynamicTest> getSchemaTests() throws SQLException, InvocationTargetException, IllegalAccessException {
        var wrapperObjects = wrapper.getSchemas();
        var rs = metadata.getSchemas();
        return getTests(wrapperObjects, rs, Schema.class);
    }

    @DisabledIf("getDisabled")
    @TestFactory
    public List<DynamicTest> getSuperTableTests() throws SQLException, InvocationTargetException, IllegalAccessException {
        var tests = new ArrayList<DynamicTest>();

        var wrapperObjects = wrapper.getTables();
        for (Table table : wrapperObjects) {
            var superTables = table.getSuperTables();
            var rs = metadata.getSuperTables(table.getCatalog(), table.getSchema(), table.getName());
            tests.addAll(getTests(superTables, rs, Table.class));
        }

        return tests;
    }

    @DisabledIf("getDisabled")
    @TestFactory
    public List<DynamicTest> getSuperTypeTests() throws SQLException, InvocationTargetException, IllegalAccessException {
        var tests = new ArrayList<DynamicTest>();

        var wrapperObjects = wrapper.getUserDefinedTypes();
        for (UserDefinedType userDefinedType : wrapperObjects) {
            var superTypes = userDefinedType.getSuperTypes();
            var rs = metadata.getSuperTables(userDefinedType.getCatalog(), userDefinedType.getSchema(), userDefinedType.getName());
            tests.addAll(getTests(superTypes, rs, UserDefinedType.class));
        }

        return tests;
    }

    @TestFactory
    public List<DynamicTest> getTableBestRowIdentifierTests() throws SQLException, InvocationTargetException, IllegalAccessException {

        var tests = new ArrayList<DynamicTest>();
        tests.addAll(getTableBestRowIdentifierTests(BestRowIdentifierScope.SESSION, true));
        tests.addAll(getTableBestRowIdentifierTests(BestRowIdentifierScope.TEMPORARY, true));
        tests.addAll(getTableBestRowIdentifierTests(BestRowIdentifierScope.TRANSACTION, true));
        tests.addAll(getTableBestRowIdentifierTests(BestRowIdentifierScope.SESSION, false));
        tests.addAll(getTableBestRowIdentifierTests(BestRowIdentifierScope.TEMPORARY, false));
        tests.addAll(getTableBestRowIdentifierTests(BestRowIdentifierScope.TRANSACTION, false));

        return tests;
    }

    public List<DynamicTest> getTableBestRowIdentifierTests(BestRowIdentifierScope scope, boolean nullable)
            throws SQLException, InvocationTargetException, IllegalAccessException {
        var tests = new ArrayList<DynamicTest>();

        var tables = wrapper.getTables();
        for (var table : tables) {
            var wrapperObjects = table.getBestRowIdentifier(scope, nullable);
            var rs = metadata.getBestRowIdentifier(table.getCatalog(), table.getSchema(), table.getName(), scope.getValue(), nullable);

            tests.addAll(getTests(wrapperObjects, rs, BestRowIdentifier.class));
        }

        return tests;
    }

    @TestFactory
    public List<DynamicTest> getTableColumnTests() throws SQLException, InvocationTargetException, IllegalAccessException {
        var tests = new ArrayList<DynamicTest>();

        var tables = wrapper.getTables();
        for (var table : tables) {
            var wrapperObjects = table.getColumns();
            var rs = metadata.getColumns(table.getCatalog(), table.getSchema(), table.getName(), null);

            tests.addAll(getTests(wrapperObjects, rs, Column.class));
        }

        return tests;
    }

    @TestFactory
    public List<DynamicTest> getTableExportedKeyTests() throws SQLException {
        var tests = new ArrayList<DynamicTest>();
        var tables = wrapper.getTables();

        for (Table table : tables) {
            var rs = metadata.getExportedKeys(table.getCatalog(), table.getSchema(), table.getName());
            var maphandler = new MapListHandler();
            var mapList = maphandler.handle(rs);
            var keys = table.getExportedKeys();

            tests.addAll(getKeyTests(table, mapList, keys));
        }
        return tests;
    }

    @TestFactory
    public List<DynamicTest> getTableImportedKeyTests() throws SQLException {
        var tests = new ArrayList<DynamicTest>();
        var tables = wrapper.getTables();

        for (Table table : tables) {
            var rs = metadata.getImportedKeys(table.getCatalog(), table.getSchema(), table.getName());
            var maphandler = new MapListHandler();
            var mapList = maphandler.handle(rs);
            var keys = table.getImportedKeys();

            tests.addAll(getKeyTests(table, mapList, keys));
        }
        return tests;
    }

    public List<DynamicTest> getKeyTests(Table table, List<Map<String, Object>> mapList, List<Key> keys) {
        var tests = new ArrayList<DynamicTest>();

        int index = 0;
        for (Key key : keys) {
            for (KeyColumn keyColumn : key.getKeyColumns()) {
                var map = mapList.get(index);
                tests.add(dynamicTest(table.getName() + ":PK_NAME",
                        () -> assertEquals(key.getPrimaryKeyName(), map.get("PK_NAME"))));
                tests.add(dynamicTest(table.getName() + ":FK_NAME",
                        () -> assertEquals(key.getForeignKeyName(), map.get("FK_NAME"))));
                tests.add(dynamicTest(table.getName() + ":DEFERRABILITY",
                        () -> assertEquals(key.getDeferrability().getValue(), map.get("DEFERRABILITY"))));
                tests.add(dynamicTest(table.getName() + ":DELETE_RULE",
                        () -> assertEquals(key.getDeleteRule().getValue(), map.get("DELETE_RULE"))));
                tests.add(dynamicTest(table.getName() + ":UPDATE_RULE",
                        () -> assertEquals(key.getUpdateRule().getValue(), map.get("UPDATE_RULE"))));

                tests.add(dynamicTest(table.getName() + ":PKTABLE_CAT",
                        () -> assertEquals(keyColumn.getPrimaryKeyColumn().getCatalog(), map.get("PKTABLE_CAT"))));
                tests.add(dynamicTest(table.getName() + ":PKTABLE_SCHEM",
                        () -> assertEquals(keyColumn.getPrimaryKeyColumn().getSchema(), map.get("PKTABLE_SCHEM"))));
                tests.add(dynamicTest(table.getName() + ":PKTABLE_NAME",
                        () -> assertEquals(keyColumn.getPrimaryKeyColumn().getTableName(), map.get("PKTABLE_NAME"))));
                tests.add(dynamicTest(table.getName() + ":PKCOLUMN_NAME",
                        () -> assertEquals(keyColumn.getPrimaryKeyColumn().getName(), map.get("PKCOLUMN_NAME"))));

                tests.add(dynamicTest(table.getName() + ":FKTABLE_CAT",
                        () -> assertEquals(keyColumn.getForeignKeyColumn().getCatalog(), map.get("FKTABLE_CAT"))));
                tests.add(dynamicTest(table.getName() + ":FKTABLE_SCHEM",
                        () -> assertEquals(keyColumn.getForeignKeyColumn().getSchema(), map.get("FKTABLE_SCHEM"))));
                tests.add(dynamicTest(table.getName() + ":FKTABLE_NAME",
                        () -> assertEquals(keyColumn.getForeignKeyColumn().getTableName(), map.get("FKTABLE_NAME"))));
                tests.add(dynamicTest(table.getName() + ":FKCOLUMN_NAME",
                        () -> assertEquals(keyColumn.getForeignKeyColumn().getName(), map.get("FKCOLUMN_NAME"))));
                index++;
            }
        }
        int finalIndex = index;
        tests.add(dynamicTest(table.getName() + ":count", () -> assertEquals(finalIndex, mapList.size())));
        return tests;
    }

    @DisabledIf("getDisabled")
    @TestFactory
    public List<DynamicTest> getTableIndexTests() throws SQLException, InvocationTargetException, IllegalAccessException {
        var tests = new ArrayList<DynamicTest>();
        tests.addAll(getTableIndexTests(true, true));
        tests.addAll(getTableIndexTests(false, true));
        tests.addAll(getTableIndexTests(true, false));
        tests.addAll(getTableIndexTests(false, false));
        return tests;
    }

    public List<DynamicTest> getTableIndexTests(boolean unique, boolean approximate)
            throws SQLException, InvocationTargetException, IllegalAccessException {
        var tests = new ArrayList<DynamicTest>();

        var tables = wrapper.getTables();
        for (var table : tables) {

            var rs = metadata.getIndexInfo(table.getCatalog(), table.getSchema(),table.getName(), unique, approximate);
            var tableIndexes = table.getIndexes(unique, approximate);
            var maphandler = new MapListHandler(new ConvertingRowProcessor(Index.class));
            var mapList = maphandler.handle(rs);

            for (var index : tableIndexes) {
                var nonUnique = index.getNonUnique();
                var type = index.getType();
                var name = valueOrDefault(index.getName(),"");

                var valueMaps = mapList.stream().filter(
                        s -> s.get("NON_UNIQUE").equals(nonUnique) &&
                                s.get("TYPE").equals(type) &&
                                valueOrDefault(s.get("INDEX_NAME"), "").equals(name)
                ).collect(Collectors.toList());

                for (int i = 0; i < valueMaps.size(); i++) {
                    var valueMap = valueMaps.get(i);
                    // yes, the index object might get validated multiple times...
                    tests.addAll(getObjectPropertyTests(index, valueMap));
                    // but it makes it easier to validate each indexcolumn object
                    tests.addAll(getObjectPropertyTests(index.getIndexColumns().get(i), valueMap));
                }
            }

        }

        return tests;
    }

    @DisabledIf("getDisabled")
    @TestFactory
    public List<DynamicTest> getTablePrimaryKeyTests() throws SQLException, InvocationTargetException, IllegalAccessException {
        var tests = new ArrayList<DynamicTest>();

        var tables = wrapper.getTables();
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

    @TestFactory
    public List<DynamicTest> getTablePrivilegeTests() throws SQLException, InvocationTargetException, IllegalAccessException {
        var tests = new ArrayList<DynamicTest>();

        var tables = wrapper.getTables();
        for (Table table : tables) {
            var wrapperObjects = table.getTablePrivileges();
            var rs = metadata.getTablePrivileges(table.getCatalog(), table.getSchema(), table.getName());
            tests.addAll(getTests(wrapperObjects, rs, TablePrivilege.class));
        }
        return tests;
    }

    @DisabledIf("getDisabled")
    @TestFactory
    public List<DynamicTest> getTablePseudoColumnTests() throws SQLException, InvocationTargetException, IllegalAccessException {
        var tests = new ArrayList<DynamicTest>();

        var tables = wrapper.getTables();
        for (Table table : tables) {
            var wrapperObjects = table.getPseudoColumns();
            var rs = metadata.getPseudoColumns(table.getCatalog(), table.getSchema(), table.getName(), null);
            tests.addAll(getTests(wrapperObjects, rs, PseudoColumn.class));
        }
        return tests;
    }

    @TestFactory
    public List<DynamicTest> getTableTests() throws SQLException, InvocationTargetException, IllegalAccessException {
        var wrapperObjects = wrapper.getTables();
        var rs = metadata.getTables(null, null, null, null);
        return getTests(wrapperObjects, rs, Table.class);
    }

    @TestFactory
    public List<DynamicTest> getTableTypeTests() throws SQLException {
        return Arrays.asList(
                getObjectCountTest("TableTypes", wrapper.getTableTypes(), metadata.getTableTypes())
        );
    }

    private DynamicTest getObjectCountTest(String name, List<?> list, ResultSet rs) {
        return dynamicTest(name, () -> assertEquals(getResultSetSize(rs), list.size()));
    }

    @TestFactory
    public List<DynamicTest> getTypeInfoTests() throws SQLException, InvocationTargetException, IllegalAccessException {
        var wrapperObjects = wrapper.getTypeInfo();
        var rs = metadata.getTypeInfo();
        return getTests(wrapperObjects, rs, TypeInfo.class);
    }

    @TestFactory
    public List<DynamicTest> getUserDefinedTypeTests() throws SQLException, InvocationTargetException, IllegalAccessException {
        var wrapperObjects = wrapper.getUserDefinedTypes();
        var rs = metadata.getUDTs(null, null, null, null);
        return getTests(wrapperObjects, rs, UserDefinedType.class);
    }

    private boolean proceduresExist() {
        return procedureProvider().count() > 0;
    }

    private Stream<Procedure> procedureProvider() {
        if (procedures == null) {
            procedures = wrapper.getProcedures();
        }
        return procedures.stream();
    }

    protected void setUp(DatabaseMetaData metadata, Database wrapper, List<String> disabledTests) throws ClassNotFoundException, SQLException {
        this.metadata = metadata;
        this.wrapper = wrapper;
        this.disabledTests = disabledTests;
    }

    private Stream<Table> tableProvider() {
        if (tables == null) {
            tables = wrapper.getTables();
        }
        return tables.stream();
    }

    protected void tearDown() throws SQLException {

    }

    @Test
    public void testEnumReturnFunctions() throws SQLException {
        assertAll(
                () -> assertEquals(valueOf(TransactionIsolation.class, metadata.getDefaultTransactionIsolation()), wrapper.getDefaultTransactionIsolation()),
                () -> assertEquals(valueOf(ResultSetHoldability.class, metadata.getResultSetHoldability()), wrapper.getResultSetHoldability()),
                () -> assertEquals(valueOf(SQLStateType.class, metadata.getSQLStateType()), wrapper.getSQLStateType())
        );
    }

    private static <T extends Enum<T> & IntegerEnum> T valueOf(Class<T> enumType, int value) {
        for (T en : enumType.getEnumConstants()) {
            if (en.getValue() == value) {
                return en;
            }
        }
        throw new IllegalArgumentException("No enum constant has type = " + value);
    }

    @ParameterizedTest
    @MethodSource
    public void testKeywordsToObject(String wordString, List<?> objectList) {
        assertAll(
                () -> assertEquals(wordString.split(",").length, objectList.size()),
                () -> assertTrue(Arrays.stream(wordString.split(",")).allMatch(word -> objectList.stream().filter(o -> o.toString().equals(word)).count() == 1))
        );
    }

    private Stream<Arguments> testKeywordsToObject() throws SQLException {
        return Stream.of(
                Arguments.of(metadata.getSQLKeywords(), wrapper.getSQLKeywords()),
                Arguments.of(metadata.getNumericFunctions(), wrapper.getNumericFunctions()),
                Arguments.of(metadata.getStringFunctions(), wrapper.getStringFunctions()),
                Arguments.of(metadata.getSystemFunctions(), wrapper.getSystemFunctions()),
                Arguments.of(metadata.getTimeDateFunctions(), wrapper.getTimeDateFunctions())
        );
    }

    @ParameterizedTest
    @MethodSource("tableProvider")
    public void testTableColumnFilteringCount(Table table) throws SQLException {
        assertEquals(getResultSetSize(metadata.getColumns(table.getCatalog(), table.getSchema(), table.getName(), "%rst%")),
                table.getColumns("%rst%").size());
    }

    protected int getResultSetSize(ResultSet rs) throws SQLException {
        var rowCount = 0;
        while (rs.next()) {
            rowCount++;
        }
        return rowCount;
    }

    @ParameterizedTest
    @MethodSource("tableProvider")
    public void testTableExportedKeysCount(Table table) throws SQLException {
        assertEquals(getResultSetSize(metadata.getExportedKeys(table.getCatalog(), table.getSchema(), table.getName())),
                table.getExportedKeys().stream().reduce(0, (accum, key) -> accum + key.getKeyColumns().size(), Integer::sum));
    }

    @ParameterizedTest
    @MethodSource("tableProvider")
    public void testTableImportedKeysCount(Table table) throws SQLException {
        assertEquals(getResultSetSize(metadata.getImportedKeys(table.getCatalog(), table.getSchema(), table.getName())),
                table.getImportedKeys().stream().reduce(0, (accum, key) -> accum + key.getKeyColumns().size(), Integer::sum));
    }

    protected <T> T valueOrDefault(T value, T defaultValue) {
        return (value != null) ? value : defaultValue;
    }

    interface ResultSetValue {
        Object get(ResultSet resultSet, String columnName) throws SQLException;
    }

    class ConvertingRowProcessor implements RowProcessor {

        private final Map<String, Class<?>> columnTypeMap;
        private final Map<Class<?>, ResultSetValue> typeFunctionMap;

        public ConvertingRowProcessor(Class<?> targetClass) {
            columnTypeMap = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
            var methods = targetClass.getMethods();
            for (var method : methods) {
                if (method.isAnnotationPresent(SourceColumn.class)) {
                    var annotation = method.getAnnotation(SourceColumn.class);
                    String columnName = annotation.name();
                    Class<?> methodType = method.getReturnType();
                    columnTypeMap.put(columnName, methodType);
                }
            }

            ResultSetValue longFunction = (rs, name) -> {
                return rs.getLong(name);
            };

            ResultSetValue intFunction = (rs, name) -> {
                return rs.getInt(name);
            };

            ResultSetValue boolFunction = (rs, name) -> {
                return rs.getBoolean(name);
            };

            ResultSetValue jdbcFunction = (rs, name) -> {
                var value = rs.getObject(name);
                if (rs.wasNull()) {
                    return NULL;
                }
                return JDBCType.valueOf(Integer.parseInt(value.toString()));
            };

            ResultSetValue pseudoColumnUsageFunction = (rs, name) -> {
                return PseudoColumnUsage.valueOf(rs.getString(name));
            };

            typeFunctionMap = new HashMap<>();
            typeFunctionMap.put(boolean.class, boolFunction);
            typeFunctionMap.put(Boolean.class, boolFunction);

            typeFunctionMap.put(long.class, longFunction);
            typeFunctionMap.put(Long.class, longFunction);

            typeFunctionMap.put(int.class, intFunction);
            typeFunctionMap.put(Integer.class, intFunction);
            typeFunctionMap.put(short.class, intFunction);
            typeFunctionMap.put(Short.class, intFunction);
            typeFunctionMap.put(TypeNullable.class, intFunction);
            typeFunctionMap.put(TypeSearchable.class, intFunction);

            typeFunctionMap.put(JDBCType.class, jdbcFunction);

            typeFunctionMap.put(PseudoColumnUsage.class, pseudoColumnUsageFunction);
        }

        @Override
        public Object[] toArray(ResultSet rs) throws SQLException {
            return new Object[0];
        }

        @Override
        public <T> T toBean(ResultSet rs, Class<? extends T> type) throws SQLException {
            return null;
        }

        @Override
        public <T> List<T> toBeanList(ResultSet rs, Class<? extends T> type) throws SQLException {
            return null;
        }

        @Override
        public Map<String, Object> toMap(ResultSet resultSet) throws SQLException {
            Map<String, Object> values = new HashMap<>();
            var rsMetadata = resultSet.getMetaData();
            var columnCount = rsMetadata.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                var columnName = rsMetadata.getColumnName(i);
                var targetType = columnTypeMap.get(columnName);

                var rsFunction = typeFunctionMap.getOrDefault(targetType, (rs, name) -> {
                    return rs.getObject(name);
                });

                values.put(columnName.toUpperCase(), rsFunction.get(resultSet, columnName));
            }

            return values;
        }
    }
}
