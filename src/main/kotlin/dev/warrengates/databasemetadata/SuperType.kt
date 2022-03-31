package dev.warrengates.databasemetadata

import java.sql.ResultSet

class SuperType(rs: ResultSet) {
    val catalog: String? = rs.getString("TYPE_CAT")
    val schema: String = rs.getString("TYPE_SCHEM")
    val name: String = rs.getString("TYPE_NAME")
    val superTypeCatalog: String? = rs.getString("SUPERTYPE_CAT")
    val superTypeSchema: String = rs.getString("SUPERTYPE_SCHEM")
    val superTypeName: String = rs.getString("SUPERTYPE_NAME")
}