package dev.warrengates.databasemetadata

import java.sql.DatabaseMetaData

enum class BestRowColumnType(override val type: Int): IntegerEnum {
    IS_PSEUDO_COLUMN(DatabaseMetaData.bestRowPseudo),
    NOT_PSEUDO_COLUMN(DatabaseMetaData.bestRowNotPseudo),
    UNKNOWN(DatabaseMetaData.bestRowUnknown);
}