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
 */
enum class TypeNullable(override val value: Int): IntegerEnum {
    /**
     * No
     *
     * Source value: [DatabaseMetaData.typeNoNulls]
     */
    NO(DatabaseMetaData.typeNoNulls),

    /**
     * Yes
     *
     * Source value: [DatabaseMetaData.typeNullable]
     */
    YES(DatabaseMetaData.typeNullable),

    /**
     * Unknown
     *
     * Source value: [DatabaseMetaData.typeNullableUnknown]
     */
    UNKNOWN(DatabaseMetaData.typeNullableUnknown);
}