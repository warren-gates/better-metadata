package dev.warrengates.databasemetadata

import java.sql.JDBCType
import java.sql.ResultSet

class FunctionColumn(rs: ResultSet) {
    val catalog: String? = rs.getString("FUNCTION_CAT")
    val schema: String? = rs.getString("FUNCTION_SCHEM")
    val functionName: String = rs.getString("FUNCTION_NAME")
    val name: String = rs.getString("COLUMN_NAME")
    val columnType: FunctionColumnType = valueOf(rs.getShort("COLUMN_TYPE").toInt())
    val dataType: JDBCType = JDBCType.valueOf(rs.getShort("DATA_TYPE").toInt())
    val typeName: String? = rs.getString("TYPE_NAME")
    val precision: Short = rs.getShort("PRECISION")
    val length: Int = rs.getInt("LENGTH")
    val scale: Short = rs.getShort("SCALE")
    // TODO: rename to numericPrecisionRadix or change others to radix
    val radix: Short = rs.getShort("RADIX")
    val nullable: FunctionColumnNullable = valueOf(rs.getShort("NULLABLE").toInt())
    val remarks: String? = rs.getString("REMARKS")
    val characterOctetLength: Int = rs.getInt("CHAR_OCTET_LENGTH")
    val ordinalPosition: Int = rs.getInt("ORDINAL_POSITION")
    // TODO: change all 'isNullable' to enum?
    val isNullable: String? = rs.getString("IS_NULLABLE")
    val specificName: String? = rs.getString("SPECIFIC_NAME")
}