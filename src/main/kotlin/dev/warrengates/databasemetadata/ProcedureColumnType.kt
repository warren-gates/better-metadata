package dev.warrengates.databasemetadata

import java.sql.DatabaseMetaData

enum class ProcedureColumnType(override val type: Int): IntegerEnum {
    IN(DatabaseMetaData.procedureColumnIn),
    IN_OUT(DatabaseMetaData.procedureColumnInOut),
    OUT(DatabaseMetaData.procedureColumnOut),
    RETURN(DatabaseMetaData.procedureColumnReturn),
    RESULT(DatabaseMetaData.procedureColumnResult),
    UNKNOWN(DatabaseMetaData.procedureColumnUnknown);
}