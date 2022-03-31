package dev.warrengates.databasemetadata

import java.sql.DatabaseMetaData
import java.sql.ResultSet

@Suppress("unused")
class Function(private val metadata: DatabaseMetaData, rs: ResultSet) {
    val catalog: String? = rs.getString("function_cat")
    val schema: String = rs.getString("function_schem")
    val name: String = rs.getString("function_name")
    val remarks: String? = rs.getString("remarks")
    val type: FunctionReturnType = valueOf(rs.getInt("function_type"))
    val specificName: String? = rs.getString("specific_name")

    fun getFunctionColumns(columnNamePattern: String?): List<FunctionColumn> = getIterableFromRs(
        metadata.getFunctionColumns(catalog, schema, name, columnNamePattern)
    ) { FunctionColumn(it) }
}