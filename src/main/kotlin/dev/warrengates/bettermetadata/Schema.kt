package dev.warrengates.bettermetadata

import java.sql.ResultSet

/**
 * Schema
 *
 * @constructor
 *
 * @param rs
 */
@Suppress("unused")
class Schema(rs: ResultSet) {
    /**
     * Name
     */
    val name: String = rs.getString("TABLE_SCHEM")

    /**
     * Catalog
     */
    val catalog: String? = rs.getString("TABLE_CATALOG")
}