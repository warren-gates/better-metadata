package dev.warrengates.databasemetadata

import java.sql.ResultSet

/**
 * Table type
 *
 * @constructor
 *
 * @param rs
 */
class TableType(rs: ResultSet) {
    /**
     * Name
     */
    val name: String = rs.getString("TABLE_TYPE")

    override fun toString(): String {
        return name
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as TableType

        if (name != other.name) return false

        return true
    }

    override fun hashCode(): Int {
        return name.hashCode()
    }
}