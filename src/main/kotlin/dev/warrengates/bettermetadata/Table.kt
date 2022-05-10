/*
 * Copyright (c) 2022 Warren Gates
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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
    @get:SourceColumn("TABLE_CAT")
    val catalog: String? = rs.getString("TABLE_CAT")

    /**
     * Schema
     *
     * Source column: TABLE_SCHEM
     */
    @get:SourceColumn("TABLE_SCHEM")
    val schema: String? = rs.getString("TABLE_SCHEM")

    /**
     * Name
     *
     * Source column: TABLE_NAME
     */
    @get:SourceColumn("TABLE_NAME")
    val name: String = rs.getString("TABLE_NAME")

    /**
     * Type
     *
     * Source column: TABLE_TYPE
     */
    @get:SourceColumn("TABLE_TYPE")
    val type: String? = rs.getString("TABLE_TYPE")

    /**
     * Remarks
     *
     * Source column: REMARKS
     */
    @get:SourceColumn("REMARKS")
    val remarks: String? = rs.getString("REMARKS")

    /**
     * Type catalog
     *
     * Source column: TYPE_CAT
     */
    @get:SourceColumn("TYPE_CAT")
    val typeCatalog: String? = rs.getString("TYPE_CAT")

    /**
     * Type schema
     *
     * Source column: TYPE_SCHEM
     */
    @get:SourceColumn("TYPE_SCHEM")
    val typeSchema: String? = rs.getString("TYPE_SCHEM")

    /**
     * Type name
     *
     * Source column: TYPE_NAME
     */
    @get:SourceColumn("TYPE_NAME")
    val typeName: String? = rs.getString("TYPE_NAME")

    /**
     * Self referencing column name
     *
     * Source column: SELF_REFERENCING_COL_NAME
     */
    @get:SourceColumn("SELF_REFERENCING_COL_NAME")
    val selfReferencingColumnName: String? = rs.getString("SELF_REFERENCING_COL_NAME")

    /**
     * Referencing column generation
     *
     * Source column: REF_GENERATION
     */
    @get:SourceColumn("REF_GENERATION")
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
    fun getIndexes(unique: Boolean, approximate: Boolean): List<Index> {
        val rs = metadata.getIndexInfo(catalog, schema, name, unique, approximate)
        val indexMaps = mutableListOf<MutableMap<String, Any?>>()
        val tableColumns = getColumns()

        while (rs.next()) {
            val nonUnique = rs.getBoolean("NON_UNIQUE")
            val indexName: String? = rs.getString("INDEX_NAME")
            val type = rs.getShort("TYPE")
            val ordinal = rs.getShort("ORDINAL_POSITION")

            // based on the defined sort order for the ResultSet from
            // getIndexInfo, every time ordinal is one it's the start
            // of a new index
            if (ordinal == 1.toShort()) {
                val map = mutableMapOf<String, Any?>()
                map["COLUMNS"] = mutableListOf<IndexColumn>()
                indexMaps.add(map)
            }

            val indexMap = indexMaps.last()

            // for indexes with multiple columns the following
            // will overwrite existing values (other than column info),
            // but the values will be the same
            indexMap["NON_UNIQUE"] = nonUnique
            indexMap["INDEX_NAME"] = indexName
            indexMap["TYPE"] = type
            indexMap["TABLE_CAT"] = rs.getString("TABLE_CAT")
            indexMap["TABLE_SCHEM"] = rs.getString("TABLE_SCHEM")
            indexMap["TABLE_NAME"] = rs.getString("TABLE_NAME")
            indexMap["INDEX_QUALIFIER"] = rs.getString("INDEX_QUALIFIER")
            indexMap["CARDINALITY"] = rs.getLong("CARDINALITY")
            indexMap["PAGES"] = rs.getLong("PAGES")
            indexMap["FILTER_CONDITION"] = rs.getString("FILTER_CONDITION")

            @Suppress("UNCHECKED_CAST")
            val indexColumns = indexMap["COLUMNS"] as MutableList<IndexColumn>

            val columnName: String? = rs.getString("COLUMN_NAME")
            val sort: String? = rs.getString("ASC_OR_DESC")

            if (columnName != null) {
                val column = tableColumns.first { it.name == columnName }
                val indexSort = valueOf<IndexSort>(sort ?: "")
                indexColumns.add(IndexColumn(column, indexSort))
            }
            indexMap["COLUMNS"] = indexColumns
        }

        return indexMaps.map { Index(it) }
    }

    /**
     * Get primary keys
     *
     * Source: wrapped results of [getPrimaryKeys](https://docs.oracle.com/en/java/javase/17/docs/api/java.sql/java/sql/DatabaseMetaData.html#getPrimaryKeys(java.lang.String,java.lang.String,java.lang.String))
     * filtered to this table's catalog, schema, and name
     *
     */
    val primaryKey: PrimaryKey
        get() {
            val rs = metadata.getPrimaryKeys(catalog, schema, name)

            val tableColumns = getColumns()
            val pkNames = mutableSetOf<String>()
            val pkColumnNames = mutableMapOf<Int, String>()

            while (rs.next()) {
                val columnName: String = rs.getString("COLUMN_NAME")
                val keySeq: Int = rs.getInt("KEY_SEQ")
                val pkName: String = rs.getString("PK_NAME")
                pkNames.add(pkName)
                pkColumnNames[keySeq] = columnName
            }

            if (pkNames.size > 1) {
                throw IllegalStateException("Multiple names for primary key are not allowed")
            }

            val keyColumns = mutableListOf<Column>()
            pkColumnNames.toSortedMap().forEach { (_, columnName) ->
                val column = tableColumns.first {
                    it.name == columnName
                }
                keyColumns.add(column)
            }

            return PrimaryKey(pkNames.firstOrNull(), keyColumns)
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
     * Get super tables of this table
     *
     * Source: wrapped result of [getSuperTables](https://docs.oracle.com/en/java/javase/17/docs/api/java.sql/java/sql/DatabaseMetaData.html#getSuperTables(java.lang.String,java.lang.String,java.lang.String))
     * filtered to this table's catalog, schema, and name
     *
     */
    fun getSuperTables(): List<Table> {

        val allTables = getIterableFromRs(
            metadata, metadata.getTables(catalog, schema, null, null)
        ) { m, rs ->
            Table(m, rs)
        }
        val rs = metadata.getSuperTables(catalog, schema, name)
        val superTableNames = mutableListOf<String>()

        while (rs.next()) {
            superTableNames.add(rs.getString("SUPERTABLE_NAME"))
        }

        return allTables.filter {
            (it.catalog ?: "null") == (catalog ?: "null") &&
                    (it.schema ?: "null") == (schema ?: "null") &&
                    superTableNames.contains(it.name)
        }
    }


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

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Table

        if (catalog != other.catalog) return false
        if (schema != other.schema) return false
        if (name != other.name) return false
        if (type != other.type) return false

        return true
    }

    override fun hashCode(): Int {
        var result = catalog?.hashCode() ?: 0
        result = 31 * result + (schema?.hashCode() ?: 0)
        result = 31 * result + name.hashCode()
        result = 31 * result + (type?.hashCode() ?: 0)
        return result
    }


}