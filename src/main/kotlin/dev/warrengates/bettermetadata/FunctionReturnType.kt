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
 */
enum class FunctionReturnType(override val value: Int): IntegerEnum {
    /**
     * No Table
     *
     * Source value: [DatabaseMetaData.functionNoTable]
     */
    NO_TABLE(DatabaseMetaData.functionNoTable),

    /**
     * Table
     *
     * Source value: [DatabaseMetaData.functionReturnsTable]
     */
    TABLE(DatabaseMetaData.functionReturnsTable),

    /**
     * Unknown
     *
     * Source value: [DatabaseMetaData.functionResultUnknown]
     */
    UNKNOWN(DatabaseMetaData.functionResultUnknown);
}