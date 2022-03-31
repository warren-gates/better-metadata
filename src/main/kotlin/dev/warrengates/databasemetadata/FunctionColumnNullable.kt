package dev.warrengates.databasemetadata

import java.sql.DatabaseMetaData

enum class FunctionColumnNullable(override val type: Int, private val text: String): IntegerEnum {
    // definition https://docs.oracle.com/en/java/javase/17/docs/api/java.sql/java/sql/DatabaseMetaData.html
    NO(DatabaseMetaData.functionNoNulls,"NO"),
    YES(DatabaseMetaData.functionNullable, "YES"),
    UNKNOWN(DatabaseMetaData.functionNullableUnknown, "");

    override fun toString(): String = text
}