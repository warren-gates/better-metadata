package dev.warrengates.databasemetadata

import java.sql.DatabaseMetaData

enum class FunctionColumnType(override val type: Int): IntegerEnum {
    IN(DatabaseMetaData.functionColumnIn),
    IN_OUT(DatabaseMetaData.functionColumnInOut),
    OUT(DatabaseMetaData.functionColumnOut),
    RESULT(DatabaseMetaData.functionColumnResult),

    // TODO: doublecheck this column type
    RETURN(DatabaseMetaData.functionReturn),
    UNKNOWN(DatabaseMetaData.functionColumnUnknown);
}