/*
 * Copyright (c) 2022. Warren Gates
 * All rights reserved.
 */

package dev.warrengates.bettermetadata

import java.sql.DatabaseMetaData

/**
 * Foreign key initial deferrability
 *
 * @property type
 * @constructor Create empty Foreign key initial deferrability
 */
enum class ForeignKeyInitialDeferrability(override val type: Int): IntegerEnum {
    /**
     * Deferred
     *
     * @constructor Create empty Deferred
     */
    DEFERRED(DatabaseMetaData.importedKeyInitiallyDeferred),

    /**
     * Immediate
     *
     * @constructor Create empty Immediate
     */
    IMMEDIATE(DatabaseMetaData.importedKeyInitiallyImmediate),

    /**
     * Not Deferrable
     *
     * @constructor Create empty Not Deferrable
     */
    NOT_DEFERRABLE(DatabaseMetaData.importedKeyNotDeferrable);
}