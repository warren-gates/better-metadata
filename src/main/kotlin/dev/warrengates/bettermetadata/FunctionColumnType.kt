/*
 * Copyright (c) 2022. Warren Gates
 * All rights reserved.
 */

package dev.warrengates.bettermetadata

import java.sql.DatabaseMetaData

/**
 * Function column type
 *
 * @property type
 * @constructor Create empty Function column type
 */
enum class FunctionColumnType(override val type: Int): IntegerEnum {
    /**
     * In
     *
     * @constructor Create empty In
     */
    IN(DatabaseMetaData.functionColumnIn),

    /**
     * In Out
     *
     * @constructor Create empty In Out
     */
    IN_OUT(DatabaseMetaData.functionColumnInOut),

    /**
     * Out
     *
     * @constructor Create empty Out
     */
    OUT(DatabaseMetaData.functionColumnOut),

    /**
     * Result
     *
     * @constructor Create empty Result
     */
    RESULT(DatabaseMetaData.functionColumnResult),

    /**
     * Return
     *
     * @constructor Create empty Return
     */// TODO: doublecheck this column type
    RETURN(DatabaseMetaData.functionReturn),

    /**
     * Unknown
     *
     * @constructor Create empty Unknown
     */
    UNKNOWN(DatabaseMetaData.functionColumnUnknown);
}