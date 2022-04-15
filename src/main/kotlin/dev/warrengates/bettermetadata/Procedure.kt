/*
 * Copyright (c) 2022. Warren Gates
 * All rights reserved.
 */

package dev.warrengates.bettermetadata

import java.sql.DatabaseMetaData
import java.sql.ResultSet

/**
 * Procedure
 *
 * @property metadata
 * @constructor
 *
 * @param rs
 */
class Procedure(private val metadata: DatabaseMetaData, rs: ResultSet) {
    /**
     * Catalog
     */
    val catalog: String? = rs.getString("procedure_cat")

    /**
     * Schema
     */
    val schema: String? = rs.getString("procedure_schem")

    /**
     * Name
     */
    val name: String = rs.getString("procedure_name")

    /**
     * Remarks
     */
    val remarks: String = rs.getString("remarks")

    /**
     * Return type
     */
    val returnType: ProcedureReturnType = rs.getIntegerEnum("procedure_type")

    /**
     * Specific name
     */
    val specificName: String? = rs.getString("specific_name")

    /**
     * Get procedure columns
     *
     * @param columnNamePattern
     * @return
     */
    fun getProcedureColumns(columnNamePattern: String?): List<ProcedureColumn> = getIterableFromRs(
        metadata.getProcedureColumns(catalog, schema, name, columnNamePattern)
    ) { ProcedureColumn(it) }
}