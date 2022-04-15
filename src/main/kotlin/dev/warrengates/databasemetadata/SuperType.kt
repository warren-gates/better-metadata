package dev.warrengates.databasemetadata

import java.sql.ResultSet

/**
 * Super type
 *
 * @constructor
 *
 * @param rs
 */
class SuperType(rs: ResultSet) {
    /**
     * Catalog
     */
    val catalog: String? = rs.getString("TYPE_CAT")

    /**
     * Schema
     */
    val schema: String = rs.getString("TYPE_SCHEM")

    /**
     * Name
     */
    val name: String = rs.getString("TYPE_NAME")

    /**
     * Super type catalog
     */
    val superTypeCatalog: String? = rs.getString("SUPERTYPE_CAT")

    /**
     * Super type schema
     */
    val superTypeSchema: String = rs.getString("SUPERTYPE_SCHEM")

    /**
     * Super type name
     */
    val superTypeName: String = rs.getString("SUPERTYPE_NAME")
}