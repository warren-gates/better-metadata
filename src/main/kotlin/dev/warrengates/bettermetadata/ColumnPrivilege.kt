/*
 * Copyright (c) 2022. Warren Gates
 * All rights reserved.
 */

package dev.warrengates.bettermetadata

import java.sql.ResultSet

/**
 * Column privilege
 *
 * @constructor
 *
 * @param rs
 */
@Suppress("unused")
class ColumnPrivilege(rs: ResultSet) {
    /**
     * Catalog
     */
    val catalog: String? = rs.getString("TABLE_CAT")

    /**
     * Schema
     */
    val schema: String? = rs.getString("TABLE_SCHEM")

    /**
     * Table name
     */
    val tableName: String? = rs.getString("TABLE_NAME")

    /**
     * Column name
     */
    val columnName: String? = rs.getString("COLUMN_NAME")

    /**
     * Grantor
     */
    val grantor: String? = rs.getString("GRANTOR")

    /**
     * Grantee
     */
    val grantee: String? = rs.getString("GRANTEE")

    /**
     * Privilege
     */
    val privilege: String? = rs.getString("PRIVILEGE")

    /**
     * Is grantable
     */
    val isGrantable: String? = rs.getString("IS_GRANTABLE")
}