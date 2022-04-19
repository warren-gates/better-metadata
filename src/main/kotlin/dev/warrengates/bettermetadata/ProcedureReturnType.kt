/*
 * Copyright (c) 2022. Warren Gates
 * All rights reserved.
 */

package dev.warrengates.bettermetadata

import java.sql.DatabaseMetaData

/**
 * Procedure return type
 *
 * @property value
 * @constructor Create empty Procedure return type
 */
enum class ProcedureReturnType(override val value: Int): IntegerEnum {
    /**
     * No Result
     *
     * Source value: [DatabaseMetaData.procedureNoResult]
     */
    NO_RESULT(DatabaseMetaData.procedureNoResult),

    /**
     * Returns Result
     *
     * Source value: [DatabaseMetaData.procedureReturnsResult]
     */
    RETURNS_RESULT(DatabaseMetaData.procedureReturnsResult),

    /**
     * Unknown
     *
     * Source value: [DatabaseMetaData.procedureResultUnknown]
     */
    UNKNOWN(DatabaseMetaData.procedureResultUnknown);
}