package dev.warrengates.databasemetadata

import java.sql.ResultSet

/**
 * Catalog
 *
 * @constructor
 *
 * @param rs
 */
class Catalog(rs: ResultSet) {

    /**
     * The catalog's name
     */
    val name: String = rs.getString("TABLE_CAT")

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Catalog

        if (name != other.name) return false

        return true
    }

    override fun hashCode(): Int {
        return name.hashCode()
    }

    override fun toString(): String {
        return name
    }
}