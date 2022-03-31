package dev.warrengates.databasemetadata

import java.sql.ResultSet

class TableType(rs: ResultSet) {
    val name: String = rs.getString("TABLE_TYPE")
}