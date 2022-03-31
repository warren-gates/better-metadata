package dev.warrengates.databasemetadata

import java.sql.DatabaseMetaData

enum class VersionColumnType(override val type: Int): IntegerEnum {
    IS_PSEUDO_COLUMN(DatabaseMetaData.versionColumnPseudo),
    NOT_PSEUDO_COLUMN(DatabaseMetaData.versionColumnNotPseudo),
    UNKNOWN(DatabaseMetaData.versionColumnUnknown);
}