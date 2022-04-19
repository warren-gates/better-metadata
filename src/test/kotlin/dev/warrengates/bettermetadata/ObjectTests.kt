package dev.warrengates.bettermetadata

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.TestInstance
import java.sql.DatabaseMetaData
import java.sql.ResultSet

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ObjectTests : TestBase() {

    @TestFactory
    fun testDatabaseObjects(): List<DynamicTest> {
        val testList: MutableList<DynamicTest> = mutableListOf()

        testList.add(
            getObjectCountTest("Catalogs",
                wrapper.getCatalogs(),
                metadata.catalogs
            )
        )

        testList.add(
            getObjectCountTest("ClientInfoProperties",
                wrapper.getClientInfoProperties(),
                metadata.clientInfoProperties
            )
        )

        testList.add(
            getObjectCountTest("Functions",
                wrapper.getFunctions(),
                metadata.getFunctions(null, null, null)
            )
        )

        testList.add(
            getObjectCountTest("Procedures",
                wrapper.getProcedures(),
                metadata.getProcedures(null, null, null)
            )
        )

        testList.add(
            getObjectCountTest("Schemas",
                wrapper.getSchemas(),
                metadata.schemas
            )
        )

        testList.add(
            getObjectCountTest("SuperTables",
                wrapper.getSuperTables(),
                metadata.getSuperTables(null, null, null)
            )
        )

        testList.add(
            getObjectCountTest("SuperTypes",
                wrapper.getSuperTypes(),
                metadata.getSuperTypes(null, null, null)
            )
        )

        testList.add(
            getObjectCountTest("Tables",
                wrapper.getTables(),
                metadata.getTables(null, null, null, null)
            )
        )

        testList.add(
            getObjectCountTest("TableTypes",
                wrapper.getTableTypes(),
                metadata.tableTypes
            )
        )

        testList.add(
            getObjectCountTest("TypeInfo",
                wrapper.getTypeInfo(),
                metadata.typeInfo)
        )

        testList.add(
            getObjectCountTest("UserDefinedTypes",
                wrapper.getUserDefinedTypes(),
                metadata.getUDTs(null, null, null, null)
            )
        )

        return testList
    }

    @TestFactory
    fun testTableContents(): List<DynamicTest> {
        val testList: MutableList<DynamicTest> = mutableListOf()

        val tables = wrapper.getTables()
        val rs = metadata.getTables(null, null, null, null)
        while (rs.next()) {
            val catalog = rs.getString("TABLE_CAT")
            val schema = rs.getString("TABLE_SCHEM")
            val name: String = rs.getString("TABLE_NAME")
            val type: String? = rs.getString("TABLE_TYPE")
            val table = tables.first {
                it.catalog == catalog &&
                        it.schema == schema &&
                        it.name == name &&
                        it.type == type
            }

            val remarks = rs.getString("REMARKS")
            testList.add(
                dynamicTest("$name - remarks") {
                    assertEquals(remarks, table.remarks)
                }
            )

            val typeCatalog = rs.getString("TYPE_CAT")
            testList.add(
                dynamicTest("$name - typeCatalog") {
                    assertEquals(typeCatalog, table.typeCatalog)
                }
            )

            val typeSchema = rs.getString("TYPE_SCHEM")
            testList.add(
                dynamicTest("$name - typeSchema") {
                    assertEquals(typeSchema, table.typeSchema)
                }
            )

            val typeName = rs.getString("TYPE_NAME")
            testList.add(
                dynamicTest("$name - typeName") {
                    assertEquals(typeName, table.typeName)
                }
            )

            val selfReferencingColumnName = rs.getString("SELF_REFERENCING_COL_NAME")
            testList.add(
                dynamicTest("$name - selfReferencingColumnName") {
                    assertEquals(selfReferencingColumnName, table.selfReferencingColumnName)
                }
            )

            val referencingColumnGeneration = rs.getString("REF_GENERATION")
            testList.add(
                dynamicTest("$name - referencingColumnGeneration") {
                    assertEquals(referencingColumnGeneration, table.referencingColumnGeneration)
                }
            )
        }

        return testList
    }

    @TestFactory
    fun testTableChildren(): List<DynamicTest> {
        val testList: MutableList<DynamicTest> = mutableListOf()

        val wrapperTables = wrapper.getTables()

        wrapperTables.forEach { table ->
            testList.add(
                getObjectCountTest("${table.name}: Columns",
                    table.getColumns(),
                    metadata.getColumns(table.catalog, table.schema, table.name, null))
            )

            testList.add(
                getObjectCountTest("${table.name}: Columns",
                    table.getColumns("%rst%"),
                    metadata.getColumns(table.catalog, table.schema, table.name, "%rst%"))
            )

            testList.add(
                getObjectCountTest("${table.name}: BestRowIdentifiers(Session, True)",
                    table.getBestRowIdentifier(BestRowIdentifierScope.SESSION, true),
                    metadata.getBestRowIdentifier(table.catalog,
                        table.schema,
                        table.name,
                        DatabaseMetaData.bestRowSession,
                        true))
            )

            testList.add(
                getObjectCountTest("${table.name}: BestRowIdentifiers(Temporary, True)",
                    table.getBestRowIdentifier(BestRowIdentifierScope.TEMPORARY, true),
                    metadata.getBestRowIdentifier(table.catalog,
                        table.schema,
                        table.name,
                        DatabaseMetaData.bestRowTemporary,
                        true))
            )

            testList.add(
                getObjectCountTest("${table.name}: BestRowIdentifiers(Transaction, True)",
                    table.getBestRowIdentifier(BestRowIdentifierScope.TRANSACTION, true),
                    metadata.getBestRowIdentifier(table.catalog,
                        table.schema,
                        table.name,
                        DatabaseMetaData.bestRowTransaction,
                        true))
            )

            testList.add(
                getObjectCountTest("${table.name}: BestRowIdentifiers(Session, False)",
                    table.getBestRowIdentifier(BestRowIdentifierScope.SESSION, false),
                    metadata.getBestRowIdentifier(table.catalog,
                        table.schema,
                        table.name,
                        DatabaseMetaData.bestRowSession,
                        true))
            )

            testList.add(
                getObjectCountTest("${table.name}: BestRowIdentifiers(Temporary, False)",
                    table.getBestRowIdentifier(BestRowIdentifierScope.TEMPORARY, false),
                    metadata.getBestRowIdentifier(table.catalog,
                        table.schema,
                        table.name,
                        DatabaseMetaData.bestRowTemporary,
                        true))
            )

            testList.add(
                getObjectCountTest("${table.name}: BestRowIdentifiers(Transaction, False)",
                    table.getBestRowIdentifier(BestRowIdentifierScope.TRANSACTION, false),
                    metadata.getBestRowIdentifier(table.catalog,
                        table.schema,
                        table.name,
                        DatabaseMetaData.bestRowTransaction,
                        true))
            )

            testList.add(
                dynamicTest("${table.name}: ExportedKeys")
                { assertEquals(getResultSetSize(metadata.getExportedKeys(table.catalog, table.schema, table.name)),
                    table.getExportedKeys().sumOf { it.keyColumns.size }) }
            )

            testList.add(
                dynamicTest("${table.name}: ImportedKeys")
                { assertEquals(getResultSetSize(metadata.getImportedKeys(table.catalog, table.schema, table.name)),
                    table.getImportedKeys().sumOf { it.keyColumns.size }) }
            )

            testList.add(
                getObjectCountTest("${table.name}: Indexes(False, False)",
                    table.getIndexes(unique = false, approximate = false),
                    metadata.getIndexInfo(table.catalog, table.schema, table.name, false, false))
            )

            testList.add(
                getObjectCountTest("${table.name}: Indexes(True, False)",
                    table.getIndexes(unique = true, approximate = false),
                    metadata.getIndexInfo(table.catalog, table.schema, table.name, true, false))
            )

            testList.add(
                getObjectCountTest("${table.name}: Indexes(False, True)",
                    table.getIndexes(unique = false, approximate = true),
                    metadata.getIndexInfo(table.catalog, table.schema, table.name, false, true))
            )

            testList.add(
                getObjectCountTest("${table.name}: Indexes(True, True)",
                    table.getIndexes(unique = true, approximate = true),
                    metadata.getIndexInfo(table.catalog, table.schema, table.name, true, true))
            )

            testList.add(
                dynamicTest("${table.name}: PrimaryKey Count")
                { assertTrue(table.getPrimaryKeys().size <= 1) }
            )

            testList.add(
                dynamicTest("${table.name}: PrimaryKeys")
                { assertEquals(getResultSetSize(metadata.getPrimaryKeys(table.catalog, table.schema, table.name)),
                    table.getPrimaryKeys().sumOf { it.primaryKeyColumns.size }) }
            )

            testList.add(
                getObjectCountTest("${table.name}: PseudoColumns",
                    table.getPseudoColumns(),
                    metadata.getPseudoColumns(table.catalog, table.schema, table.name, null))
            )

            testList.add(
                getObjectCountTest("${table.name}: TablePrivileges",
                    table.getTablePrivileges(),
                    metadata.getTablePrivileges(table.catalog, table.schema, table.name))
            )
        }
        return testList
    }


    private fun getObjectCountTest(name: String, list: List<Any>, rs: ResultSet): DynamicTest {
        return dynamicTest(name) { assertEquals(getResultSetSize(rs), list.size) }
    }

    private fun getResultSetSize(rs: ResultSet): Int {
        var rowCount = 0
        while (rs.next()) {
            rowCount++
        }
        return rowCount
    }
}