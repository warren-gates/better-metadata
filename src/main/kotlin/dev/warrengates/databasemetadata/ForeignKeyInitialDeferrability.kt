package dev.warrengates.databasemetadata

import java.sql.DatabaseMetaData

enum class ForeignKeyInitialDeferrability(override val type: Int): IntegerEnum {
    DEFERRED(DatabaseMetaData.importedKeyInitiallyDeferred),
    IMMEDIATE(DatabaseMetaData.importedKeyInitiallyImmediate),
    NOT_DEFERRABLE(DatabaseMetaData.importedKeyNotDeferrable);
}