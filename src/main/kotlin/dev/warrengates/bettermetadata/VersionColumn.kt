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

import java.sql.JDBCType
import java.sql.ResultSet

/**
 * Wrapper for results of [getVersionColumns](https://docs.oracle.com/en/java/javase/17/docs/api/java.sql/java/sql/DatabaseMetaData.html#getVersionColumns(java.lang.String,java.lang.String,java.lang.String))
 *
 * Note that per the documentation SCOPE is unused and has
 * been left out of this class
 */
class VersionColumn(rs: ResultSet) {

    /**
     * Column name
     *
     * Source column: COLUMN_NAME
     */
    @get:SourceColumn("COLUMN_NAME")
    val columnName: String = rs.getString("COLUMN_NAME")

    /**
     * SQL type, converted to [JDBCType]
     *
     * Source column: DATA_TYPE
     */
    @get:SourceColumn("DATA_TYPE")
    val dataType: JDBCType = rs.getJDBCType("DATA_TYPE")

    /**
     * Type name
     *
     * Source column: TYPE_NAME
     */
    @get:SourceColumn("TYPE_NAME")
    val typeName: String? = rs.getString("TYPE_NAME")

    /**
     * Column size
     *
     * Source column: COLUMN_SIZE
     */
    @get:SourceColumn("COLUMN_SIZE")
    val columnSize: MetadataInt = rs.getMetadataInt("COLUMN_SIZE")

    /**
     * Buffer length
     *
     * Source column: BUFFER_LENGTH
     */
    @get:SourceColumn("BUFFER_LENGTH")
    val bufferLength: Int = rs.getInt("BUFFER_LENGTH")

    /**
     * The number of fractional digits
     *
     * Source column: DECIMAL_DIGITS
     */
    @get:SourceColumn("DECIMAL_DIGITS")
    val decimalDigits: MetadataInt = rs.getMetadataInt("DECIMAL_DIGITS")

    /**
     * Pseudo column, converted to [VersionColumnType]
     *
     * Source column: PSEUDO_COLUMN
     */
    @get:SourceColumn("PSEUDO_COLUMN")
    val pseudoColumn: VersionColumnType = rs.getIntegerEnum("PSEUDO_COLUMN")

}