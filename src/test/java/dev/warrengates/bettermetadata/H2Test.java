package dev.warrengates.bettermetadata;

import org.h2.tools.RunScript;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class H2Test extends DatabaseTest {

    private Connection conn;
    private DatabaseMetaData metadata;
    private Database wrapper;

    @BeforeAll
    public void setUp() throws ClassNotFoundException, SQLException, FileNotFoundException {
        var driverName = "org.h2.Driver";
        var url = "jdbc:h2:mem:test";
        var user = "sa";
        var password = "";

        Class.forName(driverName);
        conn = DriverManager.getConnection(url, user, password);
        RunScript.execute(conn, new FileReader("src/test/resources/createH2db.sql"));
        metadata = conn.getMetaData();
        wrapper = new Database(metadata);
        super.setUp(metadata, wrapper, new ArrayList<>());
    }

    @AfterAll
    public void tearDown() throws SQLException {
        super.tearDown();
        conn.close();
    }
}
