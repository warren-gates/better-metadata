package dev.warrengates.databasemetadata

import java.sql.DatabaseMetaData
import java.sql.JDBCType
import java.sql.ResultSet

@Suppress("unused")
class UserDefinedType(private val metaData: DatabaseMetaData, rs: ResultSet) {
    val catalog: String? = rs.getString("TYPE_CAT")
    val schema: String = rs.getString("TYPE_SCHEM")
    val name: String = rs.getString("TYPE_NAME")
    val className: String? = rs.getString("CLASS_NAME")
    val dataType: JDBCType = JDBCType.valueOf(rs.getShort("DATA_TYPE").toInt())
    val remarks: String? = rs.getString("REMARKS")
    val baseType: Int = rs.getInt("BASE_TYPE")

    fun getAttributes(attributeNamePattern: String?): List<Attribute> {
        return getIterableFromRs(
            metaData.getAttributes(catalog, schema, name, attributeNamePattern)
        ) { x -> Attribute(x) }
    }
}