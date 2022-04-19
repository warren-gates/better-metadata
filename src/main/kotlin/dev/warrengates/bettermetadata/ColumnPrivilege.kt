/*
 * Copyright (c) 2022. Warren Gates
 * All rights reserved.
 */

package dev.warrengates.bettermetadata

import java.sql.ResultSet

/**
 * Wrapper for results of [getColumnPrivileges](https://docs.oracle.com/en/java/javase/17/docs/api/java.sql/java/sql/DatabaseMetaData.html#getColumns(java.lang.String,java.lang.String,java.lang.String,java.lang.String))
 * method. Used from [Column.getColumnPrivileges]
 *
 * @constructor
 *
 * @param rs
 */
@Suppress("unused")
class ColumnPrivilege(rs: ResultSet) {
    /**
     * Catalog
     *
     * Source column: TABLE_CAT
     */
    val catalog: String? = rs.getString("TABLE_CAT")

    /**
     * Schema
     *
     * Source column: TABLE_SCHEM
     */
    val schema: String? = rs.getString("TABLE_SCHEM")

    /**
     * Table name
     *
     * Source column: TABLE_NAME
     */
    val tableName: String? = rs.getString("TABLE_NAME")

    /**
     * Column name
     *
     * Source column: COLUMN_NAME
     */
    val columnName: String? = rs.getString("COLUMN_NAME")

    /**
     * Grantor
     *
     * Source column: GRANTOR
     */
    val grantor: String? = rs.getString("GRANTOR")

    /**
     * Grantee
     *
     * Source column: GRANTEE
     */
    val grantee: String? = rs.getString("GRANTEE")

    /**
     * Privilege
     *
     * Source column: PRIVILEGE
     */
    val privilege: String? = rs.getString("PRIVILEGE")

    /**
     * Is grantable, converted to [IsGrantable]
     *
     * Source column: IS_GRANTABLE
     */
    val isGrantable: String? = rs.getString("IS_GRANTABLE")
}