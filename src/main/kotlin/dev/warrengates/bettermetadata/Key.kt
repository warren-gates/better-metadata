/*
 * Copyright (c) 2022. Warren Gates
 * All rights reserved.
 */

package dev.warrengates.bettermetadata

import java.sql.ResultSet

/**
 * Key
 *
 * @constructor
 *
 * @param rs
 */
@Suppress("unused")
class Key(rs: ResultSet) {
    /**
     * Parent table catalog
     */// TODO revisit, compare against PrimaryKey approach
    val parentTableCatalog: String? = rs.getString("PKTABLE_CAT")

    /**
     * Parent table schema
     */
    val parentTableSchema: String = rs.getString("PKTABLE_SCHEM")

    /**
     * Parent table name
     */
    val parentTableName: String = rs.getString("PKTABLE_NAME")

    /**
     * Parent column name
     */
    val parentColumnName: String = rs.getString("PKCOLUMN_NAME")

    /**
     * Foreign table catalog
     */
    val foreignTableCatalog: String? = rs.getString("FKTABLE_CAT")

    /**
     * Foreign table schema
     */
    val foreignTableSchema: String = rs.getString("FKTABLE_SCHEM")

    /**
     * Foreign table name
     */
    val foreignTableName: String = rs.getString("FKTABLE_NAME")

    /**
     * Foreign column name
     */
    val foreignColumnName: String = rs.getString("FKCOLUMN_NAME")

    /**
     * Key sequence
     */
    val keySequence: Int = rs.getInt("KEY_SEQ")

    /**
     * Update rule
     */
    val updateRule: ForeignKeyUpdateRule = rs.getEnum("UPDATE_RULE")

    /**
     * Delete rule
     */
    val deleteRule: ForeignKeyDeleteRule = rs.getEnum("DELETE_RULE")

    /**
     * Foreign key name
     */
    val foreignKeyName: String = rs.getString("FK_NAME")

    /**
     * Primary key name
     */
    val primaryKeyName: String = rs.getString("PK_NAME")

    /**
     * Deferrability
     */
    val deferrability: ForeignKeyInitialDeferrability =
        rs.getEnum("DEFERRABILITY")
}