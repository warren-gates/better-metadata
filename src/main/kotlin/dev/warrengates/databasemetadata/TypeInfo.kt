package dev.warrengates.databasemetadata

import java.sql.JDBCType
import java.sql.ResultSet

class TypeInfo(rs: ResultSet) {
    val name: String = rs.getString("TYPE_NAME")
    val dataType: JDBCType = JDBCType.valueOf(rs.getShort("DATA_TYPE").toInt())
    val precision: Int = rs.getInt("PRECISION")
    val literalPrefix: String? = rs.getString("LITERAL_PREFIX")
    val literalSuffix: String? = rs.getString("LITERAL_SUFFIX")
    val createParams: String? = rs.getString("CREATE_PARAMS")
    val nullable: TypeNullable = valueOf<TypeNullable>(rs.getShort("NULLABLE").toInt())
    val caseSensitive: Boolean = rs.getBoolean("CASE_SENSITIVE")
    val searchable: TypeSearchable = valueOf<TypeSearchable>(rs.getShort("SEARCHABLE").toInt())

    val isUnsigned: Boolean = rs.getBoolean("UNSIGNED_ATTRIBUTE")
    val fixedPrecisionScale: Boolean = rs.getBoolean("FIXED_PREC_SCALE")
    val autoIncrement: Boolean = rs.getBoolean("AUTO_INCREMENT")
    val localTypeName: String? = rs.getString("LOCAL_TYPE_NAME")
    val minimumScale: Short = rs.getShort("MINIMUM_SCALE")
    val maximumScale: Short = rs.getShort("MAXIMUM_SCALE")

    // unused per https://docs.oracle.com/en/java/javase/17/docs/api/java.sql/java/sql/DatabaseMetaData.html#getTypeInfo()
//    val sqlDataType: Int = rs.getInt("SQL_DATA_TYPE")
//    val sqlDatetimeSub: Int = rs.getInt("SQL_DATETIME_SUB")

    val numericPrecisionRadix: Int = rs.getInt("NUM_PREC_RADIX")
}