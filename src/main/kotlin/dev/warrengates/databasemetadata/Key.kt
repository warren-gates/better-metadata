package dev.warrengates.databasemetadata

import java.sql.ResultSet

@Suppress("unused")
class Key(rs: ResultSet) {
    // TODO revisit, compare against PrimaryKey approach
    val parentTableCatalog: String? = rs.getString("PKTABLE_CAT")
    val parentTableSchema: String = rs.getString("PKTABLE_SCHEM")
    val parentTableName: String = rs.getString("PKTABLE_NAME")
    val parentColumnName: String = rs.getString("PKCOLUMN_NAME")
    val foreignTableCatalog: String? = rs.getString("FKTABLE_CAT")
    val foreignTableSchema: String = rs.getString("FKTABLE_SCHEM")
    val foreignTableName: String = rs.getString("FKTABLE_NAME")
    val foreignColumnName: String = rs.getString("FKCOLUMN_NAME")
    val keySequence: Int = rs.getInt("KEY_SEQ")
    val updateRule: ForeignKeyUpdateRule = valueOf(rs.getInt("UPDATE_RULE"))
    val deleteRule: ForeignKeyDeleteRule = valueOf(rs.getInt("DELETE_RULE"))
    val foreignKeyName: String = rs.getString("FK_NAME")
    val primaryKeyName: String = rs.getString("PK_NAME")
    val deferrability: ForeignKeyInitialDeferrability =
        valueOf(rs.getInt("DEFERRABILITY"))
}