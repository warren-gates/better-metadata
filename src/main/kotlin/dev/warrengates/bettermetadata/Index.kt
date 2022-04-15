/*
 * Copyright (c) 2022. Warren Gates
 * All rights reserved.
 */

package dev.warrengates.bettermetadata

import java.sql.ResultSet

/**
 * Index
 *
 * @constructor
 *
 * @param rs
 */
class Index(rs: ResultSet) {
    /**
     * Catalog
     */
    val catalog: String? = rs.getString("TABLE_CAT")

    /**
     * Schema
     */
    val schema: String = rs.getString("TABLE_SCHEM")

    /**
     * Table name
     */
    val tableName: String = rs.getString("TABLE_NAME")

    /**
     * Non unique
     */
    val nonUnique: Boolean = rs.getBoolean("NON_UNIQUE")

    /**
     * Index qualifier
     */
    val indexQualifier: String? = rs.getString("INDEX_QUALIFIER")

    /**
     * Name
     */
    val name: String = rs.getString("INDEX_NAME")

    /**
     * Type
     */
    val type: IndexType = rs.getIntegerEnum("TYPE")

    /**
     * Ordinal position
     */
    val ordinalPosition: Int = rs.getInt("ORDINAL_POSITION")

    /**
     * Column name
     */
    val columnName: String? = rs.getString("COLUMN_NAME")

    /**
     * Sort sequence
     */// TODO: redo as enum
    val sortSequence: String? = rs.getString("ASC_OR_DESC")

    /**
     * Cardinality
     */
    val cardinality: Long = rs.getLong("CARDINALITY")

    /**
     * Pages
     */
    val pages: Long = rs.getLong("PAGES")

    /**
     * Filter condition
     */
    val filterCondition: String? = rs.getString("FILTER_CONDITION")
}