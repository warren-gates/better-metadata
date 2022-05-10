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

import java.sql.DatabaseMetaData
import java.sql.JDBCType
import java.sql.ResultSet

/**
 * Wrapper for results of [getUDTs](https://docs.oracle.com/en/java/javase/17/docs/api/java.sql/java/sql/DatabaseMetaData.html#getUDTs(java.lang.String,java.lang.String,java.lang.String,int%5B%5D))
 *
 */
@Suppress("unused")
class UserDefinedType(private val metadata: DatabaseMetaData, rs: ResultSet) {
    /**
     * Catalog
     *
     * Source column: TYPE_CAT
     */
    @get:SourceColumn("TYPE_CAT")
    val catalog: String? = rs.getString("TYPE_CAT")

    /**
     * Schema
     *
     * Source column: TYPE_SCHEM
     */
    @get:SourceColumn("TYPE_SCHEM")
    val schema: String = rs.getString("TYPE_SCHEM")

    /**
     * Name
     *
     * Source column: TYPE_NAME
     */
    @get:SourceColumn("TYPE_NAME")
    val name: String = rs.getString("TYPE_NAME")

    /**
     * Class name
     *
     * Source column: CLASS_NAME
     */
    @get:SourceColumn("CLASS_NAME")
    val className: String? = rs.getString("CLASS_NAME")

    /**
     * SQL type, converted to [JDBCType]
     *
     * Source column: DATA_TYPE
     */
    @get:SourceColumn("DATA_TYPE")
    val dataType: JDBCType = rs.getJDBCType("DATA_TYPE")

    /**
     * Remarks
     *
     * Source column: REMARKS
     */
    @get:SourceColumn("REMARKS")
    val remarks: String? = rs.getString("REMARKS")

    /**
     * Base type
     *
     * Source column: BASE_TYPE
     */
    @get:SourceColumn("BASE_TYPE")
    val baseType: Int = rs.getInt("BASE_TYPE")

    /**
     * Get attributes
     *
     * Source: wrapped results of [getAttributes](https://docs.oracle.com/en/java/javase/17/docs/api/java.sql/java/sql/DatabaseMetaData.html#getAttributes(java.lang.String,java.lang.String,java.lang.String,java.lang.String))
     * filtered to this types's catalog, schema, and name
     */
    @JvmOverloads
    fun getAttributes(attributeNamePattern: String? = null): List<Attribute> {
        return getIterableFromRs(
            metadata.getAttributes(catalog, schema, name, attributeNamePattern)
        ) { x -> Attribute(x) }
    }

    /**
     * Get super types for this type
     *
     * Source: wrapped results of [getSuperTypes](https://docs.oracle.com/en/java/javase/17/docs/api/java.sql/java/sql/DatabaseMetaData.html#getSuperTypes(java.lang.String,java.lang.String,java.lang.String))
     * filtered to this type's catalog, schema, and name
     *
     * @return
     */
    fun getSuperTypes(): List<SuperType> = getIterableFromRs(
        metadata.getSuperTypes(catalog, schema, name)
    ) { rs -> SuperType(rs) }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as UserDefinedType

        if (catalog != other.catalog) return false
        if (schema != other.schema) return false
        if (name != other.name) return false
        if (dataType != other.dataType) return false

        return true
    }

    override fun hashCode(): Int {
        var result = catalog?.hashCode() ?: 0
        result = 31 * result + schema.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + dataType.hashCode()
        return result
    }


}