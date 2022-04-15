/*
 * Copyright (c) 2022. Warren Gates
 * All rights reserved.
 */

package dev.warrengates.bettermetadata

import java.sql.DatabaseMetaData
import java.sql.JDBCType
import java.sql.ResultSet

/**
 * Column represents a [Table] column
 *
 * @property metadata
 * @constructor
 *
 * @param rs
 */
@Suppress("unused")
class Column(private val metadata: DatabaseMetaData, rs: ResultSet) {
    /**
     * Containing Table's catalog
     */
    val catalog: String? = rs.getString("TABLE_CAT")

    /**
     * Containing Table's schema
     */
    val schema: String? = rs.getString("TABLE_SCHEM")

    /**
     * Containing Table's name
     */
    val tableName: String? = rs.getString("TABLE_NAME")

    /**
     * Column name
     */
    val name: String = rs.getString("COLUMN_NAME")

    /**
     * SQL type from [java.sql.Types]
     */
    val dataType: JDBCType = rs.getJDBCType("DATA_TYPE")

    /**
     * Data source dependent type name, for [UserDefinedType] the type name is fully qualified
     */
    val typeName: String? = rs.getString("TYPE_NAME")

    /**
     * Column size
     */
    val columnSize = rs.getInt("COLUMN_SIZE")

    // unused
//    val bufferLength: String? = rs.getString("BUFFER_LENGTH")

    /**
     * The number of fractional digits, null is returned when decimalDigits is not applicable
     */
    val decimalDigits: MetadataInt = rs.getMetadataInt("DECIMAL_DIGITS")

    /**
     * Numeric precision radix
     */
    val numericPrecisionRadix: MetadataInt = rs.getMetadataInt("NUM_PREC_RADIX")

    /**
     * Nullable
     */
    val nullable: ColumnNullable = rs.getIntegerEnum("NULLABLE")

    /**
     * Remarks
     */
    val remarks: String? = rs.getString("REMARKS")

    /**
     * Column default
     */
    val columnDefault: String? = rs.getString("COLUMN_DEF")

    // unused
//    val sqlDataType: Int = rs.getInt("SQL_DATA_TYPE")
//    val sqlDatetimeSub = rs.getInt("SQL_DATETIME_SUB")

    /**
     * Character octet length
     */
    val characterOctetLength: String? = rs.getString("CHAR_OCTET_LENGTH")

    /**
     * Ordinal position
     */
    val ordinalPosition: Int = rs.getInt("ORDINAL_POSITION")

    /**
     * Is nullable
     */
    val isNullable: IsNullable = rs.getStringEnum("IS_NULLABLE")

    /**
     * Scope catalog
     */
    val scopeCatalog: String? = rs.getString("SCOPE_CATALOG")

    /**
     * Scope schema
     */
    val scopeSchema: String? = rs.getString("SCOPE_SCHEMA")

    /**
     * Scope table
     */
    val scopeTable: String? = rs.getString("SCOPE_TABLE")

    /**
     * Source data type
     */
    val sourceDataType: JDBCType = rs.getJDBCType("SOURCE_DATA_TYPE")

    /**
     * Is autoincrement
     */
    val isAutoincrement: IsAutoIncrement = rs.getStringEnum("IS_AUTOINCREMENT")

    /**
     * Is generated column
     */
    val isGeneratedColumn: IsGeneratedColumn = rs.getStringEnum("IS_GENERATEDCOLUMN")

    /**
     * Get column privileges
     *
     * @return
     */
    fun getColumnPrivileges(): List<ColumnPrivilege> = getIterableFromRs(
        metadata.getColumnPrivileges(catalog, schema, tableName, name)
    ) { ColumnPrivilege(it) }
}