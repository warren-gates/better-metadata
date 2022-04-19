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
 */
enum class VersionColumnType(override val value: Int): IntegerEnum {
    /**
     * Is Pseudo Column
     *
     * Source value: [DatabaseMetaData.versionColumnPseudo]
     */
    IS_PSEUDO_COLUMN(DatabaseMetaData.versionColumnPseudo),

    /**
     * Not Pseudo Column
     *
     * Source value: [DatabaseMetaData.versionColumnNotPseudo]
     */
    NOT_PSEUDO_COLUMN(DatabaseMetaData.versionColumnNotPseudo),

    /**
     * Unknown
     *
     * Source value: [DatabaseMetaData.versionColumnUnknown]
     */
    UNKNOWN(DatabaseMetaData.versionColumnUnknown);
}