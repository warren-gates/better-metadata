/*
 * Copyright (c) 2022. Warren Gates
 * All rights reserved.
 */

package dev.warrengates.bettermetadata

import java.sql.DatabaseMetaData
import java.sql.ResultSet

/**
 * Wrapper for results of [getProcedures](https://docs.oracle.com/en/java/javase/17/docs/api/java.sql/java/sql/DatabaseMetaData.html#getProcedures(java.lang.String,java.lang.String,java.lang.String))
 * method and represents a stored procedure
 *
 */
class Procedure(private val metadata: DatabaseMetaData, rs: ResultSet) {
    /**
     * Catalog
     *
     * Source column: PROCEDURE_CAT
     */
    val catalog: String? = rs.getString("PROCEDURE_CAT")

    /**
     * Schema
     *
     * Source column: PROCEDURE_SCHEM
     */
    val schema: String? = rs.getString("PROCEDURE_SCHEM")

    /**
     * Name
     *
     * Source column: PROCEDURE_NAME
     */
    val name: String = rs.getString("PROCEDURE_NAME")

    /**
     * Remarks
     *
     * Source column: REMARKS
     */
    val remarks: String = rs.getString("REMARKS")

    /**
     * Return type, converted to [ProcedureReturnType]
     *
     * Source column: PROCEDURE_TYPE
     */
    val returnType: ProcedureReturnType = rs.getIntegerEnum("PROCEDURE_TYPE")

    /**
     * Specific name
     *
     * Source column: SPECIFIC_NAME
     */
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
    ) { ProcedureColumn(it) }
}