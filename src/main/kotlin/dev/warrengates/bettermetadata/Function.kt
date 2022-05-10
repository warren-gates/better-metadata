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
import java.sql.ResultSet

/**
 * Wrapper for results of [getFunctions](https://docs.oracle.com/en/java/javase/17/docs/api/java.sql/java/sql/DatabaseMetaData.html#getFunctions(java.lang.String,java.lang.String,java.lang.String))
 * method and represents user and system functions
 *
 * @property metadata
 * @constructor
 *
 * @param rs
 */
@Suppress("unused")
class Function(private val metadata: DatabaseMetaData, rs: ResultSet) {
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
     * Name
     *
     * Source column: FUNCTION_NAME
     */
    @get:SourceColumn("FUNCTION_NAME")
    val name: String = rs.getString("FUNCTION_NAME")

    /**
     * Remarks
     *
     * Source column: REMARKS
     */
    @get:SourceColumn("REMARKS")
    val remarks: String? = rs.getString("REMARKS")

    /**
     * Return type, converted to [FunctionReturnType]
     *
     * Source column: FUNCTION_TYPE
     */
    @get:SourceColumn("FUNCTION_TYPE")
    val returnType: FunctionReturnType = rs.getIntegerEnum("FUNCTION_TYPE")

    /**
     * Specific name
     *
     * Source column: SPECIFIC_NAME
     */
    @get:SourceColumn("SPECIFIC_NAME")
    val specificName: String? = rs.getString("SPECIFIC_NAME")

    /**
     * Wrapper around [getFunctionColumns](https://docs.oracle.com/en/java/javase/17/docs/api/java.sql/java/sql/DatabaseMetaData.html#getFunctionColumns(java.lang.String,java.lang.String,java.lang.String,java.lang.String))
     * method and returns a list of [FunctionColumn]s for this function only
     *
     * @param columnNamePattern
     * @return
     */
    @JvmOverloads
    fun getFunctionColumns(columnNamePattern: String? = null): List<FunctionColumn> = getIterableFromRs(
        metadata.getFunctionColumns(catalog, schema, name, columnNamePattern)
    ) { FunctionColumn(it) }.filter { it.specificName == specificName }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Function

        if (catalog != other.catalog) return false
        if (schema != other.schema) return false
        if (name != other.name) return false
        if (specificName != other.specificName) return false

        return true
    }

    override fun hashCode(): Int {
        var result = catalog?.hashCode() ?: 0
        result = 31 * result + (schema?.hashCode() ?: 0)
        result = 31 * result + name.hashCode()
        result = 31 * result + (specificName?.hashCode() ?: 0)
        return result
    }
}