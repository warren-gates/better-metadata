package dev.warrengates.databasemetadata

import java.sql.DatabaseMetaData

enum class ColumnNullable(override val type: Int): IntegerEnum {
    // definition https://docs.oracle.com/en/java/javase/17/docs/api/java.sql/java/sql/DatabaseMetaData.html
    NO(DatabaseMetaData.columnNoNulls),
    YES(DatabaseMetaData.columnNullable),
    UNKNOWN(DatabaseMetaData.columnNullableUnknown);
}