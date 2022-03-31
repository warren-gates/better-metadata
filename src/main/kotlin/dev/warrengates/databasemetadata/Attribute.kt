package dev.warrengates.databasemetadata

import java.sql.JDBCType
import java.sql.ResultSet

class Attribute(rs: ResultSet) {
    val catalog: String? = rs.getString("TYPE_CAT")
    val schema: String? = rs.getString("TYPE_SCHEM")
    val typeName: String? = rs.getString("TYPE_NAME")
    val name: String? = rs.getString("ATTR_NAME")
    val dataType: JDBCType = JDBCType.valueOf(rs.getInt("DATA_TYPE"))
    val attrTypeName: String? = rs.getString("ATTR_TYPE_NAME")
    val attrSize: Int = rs.getInt("ATTR_SIZE")
    val decimalDigits: Int = rs.getInt("DECIMAL_DIGITS")
    val numericPrecisionRadix: Int = rs.getInt("NUM_PREC_RADIX")
    val nullable: AttributeNullable = valueOf(rs.getInt("NULLABLE"))
    val remarks: String? = rs.getString("REMARKS")
    val attributeDefault: String? = rs.getString("ATTR_DEF")

    // unused
//    val sqlDataType: Int? = rs.getInt("SQL_DATA_TYPE")
//    val sqlDatetimeSub: Int? = rs.getInt("SQL_DATETIME_SUB")

    val characterOctetLength: Int = rs.getInt("CHAR_OCTET_LENGTH")
    val ordinalPosition: Int = rs.getInt("ORDINAL_POSITION")
    val isNullable: String? = rs.getString("IS_NULLABLE")
    val scopeCatalog: String? = rs.getString("SCOPE_CATALOG")
    val scopeSchema: String? = rs.getString("SCOPE_SCHEMA")
    val scopeTable: String? = rs.getString("SCOPE_TABLE")
    val sourceDataType: Short = rs.getShort("SOURCE_DATA_TYPE")
}