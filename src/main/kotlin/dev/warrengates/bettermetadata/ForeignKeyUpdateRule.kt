package dev.warrengates.bettermetadata

import java.sql.DatabaseMetaData

/**
 * Foreign key update rule
 *
 * @property type
 * @constructor Create empty Foreign key update rule
 */
enum class ForeignKeyUpdateRule(override val type: Int): IntegerEnum {
    /**
     * No Action
     *
     * @constructor Create empty No Action
     */
    NO_ACTION(DatabaseMetaData.importedKeyNoAction),

    /**
     * Cascade
     *
     * @constructor Create empty Cascade
     */
    CASCADE(DatabaseMetaData.importedKeyCascade),

    /**
     * Restrict
     *
     * @constructor Create empty Restrict
     */
    RESTRICT(DatabaseMetaData.importedKeyRestrict),

    /**
     * Set Default
     *
     * @constructor Create empty Set Default
     */
    SET_DEFAULT(DatabaseMetaData.importedKeySetDefault),

    /**
     * Set Null
     *
     * @constructor Create empty Set Null
     */
    SET_NULL(DatabaseMetaData.importedKeySetNull);
}