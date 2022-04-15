package dev.warrengates.bettermetadata

import java.sql.DatabaseMetaData
import java.sql.ResultSet

/**
 * Table
 *
 * @property metadata
 * @constructor
 *
 * @param rs
 */
@Suppress("MemberVisibilityCanBePrivate")
class Table(private val metadata: DatabaseMetaData, rs: ResultSet) {

    /**
     * Catalog
     */
    val catalog: String? = rs.getString("TABLE_CAT")

    /**
     * Schema
     */
    val schema: String = rs.getString("TABLE_SCHEM")

    /**
     * Name
     */
    val name: String = rs.getString("TABLE_NAME")

    /**
     * Type
     */
    val type: String? = rs.getString("TABLE_TYPE")

    /**
     * Remarks
     */
    val remarks: String? = rs.getString("REMARKS")

    /**
     * Type catalog
     */
    val typeCatalog: String? = rs.getString("TYPE_CAT")

    /**
     * Type schema
     */
    val typeSchema: String? = rs.getString("TYPE_SCHEM")

    /**
     * Type name
     */
    val typeName: String? = rs.getString("TYPE_NAME")

    /**
     * Self referencing column name
     */
    val selfReferencingColumnName: String? = rs.getString("SELF_REFERENCING_COL_NAME")

    /**
     * Referencing column generation
     */
    val referencingColumnGeneration: String? = rs.getString("REF_GENERATION")

    /**
     * Get best row identifier
     *
     * @param scope
     * @param nullable
     * @return
     */
    fun getBestRowIdentifier(scope: BestRowIdentifierScope, nullable: Boolean): List<BestRowIdentifier> = getIterableFromRs(
        metadata.getBestRowIdentifier(catalog, schema, name, scope.type, nullable)
    ) { BestRowIdentifier(it) }

    /**
     * Get columns
     *
     * @param columnNamePattern
     * @return
     */
    @JvmOverloads
    fun getColumns(columnNamePattern: String? = null): List<Column> = getIterableFromRs(
        metadata, metadata.getColumns(catalog, schema, name, columnNamePattern)
    ) { m, x -> Column(m, x) }

    /**
     * Get exported keys
     *
     * @return
     */
    fun getExportedKeys(): List<Key> = getIterableFromRs(
        metadata.getExportedKeys(catalog, schema, name)
    ) { Key(it) }

    /**
     * Get imported keys
     *
     * @return
     */
    fun getImportedKeys(): List<Key> = getIterableFromRs(
        metadata.getImportedKeys(catalog, schema, name)
    ) { Key(it) }

    /**
     * Get indexes
     *
     * @param unique
     * @param approximate
     * @return
     */
    fun getIndexes(unique: Boolean, approximate: Boolean): List<Index> = getIterableFromRs(
        metadata.getIndexInfo(catalog, schema, name, unique, approximate)
    ) { Index(it) }

    /**
     * Get primay keys
     *
     * @return
     */
    fun getPrimayKeys(): List<PrimaryKey> {
        val rs = metadata.getPrimaryKeys(catalog, schema, name)
        val primaryKeyColumns = mutableMapOf<String, MutableList<ColumnSequenceEntry>>()
        val columns = getColumns(null)

        while (rs.next()) {
            val columnName: String = rs.getString("column_name")
            val keySeq: Int = rs.getInt("key_seq")
            val pkName: String = rs.getString("pk_name")
            val columnSequenceList = primaryKeyColumns.getOrPut(pkName) { mutableListOf() }
            val column = columns.find { it.name == columnName } ?: throw Exception("Column $columnName was not found.")

            columnSequenceList.add(ColumnSequenceEntry(column, keySeq))

        }
        return primaryKeyColumns.map { (k, l) -> PrimaryKey(k, l) }
    }

    /**
     * Get pseudo columns
     *
     * @param columnNamePattern
     * @return
     */
    @JvmOverloads
    fun getPseudoColumns(columnNamePattern: String? = null): List<PseudoColumn> = getIterableFromRs(
        metadata.getPseudoColumns(catalog, schema, name, columnNamePattern)) { PseudoColumn(it) }


    /**
     * Get table privileges
     *
     * @return
     */
    fun getTablePrivileges(): List<TablePrivilege> = getIterableFromRs(
        metadata.getTablePrivileges(catalog, schema, name)
    ) { TablePrivilege(it) }
}