package dev.warrengates.databasemetadata

import java.sql.ResultSet

class Index(rs: ResultSet) {
    val catalog: String? = rs.getString("TABLE_CAT")
    val schema: String = rs.getString("TABLE_SCHEM")
    val tableName: String = rs.getString("TABLE_NAME")
    val nonUnique: Boolean = rs.getBoolean("NON_UNIQUE")
    val indexQualifier: String? = rs.getString("INDEX_QUALIFIER")
    val name: String = rs.getString("INDEX_NAME")
    val type: IndexType = valueOf(rs.getInt("TYPE"))
    val ordinalPosition: Int = rs.getInt("ORDINAL_POSITION")
    val columnName: String? = rs.getString("COLUMN_NAME")

    // TODO: redo as enum
    val sortSequence: String? = rs.getString("ASC_OR_DESC")
    val cardinality: Long = rs.getLong("CARDINALITY")
    val pages: Long = rs.getLong("PAGES")
    val filterCondition: String? = rs.getString("FILTER_CONDITION")
}