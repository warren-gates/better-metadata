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
 * Wrapper for results of [getTypeInfo](https://docs.oracle.com/en/java/javase/17/docs/api/java.sql/java/sql/DatabaseMetaData.html#getTypeInfo())
 *
 * Note that per the documentation SQL_DATA_TYPE, and SQL_DATETIME_SUB are unused and have
 * been left out of this class
 */
class TypeInfo(rs: ResultSet) {
    /**
     * Name
     *
     * Source column: TYPE_NAME
     */
    @get:SourceColumn("TYPE_NAME")
    val name: String = rs.getString("TYPE_NAME")

    /**
     * SQL type, converted to [JDBCType]
     *
     * Source column: DATA_TYPE
     */
    @get:SourceColumn("DATA_TYPE")
    val dataType: JDBCType = rs.getJDBCType("DATA_TYPE")

    /**
     * Precision
     *
     * Source column: PRECISION
     */
    @get:SourceColumn("PRECISION")
    val precision: MetadataInt = rs.getMetadataInt("PRECISION")

    /**
     * Literal prefix
     *
     * Source column: LITERAL_PREFIX
     */
    @get:SourceColumn("LITERAL_PREFIX")
    val literalPrefix: String? = rs.getString("LITERAL_PREFIX")

    /**
     * Literal suffix
     *
     * Source column: LITERAL_SUFFIX
     */
    @get:SourceColumn("LITERAL_SUFFIX")
    val literalSuffix: String? = rs.getString("LITERAL_SUFFIX")

    /**
     * Create params
     *
     * Source column: CREATE_PARAMS
     */
    @get:SourceColumn("CREATE_PARAMS")
    val createParams: String? = rs.getString("CREATE_PARAMS")

    /**
     * Nullable, converted to [TypeNullable]
     *
     * Source column: NULLABLE
     */
    @get:SourceColumn("NULLABLE")
    val nullable: TypeNullable = rs.getIntegerEnum("NULLABLE")

    /**
     * Case sensitive
     *
     * Source column: CASE_SENSITIVE
     */
    @get:SourceColumn("CASE_SENSITIVE")
    val caseSensitive: Boolean = rs.getBoolean("CASE_SENSITIVE")

    /**
     * Searchable, converted to [TypeSearchable]
     *
     * Source column: SEARCHABLE
     */
    @get:SourceColumn("SEARCHABLE")
    val searchable: TypeSearchable = rs.getIntegerEnum("SEARCHABLE")

    /**
     * Is unsigned
     *
     * Source column: UNSIGNED_ATTRIBUTE
     */
    @get:SourceColumn("UNSIGNED_ATTRIBUTE")
    val isUnsigned: Boolean = rs.getBoolean("UNSIGNED_ATTRIBUTE")

    /**
     * Fixed precision scale
     *
     * Source column: FIXED_PREC_SCALE
     */
    @get:SourceColumn("FIXED_PREC_SCALE")
    val fixedPrecisionScale: Boolean = rs.getBoolean("FIXED_PREC_SCALE")

    /**
     * Auto increment
     *
     * Source column: AUTO_INCREMENT
     */
    @get:SourceColumn("AUTO_INCREMENT")
    val autoIncrement: Boolean = rs.getBoolean("AUTO_INCREMENT")

    /**
     * Local type name
     *
     * Source column: LOCAL_TYPE_NAME
     */
    @get:SourceColumn("LOCAL_TYPE_NAME")
    val localTypeName: String? = rs.getString("LOCAL_TYPE_NAME")

    /**
     * Minimum scale
     *
     * Source column: MINIMUM_SCALE
     */
    @get:SourceColumn("MINIMUM_SCALE")
    val minimumScale: Int = rs.getInt("MINIMUM_SCALE")

    /**
     * Maximum scale
     *
     * Source column: MAXIMUM_SCALE
     */
    @get:SourceColumn("MAXIMUM_SCALE")
    val maximumScale: Int = rs.getInt("MAXIMUM_SCALE")

    /**
     * Numeric precision radix
     *
     * Source column: NUM_PREC_RADIX
     */
    @get:SourceColumn("NUM_PREC_RADIX")
    val radix: MetadataInt = rs.getMetadataInt("NUM_PREC_RADIX")

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as TypeInfo

        if (name != other.name) return false
        if (dataType != other.dataType) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + dataType.hashCode()
        return result
    }
}