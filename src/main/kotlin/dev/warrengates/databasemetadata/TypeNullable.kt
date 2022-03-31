package dev.warrengates.databasemetadata

import java.sql.DatabaseMetaData

enum class TypeNullable(override val type: Int): IntegerEnum {
    NO(DatabaseMetaData.typeNoNulls),
    YES(DatabaseMetaData.typeNullable),
    UNKNOWN(DatabaseMetaData.typeNullableUnknown);
}