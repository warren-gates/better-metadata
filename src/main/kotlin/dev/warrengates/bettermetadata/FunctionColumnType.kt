/*
 * Copyright (c) 2022. Warren Gates
 * All rights reserved.
 */

package dev.warrengates.bettermetadata

import java.sql.DatabaseMetaData

/**
 * Function column type
 *
 * @property value
 */
enum class FunctionColumnType(override val value: Int): IntegerEnum {
    /**
     * In
     *
     * Source value: [DatabaseMetaData.functionColumnIn]
     */
    IN(DatabaseMetaData.functionColumnIn),

    /**
     * In Out
     *
     * Source value: [DatabaseMetaData.functionColumnInOut]
     */
    IN_OUT(DatabaseMetaData.functionColumnInOut),

    /**
     * Out
     *
     * Source value: [DatabaseMetaData.functionColumnOut]
     */
    OUT(DatabaseMetaData.functionColumnOut),

    /**
     * Result
     *
     * Source value: [DatabaseMetaData.functionColumnResult]
     */
    RESULT(DatabaseMetaData.functionColumnResult),

    /**
     * Return
     *
     * Source value: [DatabaseMetaData.functionReturn]
     */
    RETURN(DatabaseMetaData.functionReturn),

    /**
     * Unknown
     *
     * Source value: [DatabaseMetaData.functionColumnUnknown]
     */
    UNKNOWN(DatabaseMetaData.functionColumnUnknown);
}