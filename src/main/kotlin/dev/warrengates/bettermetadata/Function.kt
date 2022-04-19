/*
 * Copyright (c) 2022. Warren Gates
 * All rights reserved.
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
    val catalog: String? = rs.getString("FUNCTION_CAT")

    /**
     * Schema
     *
     * Source column: FUNCTION_SCHEM
     */
    val schema: String = rs.getString("FUNCTION_SCHEM")

    /**
     * Name
     *
     * Source column: FUNCTION_NAME
     */
    val name: String = rs.getString("FUNCTION_NAME")

    /**
     * Remarks
     *
     * Source column: REMARKS
     */
    val remarks: String? = rs.getString("REMARKS")

    /**
     * Return type, converted to [FunctionReturnType]
     *
     * Source column: FUNCTION_TYPE
     */
    val type: FunctionReturnType = rs.getIntegerEnum("FUNCTION_TYPE")

    /**
     * Specific name
     *
     * Source column: SPECIFIC_NAME
     */
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
    ) { FunctionColumn(it) }
}