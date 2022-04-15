/*
 * Copyright (c) 2022. Warren Gates
 * All rights reserved.
 */

package dev.warrengates.bettermetadata

import java.sql.DatabaseMetaData

/**
 * Version column type
 *
 * @property value
 * @constructor Create empty Version column type
 */
enum class VersionColumnType(override val value: Int): IntegerEnum {
    /**
     * Is Pseudo Column
     *
     * @constructor Create empty Is Pseudo Column
     */
    IS_PSEUDO_COLUMN(DatabaseMetaData.versionColumnPseudo),

    /**
     * Not Pseudo Column
     *
     * @constructor Create empty Not Pseudo Column
     */
    NOT_PSEUDO_COLUMN(DatabaseMetaData.versionColumnNotPseudo),

    /**
     * Unknown
     *
     * @constructor Create empty Unknown
     */
    UNKNOWN(DatabaseMetaData.versionColumnUnknown);
}