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

import java.sql.ResultSet

/**
 * Wrapper for results of [getSuperTypes](https://docs.oracle.com/en/java/javase/17/docs/api/java.sql/java/sql/DatabaseMetaData.html#getSuperTypes(java.lang.String,java.lang.String,java.lang.String))
 *
 */
class SuperType(rs: ResultSet) {
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
     * Super type catalog
     *
     * Source column: SUPERTYPE_CAT
     */
    @get:SourceColumn("SUPERTYPE_CAT")
    val superTypeCatalog: String? = rs.getString("SUPERTYPE_CAT")

    /**
     * Super type schema
     *
     * Source column: SUPERTYPE_SCHEM
     */
    @get:SourceColumn("SUPERTYPE_SCHEM")
    val superTypeSchema: String = rs.getString("SUPERTYPE_SCHEM")

    /**
     * Super type name
     *
     * Source column: SUPERTYPE_NAME
     */
    @get:SourceColumn("SUPERTYPE_NAME")
    val superTypeName: String = rs.getString("SUPERTYPE_NAME")

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as SuperType

        if (catalog != other.catalog) return false
        if (schema != other.schema) return false
        if (name != other.name) return false
        if (superTypeCatalog != other.superTypeCatalog) return false
        if (superTypeSchema != other.superTypeSchema) return false
        if (superTypeName != other.superTypeName) return false

        return true
    }

    override fun hashCode(): Int {
        var result = catalog?.hashCode() ?: 0
        result = 31 * result + schema.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + (superTypeCatalog?.hashCode() ?: 0)
        result = 31 * result + superTypeSchema.hashCode()
        result = 31 * result + superTypeName.hashCode()
        return result
    }
}