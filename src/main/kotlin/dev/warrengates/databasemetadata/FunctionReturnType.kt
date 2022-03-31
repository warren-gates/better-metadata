package dev.warrengates.databasemetadata

import java.sql.DatabaseMetaData

enum class FunctionReturnType(override val type: Int): IntegerEnum {
    NO_TABLE(DatabaseMetaData.functionNoTable),
    TABLE(DatabaseMetaData.functionReturnsTable),
    UNKNOWN(DatabaseMetaData.functionResultUnknown);
}