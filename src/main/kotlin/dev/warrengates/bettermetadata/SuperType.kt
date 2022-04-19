/*
 * Copyright (c) 2022. Warren Gates
 * All rights reserved.
 */

package dev.warrengates.bettermetadata

import java.sql.ResultSet

/**
 * Wrapper for results of [getSuperTypes](https://docs.oracle.com/en/java/javase/17/docs/api/java.sql/java/sql/DatabaseMetaData.html#getSuperTypes(java.lang.String,java.lang.String,java.lang.String))
 *
 */
class SuperType(rs: ResultSet) {
    /**
     * Catalog
     *
     * Source column: TYPE_CAT
     */
    val catalog: String? = rs.getString("TYPE_CAT")

    /**
     * Schema
     *
     * Source column: TYPE_SCHEM
     */
    val schema: String = rs.getString("TYPE_SCHEM")

    /**
     * Name
     *
     * Source column: TYPE_NAME
     */
    val name: String = rs.getString("TYPE_NAME")

    /**
     * Super type catalog
     *
     * Source column: SUPERTYPE_CAT
     */
    val superTypeCatalog: String? = rs.getString("SUPERTYPE_CAT")

    /**
     * Super type schema
     *
     * Source column: SUPERTYPE_SCHEM
     */
    val superTypeSchema: String = rs.getString("SUPERTYPE_SCHEM")

    /**
     * Super type name
     *
     * Source column: SUPERTYPE_NAME
     */
    val superTypeName: String = rs.getString("SUPERTYPE_NAME")
}