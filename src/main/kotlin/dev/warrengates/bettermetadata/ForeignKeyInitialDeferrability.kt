/*
 * Copyright (c) 2022. Warren Gates
 * All rights reserved.
 */

package dev.warrengates.bettermetadata

import java.sql.DatabaseMetaData

/**
 * Foreign key initial deferrability
 *
 * @property value
 * @constructor Create empty Foreign key initial deferrability
 */
enum class ForeignKeyInitialDeferrability(override val value: Int): IntegerEnum {
    /**
     * Deferred
     *
     * Source value: [DatabaseMetaData.importedKeyInitiallyDeferred]
     */
    DEFERRED(DatabaseMetaData.importedKeyInitiallyDeferred),

    /**
     * Immediate
     *
     * Source value: [DatabaseMetaData.importedKeyInitiallyImmediate]
     */
    IMMEDIATE(DatabaseMetaData.importedKeyInitiallyImmediate),

    /**
     * Not Deferrable
     *
     * Source value: [DatabaseMetaData.importedKeyNotDeferrable]
     */
    NOT_DEFERRABLE(DatabaseMetaData.importedKeyNotDeferrable);
}