/*
 * Copyright (c) 2022. Warren Gates
 * All rights reserved.
 */

package dev.warrengates.bettermetadata

import java.sql.DatabaseMetaData

/**
 * Function return type
 *
 * @property value
 * @constructor Create empty Function return type
 */
enum class FunctionReturnType(override val value: Int): IntegerEnum {
    /**
     * No Table
     *
     * @constructor Create empty No Table
     */
    NO_TABLE(DatabaseMetaData.functionNoTable),

    /**
     * Table
     *
     * @constructor Create empty Table
     */
    TABLE(DatabaseMetaData.functionReturnsTable),

    /**
     * Unknown
     *
     * @constructor Create empty Unknown
     */
    UNKNOWN(DatabaseMetaData.functionResultUnknown);
}