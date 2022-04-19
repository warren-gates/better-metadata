/*
 * Copyright (c) 2022. Warren Gates
 * All rights reserved.
 */

package dev.warrengates.bettermetadata

import java.sql.JDBCType
import java.sql.PseudoColumnUsage
import java.sql.ResultSet

/**
 * Wrapper for results of [getPseudoColumns](https://docs.oracle.com/en/java/javase/17/docs/api/java.sql/java/sql/DatabaseMetaData.html#getPseudoColumns(java.lang.String,java.lang.String,java.lang.String,java.lang.String))
 *
 */
class PseudoColumn(rs: ResultSet) {
    /**
     * Catalog
     */
    val catalog: String? = rs.getString("TABLE_CAT")

    /**
     * Schema
     */
    val schema: String? = rs.getString("TABLE_SCHEM")

    /**
     * Table name
     */
    val tableName: String? = rs.getString("TABLE_NAME")

    /**
     * Name
     */
    val name: String? = rs.getString("COLUMN_NAME")

    /**
     * SQL type, converted to [JDBCType]
     */
    val dataType: JDBCType = rs.getJDBCType("DATA_TYPE")

    /**
     * Column size
     */
    val columnSize: MetadataInt = rs.getMetadataInt("COLUMN_SIZE")

    /**
     * The number of fractional digits
     */
    val decimalDigits: MetadataInt = rs.getMetadataInt("DECIMAL_DIGITS")

    /**
     * Numeric precision radix
     */
    val radix: MetadataInt = rs.getMetadataInt("NUM_PREC_RADIX")

    /**
     * Column usage, converted to [PseudoColumnUsage]
     */
    val columnUsage: PseudoColumnUsage = PseudoColumnUsage.valueOf(rs.getString("COLUMN_USAGE"))

    /**
     * Remarks
     */
    val remarks: String? = rs.getString("REMARKS")

    /**
     * Character octet length
     */
    val characterOctetLength: MetadataInt = rs.getMetadataInt("CHAR_OCTET_LENGTH")

    /**
     * Is nullable, converted to [IsNullable]
     */
    val isNullable: IsNullable = rs.getStringEnum("IS_NULLABLE")
}