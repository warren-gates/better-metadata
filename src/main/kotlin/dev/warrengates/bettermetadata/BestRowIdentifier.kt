/*
 * Copyright (c) 2022. Warren Gates
 * All rights reserved.
 */

package dev.warrengates.bettermetadata

import java.sql.JDBCType
import java.sql.ResultSet

/**
 * Wrapper for results of [getBestRowIdentifier](https://docs.oracle.com/en/java/javase/17/docs/api/java.sql/java/sql/DatabaseMetaData.html#getBestRowIdentifier(java.lang.String,java.lang.String,java.lang.String,int,boolean))
 * method and represents the optimal set of columns that uniquely identify a [Table]'s row
 *
 * Note that per the documentation BUFFER_LENGTH is unused and has been left out of this class
 *
 * @constructor
 *
 * @param rs
 */
@Suppress("unused")
class BestRowIdentifier(rs: ResultSet) {
    /**
     * Scope of result, converted to [BestRowIdentifierScope]
     *
     * Source column: SCOPE
     */
    val scope: BestRowIdentifierScope = rs.getIntegerEnum("SCOPE")

    /**
     * Column name
     *
     * Source column: COLUMN_NAME
     */
    val columnName: String? = rs.getString("COLUMN_NAME")

    /**
     * SQL type from [java.sql.Types], converted from int
     *
     * Source column: DATA_TYPE
     */
    val dataType: JDBCType = rs.getJDBCType("DATA_TYPE")

    /**
     * Data source dependent type name, for a [UserDefinedType] the type name
     * is fully qualified
     *
     * Source column: TYPE_NAME
     */
    val typeName: String? = rs.getString("TYPE_NAME")

    /**
     * Precision
     *
     * Source column: COLUMN_SIZE
     */
    val columnSize: Int = rs.getInt("COLUMN_SIZE")

    // unused
//    val bufferLength: Int = rs.getInt("BUFFER_LENGTH")

    /**
     * The number of fractional digits
     *
     * Source column: DECIMAL_DIGITS
     */
    val decimalDigits: MetadataInt = rs.getMetadataInt("DECIMAL_DIGITS")

    /**
     * Indicates whether this is a pseudo column like an Oracle ROWID, converted
     * to [BestRowColumnType]
     *
     * Source column: PSEUDO_COLUMN
     */
    val pseudoColumn: BestRowColumnType = rs.getIntegerEnum("PSEUDO_COLUMN")
}