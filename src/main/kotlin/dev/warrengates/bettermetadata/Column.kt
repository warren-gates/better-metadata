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
import java.sql.JDBCType
import java.sql.ResultSet

/**
 * Wrapper for results of [getColumns](https://docs.oracle.com/en/java/javase/17/docs/api/java.sql/java/sql/DatabaseMetaData.html#getColumns(java.lang.String,java.lang.String,java.lang.String,java.lang.String))
 * method and represents a [Table] column
 *
 * Note that per the documentation BUFFER_LENGTH, SQL_DATA_TYPE, and SQL_DATETIME_SUB are unused and have
 * been left out of this class
 *
 * @property metadata
 * @constructor
 *
 * @param rs
 */
class Column(private val metadata: DatabaseMetaData, rs: ResultSet) {
    /**
     * Containing Table's catalog
     *
     * Source column: TABLE_CAT
     */
    @get:SourceColumn("TABLE_CAT")
    val catalog: String? = rs.getString("TABLE_CAT")

    /**
     * Containing Table's schema
     *
     * Source column: TABLE_SCHEM
     */
    @get:SourceColumn("TABLE_SCHEM")
    val schema: String? = rs.getString("TABLE_SCHEM")

    /**
     * Containing Table's name
     *
     * Source column: TABLE_NAME
     */
    @get:SourceColumn("TABLE_NAME")
    val tableName: String? = rs.getString("TABLE_NAME")

    /**
     * Column name
     *
     * Source column: COLUMN_NAME
     */
    @get:SourceColumn("COLUMN_NAME")
    val name: String = rs.getString("COLUMN_NAME")

    /**
     * SQL type from [java.sql.Types], converted from int
     *
     * Source column: DATA_TYPE
     */
    @get:SourceColumn("DATA_TYPE")
    val dataType: JDBCType = rs.getJDBCType("DATA_TYPE")

    /**
     * Data source dependent type name, for [UserDefinedType] the type name is fully qualified
     *
     * Source column: TYPE_NAME
     */
    @get:SourceColumn("TYPE_NAME")
    val typeName: String? = rs.getString("TYPE_NAME")

    /**
     * Column size
     *
     * Source column: COLUMN_SIZE
     */
    @get:SourceColumn("COLUMN_SIZE")
    val columnSize: MetadataInt = rs.getMetadataInt("COLUMN_SIZE")

    /**
     * The number of fractional digits
     *
     * Source column: DECIMAL_DIGITS
     */
    @get:SourceColumn("DECIMAL_DIGITS")
    val decimalDigits: MetadataInt = rs.getMetadataInt("DECIMAL_DIGITS")

    /**
     * Numeric precision radix, renamed
     *
     * Source column: NUM_PREC_RADIX
     */
    @get:SourceColumn("NUM_PREC_RADIX")
    val radix: MetadataInt = rs.getMetadataInt("NUM_PREC_RADIX")

    /**
     * Nullable, converted to [ColumnNullable]
     *
     * Source column: NULLABLE
     */
    @get:SourceColumn("NULLABLE")
    val nullable: ColumnNullable = rs.getIntegerEnum("NULLABLE")

    /**
     * Remarks
     *
     * Source column: REMARKS
     */
    @get:SourceColumn("REMARKS")
    val remarks: String? = rs.getString("REMARKS")

    /**
     * Column default
     *
     * Source column: COLUMN_DEF
     */
    @get:SourceColumn("COLUMN_DEF")
    val columnDefault: String? = rs.getString("COLUMN_DEF")

    /**
     * Character octet length
     *
     * Source column: CHAR_OCTET_LENGTH
     */
    @get:SourceColumn("CHAR_OCTET_LENGTH")
    val characterOctetLength: MetadataInt = rs.getMetadataInt("CHAR_OCTET_LENGTH")

    /**
     * Ordinal position
     *
     * Source column: ORDINAL_POSITION
     */
    @get:SourceColumn("ORDINAL_POSITION")
    val ordinalPosition: Int = rs.getInt("ORDINAL_POSITION")

    /**
     * Is nullable, converted to [IsNullable]
     *
     * Source column: IS_NULLABLE
     */
    @get:SourceColumn("IS_NULLABLE")
    val isNullable: IsNullable = rs.getStringEnum("IS_NULLABLE")

    /**
     * Scope catalog
     *
     * Source column: SCOPE_CATALOG
     */
    @get:SourceColumn("SCOPE_CATALOG")
    val scopeCatalog: String? = rs.getString("SCOPE_CATALOG")

    /**
     * Scope schema
     *
     * Source column: SCOPE_SCHEMA
     */
    @get:SourceColumn("SCOPE_SCHEMA")
    val scopeSchema: String? = rs.getString("SCOPE_SCHEMA")

    /**
     * Scope table
     *
     * Source column: SCOPE_TABLE
     */
    @get:SourceColumn("SCOPE_TABLE")
    val scopeTable: String? = rs.getString("SCOPE_TABLE")

    /**
     * Source data type of a distinct type or user-generated REF type, [JDBCType.NULL] if
     * [dataType] isn't [JDBCType.DISTINCT] or [JDBCType.REF]. Converted to [JDBCType] from short.
     *
     * Source column: SOURCE_DATA_TYPE
     */
    @get:SourceColumn("SOURCE_DATA_TYPE")
    val sourceDataType: JDBCType = rs.getJDBCType("SOURCE_DATA_TYPE")

    /**
     * Is autoincrement, converted to [IsAutoIncrement]
     *
     * Source column: IS_AUTOINCREMENT
     */
    @get:SourceColumn("IS_AUTOINCREMENT")
    val isAutoincrement: IsAutoIncrement = rs.getStringEnum("IS_AUTOINCREMENT")

    /**
     * Is generated column, converted to [IsGeneratedColumn]
     *
     * Source column :IS_GENERATEDCOLUMN
     */
    @get:SourceColumn("IS_GENERATEDCOLUMN")
    val isGeneratedColumn: IsGeneratedColumn = rs.getStringEnum("IS_GENERATEDCOLUMN")

    /**
     * Wrapper around [getColumnPrivileges](https://docs.oracle.com/en/java/javase/17/docs/api/java.sql/java/sql/DatabaseMetaData.html#getColumnPrivileges(java.lang.String,java.lang.String,java.lang.String,java.lang.String))
     * method and represents a list of [ColumnPrivilege]s for this column only
     *
     * @return
     */
    fun getColumnPrivileges(): List<ColumnPrivilege> = getIterableFromRs(
        metadata.getColumnPrivileges(catalog, schema, tableName, name)
    ) { ColumnPrivilege(it) }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Column

        if (catalog != other.catalog) return false
        if (schema != other.schema) return false
        if (tableName != other.tableName) return false
        if (name != other.name) return false
        if (ordinalPosition != other.ordinalPosition) return false

        return true
    }

    override fun hashCode(): Int {
        var result = catalog?.hashCode() ?: 0
        result = 31 * result + (schema?.hashCode() ?: 0)
        result = 31 * result + (tableName?.hashCode() ?: 0)
        result = 31 * result + name.hashCode()
        result = 31 * result + ordinalPosition
        return result
    }
}