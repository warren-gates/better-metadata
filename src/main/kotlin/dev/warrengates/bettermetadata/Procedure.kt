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
 * Wrapper around the [getProcedures](https://docs.oracle.com/en/java/javase/17/docs/api/java.sql/java/sql/DatabaseMetaData.html#getProcedures(java.lang.String,java.lang.String,java.lang.String))
 * method and represents a stored procedure
 *
 */
class Procedure(private val metadata: DatabaseMetaData, rs: ResultSet) {
    /**
     * Catalog
     *
     * Source column: PROCEDURE_CAT
     */
    @get:SourceColumn("PROCEDURE_CAT")
    val catalog: String? = rs.getString("PROCEDURE_CAT")

    /**
     * Schema
     *
     * Source column: PROCEDURE_SCHEM
     */
    @get:SourceColumn("PROCEDURE_SCHEM")
    val schema: String? = rs.getString("PROCEDURE_SCHEM")

    /**
     * Name
     *
     * Source column: PROCEDURE_NAME
     */
    @get:SourceColumn("PROCEDURE_NAME")
    val name: String = rs.getString("PROCEDURE_NAME")

    /**
     * Remarks
     *
     * Source column: REMARKS
     */
    @get:SourceColumn("REMARKS")
    val remarks: String = rs.getString("REMARKS")

    /**
     * Return type, converted to [ProcedureReturnType]
     *
     * Source column: PROCEDURE_TYPE
     */
    @get:SourceColumn("PROCEDURE_TYPE")
    val returnType: ProcedureReturnType = rs.getIntegerEnum("PROCEDURE_TYPE")

    /**
     * Specific name
     *
     * Source column: SPECIFIC_NAME
     */
    @get:SourceColumn("SPECIFIC_NAME")
    val specificName: String? = rs.getString("SPECIFIC_NAME")

    /**
     * Wrapper around [getProcedureColumns](https://docs.oracle.com/en/java/javase/17/docs/api/java.sql/java/sql/DatabaseMetaData.html#getProcedureColumns(java.lang.String,java.lang.String,java.lang.String,java.lang.String))
     * and returns a list of [ProcedureColumn]s for this procedure only
     *
     * @param columnNamePattern
     * @return
     */
    @JvmOverloads
    fun getProcedureColumns(columnNamePattern: String? = null): List<ProcedureColumn> = getIterableFromRs(
        metadata.getProcedureColumns(catalog, schema, name, columnNamePattern)
    ) { ProcedureColumn(it) }.filter { it.specificName == specificName }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Procedure

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