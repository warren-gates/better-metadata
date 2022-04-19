/*
 * Copyright (c) 2022. Warren Gates
 * All rights reserved.
 */

package dev.warrengates.bettermetadata

import java.sql.DatabaseMetaData

/**
 * Column nullable
 *
 * @property value
 * @constructor Create empty Column nullable
 */
enum class ColumnNullable(override val value: Int): IntegerEnum {
    /**
     * No
     *
     * Source value: [DatabaseMetaData.columnNoNulls]
     */
    NO(DatabaseMetaData.columnNoNulls),

    /**
     * Yes
     *
     * Source value: [DatabaseMetaData.columnNullable]
     */
    YES(DatabaseMetaData.columnNullable),

    /**
     * Unknown
     *
     * Source value: [DatabaseMetaData.columnNullableUnknown]
     */
    UNKNOWN(DatabaseMetaData.columnNullableUnknown);
}