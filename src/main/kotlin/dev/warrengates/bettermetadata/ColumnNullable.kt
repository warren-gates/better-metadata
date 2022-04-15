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
     * @constructor Create empty No
     */// definition https://docs.oracle.com/en/java/javase/17/docs/api/java.sql/java/sql/DatabaseMetaData.html
    NO(DatabaseMetaData.columnNoNulls),

    /**
     * Yes
     *
     * @constructor Create empty Yes
     */
    YES(DatabaseMetaData.columnNullable),

    /**
     * Unknown
     *
     * @constructor Create empty Unknown
     */
    UNKNOWN(DatabaseMetaData.columnNullableUnknown);
}