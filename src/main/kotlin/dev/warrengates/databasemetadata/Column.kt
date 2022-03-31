package dev.warrengates.databasemetadata

import java.sql.DatabaseMetaData
import java.sql.JDBCType
import java.sql.ResultSet

@Suppress("unused")
class Column(private val metadata: DatabaseMetaData, rs: ResultSet) {
    // for unused see https://docs.oracle.com/en/java/javase/17/docs/api/java.sql/java/sql/DatabaseMetaData.html#getColumns(java.lang.String,java.lang.String,java.lang.String,java.lang.String)
    val catalog: String? = rs.getString("TABLE_CAT")
    val schema: String? = rs.getString("TABLE_SCHEM")
    val tableName: String? = rs.getString("TABLE_NAME")
    val name: String = rs.getString("COLUMN_NAME")
    val dataType: JDBCType = JDBCType.valueOf(rs.getShort("DATA_TYPE").toInt())
    val typeName: String? = rs.getString("TYPE_NAME")
    val columnSize = rs.getInt("COLUMN_SIZE")

    // unused
//    val bufferLength: String? = rs.getString("BUFFER_LENGTH")

    val decimalDigits: Int = rs.getInt("DECIMAL_DIGITS")
    val numericPrecisionRadix: Int = rs.getInt("NUM_PREC_RADIX")
    val nullable: ColumnNullable = valueOf(rs.getInt("NULLABLE"))
    val remarks: String? = rs.getString("REMARKS")
    val columnDefault: String? = rs.getString("COLUMN_DEF")

    // unused
//    val sqlDataType: Int = rs.getInt("SQL_DATA_TYPE")
//    val sqlDatetimeSub = rs.getInt("SQL_DATETIME_SUB")

    val characterOctetLength: String? = rs.getString("CHAR_OCTET_LENGTH")
    val ordinalPosition = rs.getInt("ORDINAL_POSITION")
    val isNullable: String? = rs.getString("IS_NULLABLE")
    val scopeCatalog: String? = rs.getString("SCOPE_CATALOG")
    val scopeSchema: String? = rs.getString("SCOPE_SCHEMA")
    val scopeTable: String? = rs.getString("SCOPE_TABLE")
    val sourceDataType = rs.getShort("SOURCE_DATA_TYPE")

    // TODO: make these two enums
    val isAutoincrement: String? = rs.getString("IS_AUTOINCREMENT")
    val isGeneratedColumn: String? = rs.getString("IS_GENERATEDCOLUMN")

    fun getColumnPrivileges(): List<ColumnPrivilege> = getIterableFromRs(
        metadata.getColumnPrivileges(catalog, schema, tableName, name)
    ) { ColumnPrivilege(it) }
}