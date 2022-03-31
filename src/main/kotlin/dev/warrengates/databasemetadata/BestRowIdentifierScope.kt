package dev.warrengates.databasemetadata

import java.sql.DatabaseMetaData

enum class BestRowIdentifierScope(override val type: Int): IntegerEnum {
    SESSION(DatabaseMetaData.bestRowSession),
    TEMPORARY(DatabaseMetaData.bestRowTemporary),
    TRANSACTION(DatabaseMetaData.bestRowTransaction);
}