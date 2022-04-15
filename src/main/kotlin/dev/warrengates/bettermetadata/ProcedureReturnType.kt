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
     * @constructor Create empty No Result
     */
    NO_RESULT(DatabaseMetaData.procedureNoResult),

    /**
     * Returns Result
     *
     * @constructor Create empty Returns Result
     */
    RETURNS_RESULT(DatabaseMetaData.procedureReturnsResult),

    /**
     * Unknown
     *
     * @constructor Create empty Unknown
     */
    UNKNOWN(DatabaseMetaData.procedureResultUnknown);
}