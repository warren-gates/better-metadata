package dev.warrengates.databasemetadata

import java.sql.ResultSet

class TablePrivilege(rs: ResultSet) {
    val catalog: String? = rs.getString("TABLE_CAT")
    val schema: String? = rs.getString("TABLE_SCHEM")
    val name: String = rs.getString("TABLE_NAME")
    val grantor: String? = rs.getString("GRANTOR")
    val grantee: String? = rs.getString("GRANTEE")
    val privilege: String? = rs.getString("PRIVILEGE")
    val isGrantable: String? = rs.getString("IS_GRANTABLE")
}