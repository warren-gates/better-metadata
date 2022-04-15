package dev.warrengates.bettermetadata

import java.sql.JDBCType
import java.sql.ResultSet

/**
 * Version column
 *
 * @constructor
 *
 * @param rs
 */
class VersionColumn(rs: ResultSet) {
    /**
     * Column name
     */// scope is not used per https://docs.oracle.com/en/java/javase/17/docs/api/java.sql/java/sql/DatabaseMetaData.html#getVersionColumns(java.lang.String,java.lang.String,java.lang.String)
//    val scope: Short = rs.getShort("SCOPE")
    val columnName: String = rs.getString("COLUMN_NAME")

    /**
     * SQL type from [java.sql.Types]
     */
    val dataType: JDBCType = rs.getJDBCType("DATA_TYPE")

    /**
     * Type name
     */
    val typeName: String? = rs.getString("TYPE_NAME")

    /**
     * Column size
     */
    val columnSize: Int = rs.getInt("COLUMN_SIZE")

    /**
     * Buffer length
     */
    val bufferLength: Int = rs.getInt("BUFFER_LENGTH")

    /**
     * The number of fractional digits, null is returned when decimalDigits is not applicable
     */
    val decimalDigits: Int? = rs.getObject("DECIMAL_DIGITS", Int::class.java)

    /**
     * Pseudo column
     */
    val pseudoColumn: VersionColumnType = rs.getEnum("PSEUDO_COLUMN")
}