/*
 * Copyright (c) 2022 Warren Gates
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.warrengates.bettermetadata

/**
 * Wrapper for the results of the [getIndexInfo](https://docs.oracle.com/en/java/javase/17/docs/api/java.sql/java/sql/DatabaseMetaData.html#getIndexInfo(java.lang.String,java.lang.String,java.lang.String,boolean,boolean))
 * method and represents a [Table]'s indices and statistics.  Returned from [Table.getIndexes]
 *
 */
class Index(values: Map<String, Any?>) {
    /**
     * Catalog
     *
     * Source column: TABLE_CAT
     */
    @get:SourceColumn("TABLE_CAT")
    val catalog: String? = values["TABLE_CAT"] as String?

    /**
     * Schema
     *
     * Source column: TABLE_SCHEM
     */
    @get:SourceColumn("TABLE_SCHEM")
    val schema: String = values["TABLE_SCHEM"] as String

    /**
     * Table name
     *
     * Source column: TABLE_NAME
     */
    @get:SourceColumn("TABLE_NAME")
    val tableName: String = values["TABLE_NAME"] as String

    /**
     * Name, null when [type] is [IndexType.STATISTIC]
     *
     * Source column: INDEX_NAME
     */
    @get:SourceColumn("INDEX_NAME")
    val name: String? = values["INDEX_NAME"] as String?

    /**
     * Non unique, false when [type] is [IndexType.STATISTIC]
     *
     * Source column: NON_UNIQUE
     */
    @get:SourceColumn("NON_UNIQUE")
    val nonUnique: Boolean = values["NON_UNIQUE"] as Boolean

    /**
     * Index qualifier, null when [type] is [IndexType.STATISTIC]
     *
     * Source column: INDEX_QUALIFIER
     */
    @get:SourceColumn("INDEX_QUALIFIER")
    val indexQualifier: String? = values["INDEX_QUALIFIER"] as String?

    /**
     * Type
     *
     * Source column: TYPE
     */
    @get:SourceColumn("TYPE")
    val type: IndexType = valueOf((values["TYPE"] as Short).toInt())

    /**
     * Cardinality, when [type] is [IndexType.STATISTIC] this is the number of rows in the table,
     * otherwise it is the number of unique values in the index
     *
     * Source column: CARDINALITY
     */
    @get:SourceColumn("CARDINALITY")
    val cardinality: Long = values["CARDINALITY"] as Long

    /**
     * Pages, when [type] is [IndexType.STATISTIC] this is then number pages used for the table, otherwise it
     * is the number of pages used for the current index
     *
     * Source column: PAGES
     */
    @get:SourceColumn("PAGES")
    val pages: Long = values["PAGES"] as Long

    /**
     * Filter condition
     *
     * Source column: FILTER_CONDITION
     */
    @get:SourceColumn("FILTER_CONDITION")
    val filterCondition: String? = values["FILTER_CONDITION"] as String?


    /**
     * Index columns
     */
    @Suppress("UNCHECKED_CAST")
    val indexColumns: List<IndexColumn> = values["COLUMNS"] as List<IndexColumn>

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Index

        if (catalog != other.catalog) return false
        if (schema != other.schema) return false
        if (tableName != other.tableName) return false
        if (name != other.name) return false
        if (nonUnique != other.nonUnique) return false
        if (type != other.type) return false
        if (indexColumns != other.indexColumns) return false

        return true
    }

    override fun hashCode(): Int {
        var result = catalog?.hashCode() ?: 0
        result = 31 * result + schema.hashCode()
        result = 31 * result + tableName.hashCode()
        result = 31 * result + (name?.hashCode() ?: 0)
        result = 31 * result + nonUnique.hashCode()
        result = 31 * result + type.hashCode()
        result = 31 * result + indexColumns.hashCode()
        return result
    }
}