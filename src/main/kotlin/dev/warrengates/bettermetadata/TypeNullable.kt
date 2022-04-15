/*
 * Copyright (c) 2022. Warren Gates
 * All rights reserved.
 */

package dev.warrengates.bettermetadata

import java.sql.DatabaseMetaData

/**
 * Type nullable
 *
 * @property value
 * @constructor Create empty Type nullable
 */
enum class TypeNullable(override val value: Int): IntegerEnum {
    /**
     * No
     *
     * @constructor Create empty No
     */
    NO(DatabaseMetaData.typeNoNulls),

    /**
     * Yes
     *
     * @constructor Create empty Yes
     */
    YES(DatabaseMetaData.typeNullable),

    /**
     * Unknown
     *
     * @constructor Create empty Unknown
     */
    UNKNOWN(DatabaseMetaData.typeNullableUnknown);
}