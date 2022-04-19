/*
 * Copyright (c) 2022. Warren Gates
 * All rights reserved.
 */

package dev.warrengates.bettermetadata

import java.sql.DatabaseMetaData

/**
 * Procedure column type
 *
 * @property value
 */
enum class ProcedureColumnType(override val value: Int): IntegerEnum {
    /**
     * In
     *
     * Source value: [DatabaseMetaData.procedureColumnIn]
     */
    IN(DatabaseMetaData.procedureColumnIn),

    /**
     * In Out
     *
     * Source value: [DatabaseMetaData.procedureColumnInOut]
     */
    IN_OUT(DatabaseMetaData.procedureColumnInOut),

    /**
     * Out
     *
     * Source value: [DatabaseMetaData.procedureColumnOut]
     */
    OUT(DatabaseMetaData.procedureColumnOut),

    /**
     * Return
     *
     * Source value: [DatabaseMetaData.procedureColumnReturn]
     */
    RETURN(DatabaseMetaData.procedureColumnReturn),

    /**
     * Result
     *
     * Source value: [DatabaseMetaData.procedureColumnResult]
     */
    RESULT(DatabaseMetaData.procedureColumnResult),

    /**
     * Unknown
     *
     * Source value: [DatabaseMetaData.procedureColumnUnknown]
     */
    UNKNOWN(DatabaseMetaData.procedureColumnUnknown);
}