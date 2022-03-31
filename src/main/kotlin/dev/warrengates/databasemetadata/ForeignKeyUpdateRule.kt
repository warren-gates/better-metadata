package dev.warrengates.databasemetadata

import java.sql.DatabaseMetaData

enum class ForeignKeyUpdateRule(override val type: Int): IntegerEnum {
    NO_ACTION(DatabaseMetaData.importedKeyNoAction),
    CASCADE(DatabaseMetaData.importedKeyCascade),
    RESTRICT(DatabaseMetaData.importedKeyRestrict),
    SET_DEFAULT(DatabaseMetaData.importedKeySetDefault),
    SET_NULL(DatabaseMetaData.importedKeySetNull);
}