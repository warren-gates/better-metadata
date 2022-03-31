package dev.warrengates.databasemetadata

import java.sql.JDBCType
import java.sql.ResultSet

@Suppress("unused")
class BestRowIdentifier(rs: ResultSet) {
    val scope: BestRowIdentifierScope = valueOf(rs.getShort("SCOPE").toInt())
    val columnName: String? = rs.getString("COLUMN_NAME")
    val dataType: JDBCType = JDBCType.valueOf(rs.getShort("DATA_TYPE").toInt())
    val typeName: String? = rs.getString("TYPE_NAME")
    val columnSize: Int = rs.getInt("COLUMN_SIZE")

    // unused
//    val bufferLength: Int = rs.getInt("BUFFER_LENGTH")

    val decimalDigits: Short = rs.getShort("DECIMAL_DIGITS")
    val pseudoColumn: BestRowColumnType = valueOf(rs.getShort("PSEUDO_COLUMN").toInt())
}