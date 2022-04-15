package dev.warrengates.databasemetadata

import java.sql.DatabaseMetaData

/**
 * Type searchable
 *
 * @property type
 * @constructor Create empty Type searchable
 */
enum class TypeSearchable(override val type: Int): IntegerEnum {
    /**
     * Basic
     *
     * @constructor Create empty Basic
     */
    BASIC(DatabaseMetaData.typePredBasic),

    /**
     * Character
     *
     * @constructor Create empty Character
     */// TODO: is 'character' correct word?
    CHARACTER(DatabaseMetaData.typePredChar),

    /**
     * None
     *
     * @constructor Create empty None
     */
    NONE(DatabaseMetaData.typePredNone),

    /**
     * Searchable
     *
     * @constructor Create empty Searchable
     */
    SEARCHABLE(DatabaseMetaData.typeSearchable);
}