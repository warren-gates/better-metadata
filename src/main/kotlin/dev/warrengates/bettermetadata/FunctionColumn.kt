/*
 * Copyright (c) 2022. Warren Gates
 * All rights reserved.
 */

package dev.warrengates.bettermetadata

import java.sql.JDBCType
import java.sql.ResultSet

/**
 * Function column
 *
 * @constructor
 *
 * @param rs
 */
class FunctionColumn(rs: ResultSet) {
    /**
     * Catalog
     */
    val catalog: String? = rs.getString("FUNCTION_CAT")

    /**
     * Schema
     */
    val schema: String? = rs.getString("FUNCTION_SCHEM")

    /**
     * Function name
     */
    val functionName: String = rs.getString("FUNCTION_NAME")

    /**
     * Name
     */
    val name: String = rs.getString("COLUMN_NAME")

    /**
     * Column type
     */
    val columnType: FunctionColumnType = rs.getEnum("COLUMN_TYPE")

    /**
     * SQL type from [java.sql.Types]
     */
    val dataType: JDBCType = rs.getJDBCType("DATA_TYPE")

    /**
     * Type name
     */
    val typeName: String? = rs.getString("TYPE_NAME")

    /**
     * Precision
     */
    val precision: Short = rs.getShort("PRECISION")

    /**
     * Length
     */
    val length: Int = rs.getInt("LENGTH")

    /**
     * Scale
     */
    val scale: Short = rs.getShort("SCALE")

    /**
     * Radix
     */// TODO: rename to numericPrecisionRadix or change others to radix
    val radix: Short = rs.getShort("RADIX")

    /**
     * Nullable
     */
    val nullable: FunctionColumnNullable = rs.getEnum("NULLABLE")

    /**
     * Remarks
     */
    val remarks: String? = rs.getString("REMARKS")

    /**
     * Character octet length
     */
    val characterOctetLength: Int = rs.getInt("CHAR_OCTET_LENGTH")

    /**
     * Ordinal position
     */
    val ordinalPosition: Int = rs.getInt("ORDINAL_POSITION")

    /**
     * Is nullable
     */// TODO: change all 'isNullable' to enum?
    val isNullable: String? = rs.getString("IS_NULLABLE")

    /**
     * Specific name
     */
    val specificName: String? = rs.getString("SPECIFIC_NAME")
}