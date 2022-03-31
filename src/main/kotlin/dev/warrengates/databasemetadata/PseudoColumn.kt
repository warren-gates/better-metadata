package dev.warrengates.databasemetadata

import java.sql.JDBCType
import java.sql.PseudoColumnUsage
import java.sql.ResultSet

class PseudoColumn(rs: ResultSet) {
    val catalog: String? = rs.getString("TABLE_CAT")
    val schema: String? = rs.getString("TABLE_SCHEM")
    val tableName: String? = rs.getString("TABLE_NAME")
    val name: String? = rs.getString("COLUMN_NAME")
    val dataType: JDBCType = JDBCType.valueOf(rs.getInt("DATA_TYPE"))
    val columnSize: Int = rs.getInt("COLUMN_SIZE")
    val decimalDigits: Int = rs.getInt("DECIMAL_DIGITS")
    val numericPrecisionRadix: Int = rs.getInt("NUM_PREC_RADIX")
    val columnUsage: PseudoColumnUsage = PseudoColumnUsage.valueOf(rs.getString("COLUMN_USAGE"))
    val remarks: String? = rs.getString("REMARKS")
    val characterOctetLength: Int = rs.getInt("CHAR_OCTET_LENGTH")
    val isNullable: String? = rs.getString("IS_NULLABLE")
}