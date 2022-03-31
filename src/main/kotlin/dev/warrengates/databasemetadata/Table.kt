package dev.warrengates.databasemetadata

import java.sql.DatabaseMetaData
import java.sql.ResultSet

@Suppress("MemberVisibilityCanBePrivate")
class Table(private val metadata: DatabaseMetaData, rs: ResultSet) {

    val catalog: String? = rs.getString("TABLE_CAT")
    val schema: String = rs.getString("TABLE_SCHEM")
    val name: String = rs.getString("TABLE_NAME")
    val type: String? = rs.getString("TABLE_TYPE")
    val remarks: String? = rs.getString("REMARKS")
    val typeCatalog: String? = rs.getString("TYPE_CAT")
    val typeSchema: String? = rs.getString("TYPE_SCHEM")
    val typeName: String? = rs.getString("TYPE_NAME")
    val selfReferencingColumnName: String? = rs.getString("SELF_REFERENCING_COL_NAME")
    val referencingColumnGeneration: String? = rs.getString("REF_GENERATION")

    // TODO return columns directly?
    fun getBestRowIdentifier(scope: Int, nullable: Boolean): List<BestRowIdentifier> = getIterableFromRs(
            metadata.getBestRowIdentifier(catalog, schema, name, scope, nullable)
        ) { BestRowIdentifier(it) }

    fun getColumns(columnNamePattern: String?): List<Column> = getIterableFromRs(
            metadata, metadata.getColumns(catalog, schema, name, columnNamePattern)
        ) { m, x -> Column(m, x) }

    fun getExportedKeys(): List<Key> = getIterableFromRs(
        metadata.getExportedKeys(catalog, schema, name)
    ) { Key(it) }

    fun getImportedKeys(): List<Key> = getIterableFromRs(
        metadata.getImportedKeys(catalog, schema, name)
    ) { Key(it) }

    fun getIndexes(unique: Boolean, approximate: Boolean): List<Index> = getIterableFromRs(
        metadata.getIndexInfo(catalog, schema, name, unique, approximate)
    ) { Index(it) }

    fun getPrimayKeys(): List<PrimaryKey> {
        val rs = metadata.getPrimaryKeys(catalog, schema, name)
        val primaryKeyColumns = mutableMapOf<String, MutableList<ColumnSequenceEntry>>()
        val columns = getColumns(null)

        while (rs.next()) {
            val columnName: String = rs.getString("column_name")
            val keySeq: Int = rs.getInt("key_seq")
            val pkName: String = rs.getString("pk_name")
            val columnSequenceList = primaryKeyColumns.getOrPut(pkName) { mutableListOf()}
            val column = columns.find { it.name == columnName } ?: throw Exception("Column $columnName was not found.")

            columnSequenceList.add(ColumnSequenceEntry(column, keySeq))

        }
        return primaryKeyColumns.map { (k, l) -> PrimaryKey(k, l) }
    }

    fun getPseudoColumns(columnNamePattern: String?): List<PseudoColumn> = // TODO: implement
        listOf()

    fun getTablePrivileges(): List<TablePrivilege> = getIterableFromRs(
        metadata.getTablePrivileges(catalog, schema, name)
    ) { TablePrivilege(it) }
}