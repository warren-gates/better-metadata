/*
 * Copyright (c) 2022. Warren Gates
 * All rights reserved.
 */

package dev.warrengates.bettermetadata

import java.sql.DatabaseMetaData
import java.sql.ResultSet

/**
 * Wrapper for the results of [getTables](https://docs.oracle.com/en/java/javase/17/docs/api/java.sql/java/sql/DatabaseMetaData.html#getTables(java.lang.String,java.lang.String,java.lang.String,java.lang.String%5B%5D))
 *
 */
@Suppress("MemberVisibilityCanBePrivate")
class Table(private val metadata: DatabaseMetaData, rs: ResultSet) {

    /**
     * Catalog
     *
     * Source column: TABLE_CAT
     */
    val catalog: String? = rs.getString("TABLE_CAT")

    /**
     * Schema
     *
     * Source column: TABLE_SCHEM
     */
    val schema: String = rs.getString("TABLE_SCHEM")

    /**
     * Name
     *
     * Source column: TABLE_NAME
     */
    val name: String = rs.getString("TABLE_NAME")

    /**
     * Type
     *
     * Source column: TABLE_TYPE
     */
    val type: String? = rs.getString("TABLE_TYPE")

    /**
     * Remarks
     *
     * Source column: REMARKS
     */
    val remarks: String? = rs.getString("REMARKS")

    /**
     * Type catalog
     *
     * Source column: TYPE_CAT
     */
    val typeCatalog: String? = rs.getString("TYPE_CAT")

    /**
     * Type schema
     *
     * Source column: TYPE_SCHEM
     */
    val typeSchema: String? = rs.getString("TYPE_SCHEM")

    /**
     * Type name
     *
     * Source column: TYPE_NAME
     */
    val typeName: String? = rs.getString("TYPE_NAME")

    /**
     * Self referencing column name
     *
     * Source column: SELF_REFERENCING_COL_NAME
     */
    val selfReferencingColumnName: String? = rs.getString("SELF_REFERENCING_COL_NAME")

    /**
     * Referencing column generation
     *
     * Source column: REF_GENERATION
     */
    val referencingColumnGeneration: String? = rs.getString("REF_GENERATION")

    /**
     * Get best row identifier for this table
     *
     * Source: wrapped results of [getBestRowIdentifier](https://docs.oracle.com/en/java/javase/17/docs/api/java.sql/java/sql/DatabaseMetaData.html#getBestRowIdentifier(java.lang.String,java.lang.String,java.lang.String,int,boolean))
     * filtered to this table's catalog, schema, and name
     */
    fun getBestRowIdentifier(scope: BestRowIdentifierScope, nullable: Boolean): List<BestRowIdentifier> =
        getIterableFromRs(
            metadata.getBestRowIdentifier(catalog, schema, name, scope.value, nullable)
        ) { BestRowIdentifier(it) }

    /**
     * Get columns for this table
     *
     * Source: wrapped results of [getColumns](https://docs.oracle.com/en/java/javase/17/docs/api/java.sql/java/sql/DatabaseMetaData.html#getColumns(java.lang.String,java.lang.String,java.lang.String,java.lang.String))
     * filtered to this table's catalog, schema, and name
     *
     * @param columnNamePattern
     */
    @JvmOverloads
    fun getColumns(columnNamePattern: String? = null): List<Column> = getIterableFromRs(
        metadata, metadata.getColumns(catalog, schema, name, columnNamePattern)
    ) { m, x -> Column(m, x) }

    /**
     * Get keys exported from this table
     *
     * Source: wrapped results of [getExportedKeys](https://docs.oracle.com/en/java/javase/17/docs/api/java.sql/java/sql/DatabaseMetaData.html#getExportedKeys(java.lang.String,java.lang.String,java.lang.String))
     * filtered to this table's catalog, schema, and name
     *
     */
    fun getExportedKeys(): List<Key> {
        // this table is PK
        return getKeys(
            metadata,
            metadata.getExportedKeys(catalog, schema, name),
            KeyDiscriminatorColumns("FKTABLE_CAT", "FKTABLE_SCHEM", "FKTABLE_NAME")
        )
    }

    /**
     * Get keys imported from other tables
     *
     * Source: wrapped results of [getImportedKeys](https://docs.oracle.com/en/java/javase/17/docs/api/java.sql/java/sql/DatabaseMetaData.html#getImportedKeys(java.lang.String,java.lang.String,java.lang.String))
     * filtered to this table's catalog, schema, and name
     */
    fun getImportedKeys(): List<Key> {
        // this table is FK
        return getKeys(
            metadata,
            metadata.getImportedKeys(catalog, schema, name),
            KeyDiscriminatorColumns("PKTABLE_CAT", "PKTABLE_SCHEM", "PKTABLE_NAME")
        )
    }

    /**
     * Get indexes
     *
     * Source: wrapped results of [getIndexInfo](https://docs.oracle.com/en/java/javase/17/docs/api/java.sql/java/sql/DatabaseMetaData.html#getIndexInfo(java.lang.String,java.lang.String,java.lang.String,boolean,boolean))
     * filtered to this table's catalog, schema, and name
     *
     */
    fun getIndexes(unique: Boolean, approximate: Boolean): List<Index> = getIterableFromRs(
        metadata.getIndexInfo(catalog, schema, name, unique, approximate)
    ) { Index(it) }

    /**
     * Get primary keys
     *
     * Source: wrapped results of [getPrimaryKeys](https://docs.oracle.com/en/java/javase/17/docs/api/java.sql/java/sql/DatabaseMetaData.html#getPrimaryKeys(java.lang.String,java.lang.String,java.lang.String))
     * filtered to this table's catalog, schema, and name
     *
     */
    fun getPrimaryKeys(): List<PrimaryKey> {
        val rs = metadata.getPrimaryKeys(catalog, schema, name)
        val primaryKeyColumns = mutableMapOf<String, MutableList<PrimaryKeyColumn>>()
        val columns = getColumns(null)

        while (rs.next()) {
            val columnName: String = rs.getString("COLUMN_NAME")
            val keySeq: Int = rs.getInt("KEY_SEQ")
            val pkName: String = rs.getString("PK_NAME")
            val columnSequenceList = primaryKeyColumns.getOrPut(pkName) { mutableListOf() }
            val column = columns.find { it.name == columnName } ?: throw Exception("Column $columnName was not found.")

            columnSequenceList.add(PrimaryKeyColumn(column, keySeq))

        }
        return primaryKeyColumns.map { (k, l) -> PrimaryKey(k, l) }
    }

    /**
     * Get pseudo columns
     *
     * Source: wrapped results of [getPseudoColumns](https://docs.oracle.com/en/java/javase/17/docs/api/java.sql/java/sql/DatabaseMetaData.html#getPseudoColumns(java.lang.String,java.lang.String,java.lang.String,java.lang.String))
     * filtered to this table's catalog, schema, and name
     *
     */
    @JvmOverloads
    fun getPseudoColumns(columnNamePattern: String? = null): List<PseudoColumn> = getIterableFromRs(
        metadata.getPseudoColumns(catalog, schema, name, columnNamePattern)
    ) { PseudoColumn(it) }


    /**
     * Get table privileges
     *
     * Source: wrapped results of [getTablePrivileges](https://docs.oracle.com/en/java/javase/17/docs/api/java.sql/java/sql/DatabaseMetaData.html#getTablePrivileges(java.lang.String,java.lang.String,java.lang.String))
     * filtered to this table's catalog, schema, and name
     *
     */
    fun getTablePrivileges(): List<TablePrivilege> = getIterableFromRs(
        metadata.getTablePrivileges(catalog, schema, name)
    ) { TablePrivilege(it) }


    /**
     * Get version columns
     *
     * Source: wrapped results of [getVersionColumns](https://docs.oracle.com/en/java/javase/17/docs/api/java.sql/java/sql/DatabaseMetaData.html#getVersionColumns(java.lang.String,java.lang.String,java.lang.String))
     * filtered to this table's catalog, schema, and name
     */
    fun getVersionColumns(): List<VersionColumn> = getIterableFromRs(
        metadata.getVersionColumns(catalog, schema, name)
    ) { VersionColumn(it) }
}