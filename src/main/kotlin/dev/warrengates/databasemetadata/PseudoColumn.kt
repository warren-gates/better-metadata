package dev.warrengates.databasemetadata

import java.sql.JDBCType
import java.sql.PseudoColumnUsage
import java.sql.ResultSet

/**
 * Pseudo column
 *
 * @constructor
 *
 * @param rs
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
     * SQL type from [java.sql.Types]
     */
    val dataType: JDBCType = rs.getJDBCType("DATA_TYPE")

    /**
     * Column size
     */
    val columnSize: Int = rs.getInt("COLUMN_SIZE")

    /**
     * The number of fractional digits, null is returned when decimalDigits is not applicable
     */
    val decimalDigits: MetadataInt = rs.getMetadataInt("DECIMAL_DIGITS")

    /**
     * Numeric precision radix
     */
    val numericPrecisionRadix: Int = rs.getInt("NUM_PREC_RADIX")

    /**
     * Column usage
     */
    val columnUsage: PseudoColumnUsage = PseudoColumnUsage.valueOf(rs.getString("COLUMN_USAGE"))

    /**
     * Remarks
     */
    val remarks: String? = rs.getString("REMARKS")

    /**
     * Character octet length
     */
    val characterOctetLength: Int = rs.getInt("CHAR_OCTET_LENGTH")

    /**
     * Is nullable
     */
    val isNullable: String? = rs.getString("IS_NULLABLE")
}