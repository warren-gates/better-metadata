package dev.warrengates.bettermetadata;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.TestInstance;
import org.testcontainers.containers.JdbcDatabaseContainer;
import org.testcontainers.containers.MariaDBContainer;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

@Disabled
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MariaDbTest extends DatabaseTest {

    private JdbcDatabaseContainer container;
    private Connection conn;
    private DatabaseMetaData metadata;
    private Database wrapper;

    @BeforeAll
    public void setUp() throws SQLException, ClassNotFoundException, FileNotFoundException {
        this.container = new MariaDBContainer("mariadb");
        container.start();
        var url = container.getJdbcUrl();
        var username = container.getUsername();
        var password = container.getPassword();

        Class.forName(container.getDriverClassName());
        conn = DriverManager.getConnection(url, username, password);

        metadata = conn.getMetaData();
        wrapper = new Database(metadata);
        var disabledTests = new ArrayList<String>();
        super.setUp(metadata, wrapper, disabledTests);
    }

    @AfterAll
    public void tearDown() throws SQLException {
        super.tearDown();
        conn.close();
        container.stop();
    }

}
