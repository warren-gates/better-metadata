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
 * Wrapper for results of [getPrimaryKeys](https://docs.oracle.com/en/java/javase/17/docs/api/java.sql/java/sql/DatabaseMetaData.html#getPrimaryKeys(java.lang.String,java.lang.String,java.lang.String)).
 * It has been refactored to provide of [Column] object rather than the flattened view provided by the getPrimaryKeys method.
 *
 *
 * @property name
 * @property columns
 * @constructor Create empty Primary key
 */
class PrimaryKey(
    /**
     * Key name
     *
     * Source column: PK_NAME
     */
    val name: String?,

    /**
     * List of [Column] objects selected by filtering for the appropriate TABLE_CAT, TABLE_SCHEM, TABLE_NAME, and
     * COLUMN_NAME as returned by [java.sql.DatabaseMetaData.getPrimaryKeys], and the ordered by KEY_SEQ
     */
    val columns: List<Column>
){
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as PrimaryKey

        if (name != other.name) return false
        if (columns != other.columns) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name?.hashCode() ?: 0
        result = 31 * result + columns.hashCode()
        return result
    }
}