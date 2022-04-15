package dev.warrengates.databasemetadata

import org.h2.tools.RunScript
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance
import java.io.FileReader
import java.sql.Connection
import java.sql.DatabaseMetaData
import java.sql.DriverManager

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
abstract class TestBase {
    private lateinit var conn: Connection
    protected lateinit var metadata: DatabaseMetaData
    protected lateinit var wrapper: Database

    // TODO: look into using other databases for testing (mysql/mariadb, postgres, mssql,etc)
    // use docker or testcontainers?
    // see https://committed.io/posts/docker-java/docker-junit/
    // see https://www.testcontainers.org/

    @BeforeAll
    fun setUp() {
        val driverName = "org.h2.Driver"
        val url = "jdbc:h2:mem:test"
        val user = "sa"
        val password = ""

        Class.forName(driverName)
        conn = DriverManager.getConnection(url, user, password)
        RunScript.execute(conn, FileReader("src/test/resources/createTestTable.sql"))

        metadata = conn.metaData
        wrapper = Database(metadata)
    }

    @AfterAll
    fun tearDown() {
        conn.close()
    }
}