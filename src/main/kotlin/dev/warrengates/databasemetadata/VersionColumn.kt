package dev.warrengates.databasemetadata

import java.sql.JDBCType
import java.sql.ResultSet

class VersionColumn(rs: ResultSet) {
    // scope is not used per https://docs.oracle.com/en/java/javase/17/docs/api/java.sql/java/sql/DatabaseMetaData.html#getVersionColumns(java.lang.String,java.lang.String,java.lang.String)
//    val scope: Short = rs.getShort("SCOPE")
    val columnName: String = rs.getString("COLUMN_NAME")
    val dataType: JDBCType = JDBCType.valueOf(rs.getShort("DATA_TYPE").toInt())
    val typeName: String? = rs.getString("TYPE_NAME")
    val columnSize: Int = rs.getInt("COLUMN_SIZE")
    val bufferLength: Int = rs.getInt("BUFFER_LENGTH")
    val decimalDigits: Short = rs.getShort("DECIMAL_DIGITS")
    val pseudoColumn: VersionColumnType = valueOf(rs.getShort("PSEUDO_COLUMN").toInt())
}