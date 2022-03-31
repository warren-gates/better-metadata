package dev.warrengates.databasemetadata

import java.sql.ResultSet

@Suppress("unused")
class Schema(rs: ResultSet) {
    val name: String = rs.getString("TABLE_SCHEM")
    val catalog: String? = rs.getString("TABLE_CATALOG")
}