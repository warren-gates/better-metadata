package dev.warrengates.databasemetadata

import java.sql.DatabaseMetaData

enum class ForeignKeyDeleteRule(override val type: Int): IntegerEnum {
    // definition https://docs.oracle.com/en/java/javase/17/docs/api/java.sql/java/sql/DatabaseMetaData.html
    NO_ACTION(DatabaseMetaData.importedKeyNoAction),
    CASCADE(DatabaseMetaData.importedKeyCascade),
    RESTRICT(DatabaseMetaData.importedKeyRestrict),
    SET_DEFAULT(DatabaseMetaData.importedKeySetDefault),
    SET_NULL(DatabaseMetaData.importedKeySetNull);
}