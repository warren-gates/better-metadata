package dev.warrengates.databasemetadata

import java.sql.DatabaseMetaData

enum class ProcedureReturnType(override val type: Int): IntegerEnum {
    NO_RESULT(DatabaseMetaData.procedureNoResult),
    RETURNS_RESULT(DatabaseMetaData.procedureReturnsResult),
    UNKNOWN(DatabaseMetaData.procedureResultUnknown);
}