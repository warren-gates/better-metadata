package dev.warrengates.databasemetadata

import java.sql.DatabaseMetaData
import java.sql.ResultSet

/**
 * Function
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
     */
    val catalog: String? = rs.getString("function_cat")

    /**
     * Schema
     */
    val schema: String = rs.getString("function_schem")

    /**
     * Name
     */
    val name: String = rs.getString("function_name")

    /**
     * Remarks
     */
    val remarks: String? = rs.getString("remarks")

    /**
     * Type
     */
    val type: FunctionReturnType = rs.getEnum("function_type")

    /**
     * Specific name
     */
    val specificName: String? = rs.getString("specific_name")

    /**
     * Get function columns
     *
     * @param columnNamePattern
     * @return
     */
    fun getFunctionColumns(columnNamePattern: String?): List<FunctionColumn> = getIterableFromRs(
        metadata.getFunctionColumns(catalog, schema, name, columnNamePattern)
    ) { FunctionColumn(it) }
}