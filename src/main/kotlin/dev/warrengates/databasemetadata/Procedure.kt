package dev.warrengates.databasemetadata

import java.sql.DatabaseMetaData
import java.sql.ResultSet

class Procedure(private val metadata: DatabaseMetaData, rs: ResultSet) {
    val catalog: String? = rs.getString("procedure_cat")
    val schema: String? = rs.getString("procedure_schem")
    val name: String = rs.getString("procedure_name")
    val remarks: String = rs.getString("remarks")
    val returnType: ProcedureReturnType = valueOf(rs.getInt("procedure_type"))
    val specificName: String? = rs.getString("specific_name")

    fun getProcedureColumns(columnNamePattern: String?): List<ProcedureColumn> = getIterableFromRs(
        metadata.getProcedureColumns(catalog, schema, name, columnNamePattern)
    ) { ProcedureColumn(it) }
}