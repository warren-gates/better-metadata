/*
 * Copyright (c) 2022. Warren Gates
 * All rights reserved.
 */

package dev.warrengates.bettermetadata

import java.sql.DatabaseMetaData

/**
 * Foreign key delete rule
 *
 * @property value
 * @constructor Create empty Foreign key delete rule
 */
enum class ForeignKeyDeleteRule(override val value: Int): IntegerEnum {
    /**
     * No Action
     *
     * Source value: [DatabaseMetaData.importedKeyNoAction]
     */// definition https://docs.oracle.com/en/java/javase/17/docs/api/java.sql/java/sql/DatabaseMetaData.html
    NO_ACTION(DatabaseMetaData.importedKeyNoAction),

    /**
     * Cascade
     *
     * Source value: [DatabaseMetaData.importedKeyCascade]
     */
    CASCADE(DatabaseMetaData.importedKeyCascade),

    /**
     * Restrict
     *
     * Source value: [DatabaseMetaData.importedKeyRestrict]
     */
    RESTRICT(DatabaseMetaData.importedKeyRestrict),

    /**
     * Set Default
     *
     * Source value: [DatabaseMetaData.importedKeySetDefault]
     */
    SET_DEFAULT(DatabaseMetaData.importedKeySetDefault),

    /**
     * Set Null
     *
     * Source value: [DatabaseMetaData.importedKeySetNull]
     */
    SET_NULL(DatabaseMetaData.importedKeySetNull);
}