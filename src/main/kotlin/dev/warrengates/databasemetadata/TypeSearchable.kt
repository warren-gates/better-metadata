package dev.warrengates.databasemetadata

import java.sql.DatabaseMetaData

enum class TypeSearchable(override val type: Int): IntegerEnum {
    BASIC(DatabaseMetaData.typePredBasic),
    // TODO: is 'character' correct word?
    CHARACTER(DatabaseMetaData.typePredChar),
    NONE(DatabaseMetaData.typePredNone),
    SEARCHABLE(DatabaseMetaData.typeSearchable);
}