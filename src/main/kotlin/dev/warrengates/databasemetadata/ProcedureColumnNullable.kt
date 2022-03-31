package dev.warrengates.databasemetadata

import java.sql.DatabaseMetaData

enum class ProcedureColumnNullable(override val type: Int, private val text: String): IntegerEnum {
    NO(DatabaseMetaData.procedureNoNulls,"YES"),
    YES(DatabaseMetaData.procedureNullable, "NO"),
    UNKNOWN(DatabaseMetaData.procedureNullableUnknown, "");

    override fun toString(): String = text
}