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
     * Name The catalog's name
     */
    val name: String = rs.getString("TABLE_CAT")
}