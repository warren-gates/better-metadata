/*
 * Copyright (c) 2022. Warren Gates
 * All rights reserved.
 */

package dev.warrengates.bettermetadata

import java.sql.JDBCType
import java.sql.ResultSet

/**
 * Wrapper for results of [getFunctionColumns](https://docs.oracle.com/en/java/javase/17/docs/api/java.sql/java/sql/DatabaseMetaData.html#getFunctionColumns(java.lang.String,java.lang.String,java.lang.String,java.lang.String))
 * method and represents a column of [Function]
 *
 * @constructor
 *
 * @param rs
 */
class FunctionColumn(rs: ResultSet) {
    /**
     * Catalog
     *
     * Source column: FUNCTION_CAT
     */
    val catalog: String? = rs.getString("FUNCTION_CAT")

    /**
     * Schema
     *
     * Source column: FUNCTION_SCHEM
     */
    val schema: String? = rs.getString("FUNCTION_SCHEM")

    /**
     * Function name
     *
     * Source column: FUNCTION_NAME
     */
    val functionName: String = rs.getString("FUNCTION_NAME")

    /**
     * Name
     *
     * Source column: COLUMN_NAME
     */
    val name: String = rs.getString("COLUMN_NAME")

    /**
     * Column type, converted to [FunctionColumnType]
     *
     * Source column: COLUMN_TYPE
     */
    val columnType: FunctionColumnType = rs.getIntegerEnum("COLUMN_TYPE")

    /**
     * SQL type from [java.sql.Types], converted from int
     *
     * Source column: DATA_TYPE
     */
    val dataType: JDBCType = rs.getJDBCType("DATA_TYPE")

    /**
     * Type name
     *
     * Source column: TYPE_NAME
     */
    val typeName: String? = rs.getString("TYPE_NAME")

    /**
     * Precision
     *
     * Source column: PRECISION
     */
    val precision: MetadataInt = rs.getMetadataInt("PRECISION")

    /**
     * Length
     *
     * Source column: LENGTH
     */
    val length: Int = rs.getInt("LENGTH")

    /**
     * Scale
     *
     * Source column: SCALE
     */
    val scale: MetadataInt = rs.getMetadataInt("SCALE")

    /**
     * Radix
     *
     * Source column: RADIX
     */
    val radix: MetadataInt = rs.getMetadataInt("RADIX")

    /**
     * Nullable, converted to [FunctionColumnNullable]
     *
     * Source column: NULLABLE
     */
    val nullable: FunctionColumnNullable = rs.getIntegerEnum("NULLABLE")

    /**
     * Remarks
     *
     * Source column: REMARKS
     */
    val remarks: String? = rs.getString("REMARKS")

    /**
     * Character octet length
     *
     * Source column: CHAR_OCTET_LENGTH
     */
    val characterOctetLength: MetadataInt = rs.getMetadataInt("CHAR_OCTET_LENGTH")

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
     * Specific name
     *
     * Source column: SPECIFIC_NAME
     */
    val specificName: String? = rs.getString("SPECIFIC_NAME")
}