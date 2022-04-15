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

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class JDatabaseTestBase {
    protected Connection conn;
    protected DatabaseMetaData metadata;
    protected Database wrapper;

    @BeforeAll
    public void setUp() throws ClassNotFoundException, SQLException, FileNotFoundException {
        String driverName = "org.h2.Driver";
        String url = "jdbc:h2:mem:test";
        String user = "sa";
        String password = "";

        Class.forName(driverName);
        conn = DriverManager.getConnection(url, user, password);
        RunScript.execute(conn, new FileReader("src/test/resources/createTestTable.sql"));

        metadata = conn.getMetaData();
        wrapper = new Database(metadata);
    }

    @AfterAll
    public void tearDown() throws SQLException {
        conn.close();
    }
}
