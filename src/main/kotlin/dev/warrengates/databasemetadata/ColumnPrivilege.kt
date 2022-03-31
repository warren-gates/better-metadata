package dev.warrengates.databasemetadata

import java.sql.ResultSet

@Suppress("unused")
class ColumnPrivilege(rs: ResultSet) {
    val catalog: String? = rs.getString("TABLE_CAT")
    val schema: String? = rs.getString("TABLE_SCHEM")
    val tableName: String? = rs.getString("TABLE_NAME")
    val columnName: String? = rs.getString("COLUMN_NAME")
    val grantor: String? = rs.getString("GRANTOR")
    val grantee: String? = rs.getString("GRANTEE")
    val privilege: String? = rs.getString("PRIVILEGE")
    val isGrantable: String? = rs.getString("IS_GRANTABLE")
}