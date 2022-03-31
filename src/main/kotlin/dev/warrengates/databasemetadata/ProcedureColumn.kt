package dev.warrengates.databasemetadata

import java.sql.JDBCType
import java.sql.ResultSet

class ProcedureColumn(rs: ResultSet) {
    val catalog: String? = rs.getString("PROCEDURE_CAT")
    val schema: String? = rs.getString("PROCEDURE_SCHEM")
    val procedureName: String? = rs.getString("PROCEDURE_NAME")
    val name: String = rs.getString("COLUMN_NAME")
    val columnType: ProcedureColumnType = valueOf(rs.getShort("COLUMN_TYPE").toInt())
    val dataType: JDBCType = JDBCType.valueOf(rs.getShort("DATA_TYPE").toInt())
    val typeName: String? = rs.getString("TYPE_NAME")
    val precision: Int = rs.getInt("PRECISION")
    val length: Int = rs.getInt("LENGTH")
    val scale: Short = rs.getShort("SCALE")
    val radix: Short = rs.getShort("RADIX")
    val nullable: ProcedureColumnNullable = valueOf(rs.getShort("NULLABLE").toInt())
    val remarks: String? = rs.getString("REMARKS")
    val columnDefault: String? = rs.getString("COLUMN_DEF")

    // following reserved for future use per https://docs.oracle.com/en/java/javase/17/docs/api/java.sql/java/sql/DatabaseMetaData.html#getProcedureColumns(java.lang.String,java.lang.String,java.lang.String,java.lang.String)
//    val sqlDataType: Int = rs.getInt("SQL_DATA_TYPE")
//    val sqlDatetimeSub: Int = rs.getInt("SQL_DATETIME_SUB")

    val characterOctetLength: Int = rs.getInt("CHAR_OCTET_LENGTH")
    val ordinalPosition: Int = rs.getInt("ORDINAL_POSITION")
    val isNullable: String? = rs.getString("IS_NULLABLE")
    val specificName: String? = rs.getString("SPECIFIC_NAME")
}