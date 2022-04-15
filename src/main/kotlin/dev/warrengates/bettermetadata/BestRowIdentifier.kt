/*
 * Copyright (c) 2022. Warren Gates
 * All rights reserved.
 */

package dev.warrengates.bettermetadata

import java.sql.JDBCType
import java.sql.ResultSet

/**
 * Best row identifier
 *
 * @constructor
 *
 * @param rs
 */
@Suppress("unused")
class BestRowIdentifier(rs: ResultSet) {
    /**
     * Scope of result
     */
    val scope: BestRowIdentifierScope = rs.getIntegerEnum("SCOPE")

    /**
     * Column name
     */
    val columnName: String? = rs.getString("COLUMN_NAME")

    /**
     * SQL type from [java.sql.Types]
     */
    val dataType: JDBCType = rs.getJDBCType("DATA_TYPE")

    /**
     * Data source dependent type name, for a [UserDefinedType] the type name
     * is fully qualified
     */
    val typeName: String? = rs.getString("TYPE_NAME")

    /**
     * Precision
     */
    val columnSize: Int = rs.getInt("COLUMN_SIZE")

    // unused
//    val bufferLength: Int = rs.getInt("BUFFER_LENGTH")

    /**
     * The number of fractional digits, null is returned when decimalDigits is not applicable
     */
    val decimalDigits: Int? = rs.getObject("DECIMAL_DIGITS", Int::class.java)

    /**
     * Indicates whether this is a pseudo column like an Oracle ROWID
     */
    val pseudoColumn: BestRowColumnType = rs.getIntegerEnum("PSEUDO_COLUMN")
}