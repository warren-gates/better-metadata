/*
 * Copyright (c) 2022. Warren Gates
 * All rights reserved.
 */

package dev.warrengates.bettermetadata

import java.sql.JDBCType
import java.sql.ResultSet

/**
 * Wrapper for results of [getVersionColumns](https://docs.oracle.com/en/java/javase/17/docs/api/java.sql/java/sql/DatabaseMetaData.html#getVersionColumns(java.lang.String,java.lang.String,java.lang.String))
 *
 * Note that per the documentation SCOPE is unused and has
 * been left out of this class
 */
class VersionColumn(rs: ResultSet) {

    /**
     * Column name
     *
     * Source column: COLUMN_NAME
     */
    val columnName: String = rs.getString("COLUMN_NAME")

    /**
     * SQL type, converted to [JDBCType]
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
     * Column size
     *
     * Source column: COLUMN_SIZE
     */
    val columnSize: MetadataInt = rs.getMetadataInt("COLUMN_SIZE")

    /**
     * Buffer length
     *
     * Source column: BUFFER_LENGTH
     */
    val bufferLength: Int = rs.getInt("BUFFER_LENGTH")

    /**
     * The number of fractional digits
     *
     * Source column: DECIMAL_DIGITS
     */
    val decimalDigits: MetadataInt = rs.getMetadataInt("DECIMAL_DIGITS")

    /**
     * Pseudo column, converted to [VersionColumnType]
     *
     * Source column: PSEUDO_COLUMN
     */
    val pseudoColumn: VersionColumnType = rs.getIntegerEnum("PSEUDO_COLUMN")
}