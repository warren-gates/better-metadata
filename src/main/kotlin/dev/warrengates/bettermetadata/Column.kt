/*
 * Copyright (c) 2022. Warren Gates
 * All rights reserved.
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
@Suppress("unused", "MemberVisibilityCanBePrivate")
class Column(private val metadata: DatabaseMetaData, rs: ResultSet) {
    /**
     * Containing Table's catalog
     *
     * Source column: TABLE_CAT
     */
    val catalog: String? = rs.getString("TABLE_CAT")

    /**
     * Containing Table's schema
     *
     * Source column: TABLE_SCHEM
     */
    val schema: String? = rs.getString("TABLE_SCHEM")

    /**
     * Containing Table's name
     *
     * Source column: TABLE_NAME
     */
    val tableName: String? = rs.getString("TABLE_NAME")

    /**
     * Column name
     *
     * Source column: COLUMN_NAME
     */
    val name: String = rs.getString("COLUMN_NAME")

    /**
     * SQL type from [java.sql.Types], converted from int
     *
     * Source column: DATA_TYPE
     */
    val dataType: JDBCType = rs.getJDBCType("DATA_TYPE")

    /**
     * Data source dependent type name, for [UserDefinedType] the type name is fully qualified
     *
     * Source column: TYPE_NAME
     */
    val typeName: String? = rs.getString("TYPE_NAME")

    /**
     * Column size
     *
     * Source column: COLUMN_SIZE
     */
    val columnSize: Int = rs.getInt("COLUMN_SIZE")

    // unused
//    val bufferLength: String? = rs.getString("BUFFER_LENGTH")

    /**
     * The number of fractional digits
     *
     * Source column: DECIMAL_DIGITS
     */
    val decimalDigits: MetadataInt = rs.getMetadataInt("DECIMAL_DIGITS")

    /**
     * Numeric precision radix, renamed
     *
     * Source column: NUM_PREC_RADIX
     */
    val radix: MetadataInt = rs.getMetadataInt("NUM_PREC_RADIX")

    /**
     * Nullable, converted to [ColumnNullable]
     *
     * Source column: NULLABLE
     */
    val nullable: ColumnNullable = rs.getIntegerEnum("NULLABLE")

    /**
     * Remarks
     *
     * Source column: REMARKS
     */
    val remarks: String? = rs.getString("REMARKS")

    /**
     * Column default
     *
     * Source column: COLUMN_DEF
     */
    val columnDefault: String? = rs.getString("COLUMN_DEF")

    // unused
//    val sqlDataType: Int = rs.getInt("SQL_DATA_TYPE")
//    val sqlDatetimeSub = rs.getInt("SQL_DATETIME_SUB")

    /**
     * Character octet length
     *
     * Source column: CHAR_OCTET_LENGTH
     */
    val characterOctetLength: String? = rs.getString("CHAR_OCTET_LENGTH")

    /**
     * Ordinal position
     *
     * Source column: ORDINAL_POSITION
     */
    val ordinalPosition: Int = rs.getInt("ORDINAL_POSITION")

    /**
     * Is nullable, converted to [IsNullable]
     *
     * Source column: IS_NULLABLE
     */
    val isNullable: IsNullable = rs.getStringEnum("IS_NULLABLE")

    /**
     * Scope catalog
     *
     * Source column: SCOPE_CATALOG
     */
    val scopeCatalog: String? = rs.getString("SCOPE_CATALOG")

    /**
     * Scope schema
     *
     * Source column: SCOPE_SCHEMA
     */
    val scopeSchema: String? = rs.getString("SCOPE_SCHEMA")

    /**
     * Scope table
     *
     * Source column: SCOPE_TABLE
     */
    val scopeTable: String? = rs.getString("SCOPE_TABLE")

    /**
     * Source data type
     *
     * Source column: SOURCE_DATA_TYPE
     */
    val sourceDataType: JDBCType = rs.getJDBCType("SOURCE_DATA_TYPE")

    /**
     * Is autoincrement, converted to [IsAutoIncrement]
     *
     * Source column: IS_AUTOINCREMENT
     */
    val isAutoincrement: IsAutoIncrement = rs.getStringEnum("IS_AUTOINCREMENT")

    /**
     * Is generated column, converted to [IsGeneratedColumn]
     *
     * Source column :IS_GENERATEDCOLUMN
     */
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
}