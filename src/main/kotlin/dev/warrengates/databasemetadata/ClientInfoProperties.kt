package dev.warrengates.databasemetadata

import java.sql.ResultSet

class ClientInfoProperties(rs: ResultSet) {
    val name: String = rs.getString("NAME")
    val maxLength: Int = rs.getInt("MAX_LEN")
    val defaultValue: String? = rs.getString("DEFAULT_VALUE")
    val description: String? = rs.getString("DESCRIPTION")
}