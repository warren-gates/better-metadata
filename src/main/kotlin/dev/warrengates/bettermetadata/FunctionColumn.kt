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
 * Wrapper for results of [getFunctionColumns](https://docs.oracle.com/en/java/javase/17/docs/api/java.sql/java/sql/DatabaseMetaData.html#getFunctionColumns(java.lang.String,java.lang.String,java.lang.String,java.lang.String))
 * method and represents a column of [Function]
 *
 * @constructor
 *
 * @param rs
 */
class FunctionColumn(rs: ResultSet) {
    /**
     * Catalog
     *
     * Source column: FUNCTION_CAT
     */
    @get:SourceColumn("FUNCTION_CAT")
    val catalog: String? = rs.getString("FUNCTION_CAT")

    /**
     * Schema
     *
     * Source column: FUNCTION_SCHEM
     */
    @get:SourceColumn("FUNCTION_SCHEM")
    val schema: String? = rs.getString("FUNCTION_SCHEM")

    /**
     * Function name
     *
     * Source column: FUNCTION_NAME
     */
    @get:SourceColumn("FUNCTION_NAME")
    val functionName: String = rs.getString("FUNCTION_NAME")

    /**
     * Name
     *
     * Source column: COLUMN_NAME
     */
    @get:SourceColumn("COLUMN_NAME")
    val name: String = rs.getString("COLUMN_NAME")

    /**
     * Column type, converted to [FunctionColumnType]
     *
     * Source column: COLUMN_TYPE
     */
    @get:SourceColumn("COLUMN_TYPE")
    val columnType: FunctionColumnType = rs.getIntegerEnum("COLUMN_TYPE")

    /**
     * SQL type from [java.sql.Types], converted from int
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
     * Precision
     *
     * Source column: PRECISION
     */
    @get:SourceColumn("PRECISION")
    val precision: MetadataInt = rs.getMetadataInt("PRECISION")

    /**
     * Length
     *
     * Source column: LENGTH
     */
    @get:SourceColumn("LENGTH")
    val length: Int = rs.getInt("LENGTH")

    /**
     * Scale
     *
     * Source column: SCALE
     */
    @get:SourceColumn("SCALE")
    val scale: MetadataInt = rs.getMetadataInt("SCALE")

    /**
     * Radix
     *
     * Source column: RADIX
     */
    @get:SourceColumn("RADIX")
    val radix: MetadataInt = rs.getMetadataInt("RADIX")

    /**
     * Nullable, converted to [FunctionColumnNullable]
     *
     * Source column: NULLABLE
     */
    @get:SourceColumn("NULLABLE")
    val nullable: FunctionColumnNullable = rs.getIntegerEnum("NULLABLE")

    /**
     * Remarks
     *
     * Source column: REMARKS
     */
    @get:SourceColumn("REMARKS")
    val remarks: String? = rs.getString("REMARKS")

    /**
     * Character octet length
     *
     * Source column: CHAR_OCTET_LENGTH
     */
    @get:SourceColumn("CHAR_OCTET_LENGTH")
    val characterOctetLength: MetadataInt = rs.getMetadataInt("CHAR_OCTET_LENGTH")

    /**
     * Ordinal position
     *
     * Source column: ORDINAL_POSITION
     */
    @get:SourceColumn("ORDINAL_POSITION")
    val ordinalPosition: Int = rs.getInt("ORDINAL_POSITION")

    /**
     * Is nullable, converted to [IsNullable]
     *
     * Source column: IS_NULLABLE
     */
    @get:SourceColumn("IS_NULLABLE")
    val isNullable: IsNullable = rs.getStringEnum("IS_NULLABLE")

    /**
     * Specific name
     *
     * Source column: SPECIFIC_NAME
     */
    @get:SourceColumn("SPECIFIC_NAME")
    val specificName: String? = rs.getString("SPECIFIC_NAME")

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as FunctionColumn

        if (catalog != other.catalog) return false
        if (schema != other.schema) return false
        if (functionName != other.functionName) return false
        if (name != other.name) return false
        if (ordinalPosition != other.ordinalPosition) return false

        return true
    }

    override fun hashCode(): Int {
        var result = catalog?.hashCode() ?: 0
        result = 31 * result + (schema?.hashCode() ?: 0)
        result = 31 * result + functionName.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + ordinalPosition
        return result
    }
}