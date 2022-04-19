/*
 * Copyright (c) 2022. Warren Gates
 * All rights reserved.
 */

package dev.warrengates.bettermetadata

import java.sql.DatabaseMetaData

/**
 * Function column nullable
 *
 * @property value
 */
enum class FunctionColumnNullable(override val value: Int): IntegerEnum {
    /**
     * No
     *
     * Source value: [DatabaseMetaData.functionNoNulls]
     */
    NO(DatabaseMetaData.functionNoNulls),

    /**
     * Yes
     *
     * Source value: [DatabaseMetaData.functionNullable]
     */
    YES(DatabaseMetaData.functionNullable),

    /**
     * Unknown
     *
     * Source value: [DatabaseMetaData.functionNullableUnknown]
     */
    UNKNOWN(DatabaseMetaData.functionNullableUnknown);

}