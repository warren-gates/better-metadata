package dev.warrengates.databasemetadata

import java.sql.DatabaseMetaData

enum class AttributeNullable(override val type: Int) : IntegerEnum {
    // definition https://docs.oracle.com/en/java/javase/17/docs/api/java.sql/java/sql/DatabaseMetaData.html
    NO(DatabaseMetaData.attributeNoNulls.toInt()),
    YES(DatabaseMetaData.attributeNullable.toInt()),
    UNKNOWN(DatabaseMetaData.attributeNullableUnknown.toInt());
}