/*
 * Copyright (c) 2022. Warren Gates
 * All rights reserved.
 */

package dev.warrengates.bettermetadata

import java.sql.ResultSet

/**
 * Wrapper for results of [getSchemas](https://docs.oracle.com/en/java/javase/17/docs/api/java.sql/java/sql/DatabaseMetaData.html#getSchemas())
 *
 */
@Suppress("unused")
class Schema(rs: ResultSet) {
    /**
     * Name
     *
     * Source column: TABLE_SCHEM
     */
    val name: String = rs.getString("TABLE_SCHEM")

    /**
     * Catalog
     *
     * Source column: TABLE_CATALOG
     */
    val catalog: String? = rs.getString("TABLE_CATALOG")
}