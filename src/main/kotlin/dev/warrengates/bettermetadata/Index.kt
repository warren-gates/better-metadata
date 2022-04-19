/*
 * Copyright (c) 2022. Warren Gates
 * All rights reserved.
 */

package dev.warrengates.bettermetadata

import java.sql.ResultSet

/**
 * Wrapper for the results of the [getIndexInfo](https://docs.oracle.com/en/java/javase/17/docs/api/java.sql/java/sql/DatabaseMetaData.html#getIndexInfo(java.lang.String,java.lang.String,java.lang.String,boolean,boolean))
 * method and represents a [Table]'s indices and statistics.  Returned from [Table.getIndexes]
 *
 * @constructor
 *
 * @param rs
 */
class Index(rs: ResultSet) {
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
    val schema: String = rs.getString("TABLE_SCHEM")

    /**
     * Table name
     *
     * Source column: TABLE_NAME
     */
    val tableName: String = rs.getString("TABLE_NAME")

    /**
     * Non unique, false when [type] is [IndexType.STATISTIC]
     *
     * Source column: NON_UNIQUE
     */
    val nonUnique: Boolean = rs.getBoolean("NON_UNIQUE")

    /**
     * Index qualifier, null when [type] is [IndexType.STATISTIC]
     *
     * Source column: INDEX_QUALIFIER
     */
    val indexQualifier: String? = rs.getString("INDEX_QUALIFIER")

    /**
     * Name, null when [type] is [IndexType.STATISTIC]
     *
     * Source column: INDEX_NAME
     */
    val name: String = rs.getString("INDEX_NAME")

    /**
     * Type
     *
     * Source column: TYPE
     */
    val type: IndexType = rs.getIntegerEnum("TYPE")

    /**
     * Ordinal position, 0 when [type] is [IndexType.STATISTIC]
     *
     * Source column: ORDINAL_POSITION
     */
    val ordinalPosition: Int = rs.getInt("ORDINAL_POSITION")

    /**
     * Column name, null when [type] is [IndexType.STATISTIC]
     *
     * Source column: COLUMN_NAME
     */
    val columnName: String? = rs.getString("COLUMN_NAME")

    /**
     * Sort sequence, converted to [IndexSort]
     *
     * Source column: ASC_OR_DESC
     */
    val sortSequence: IndexSort = rs.getStringEnum("ASC_OR_DESC")

    /**
     * Cardinality, when [type] is [IndexType.STATISTIC] this is the number of rows in the table,
     * otherwise it is the number of unique values in the index
     *
     * Source column: CARDINALITY
     */
    val cardinality: Long = rs.getLong("CARDINALITY")

    /**
     * Pages, when [type] is [IndexType.STATISTIC] this is then number pages used for the table, otherwise it
     * is the number of pages used for the current index
     *
     * Source column: PAGES
     */
    val pages: Long = rs.getLong("PAGES")

    /**
     * Filter condition
     *
     * Source column: FILTER_CONDITION
     */
    val filterCondition: String? = rs.getString("FILTER_CONDITION")
}