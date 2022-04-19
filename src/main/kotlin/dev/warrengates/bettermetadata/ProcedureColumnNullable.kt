/*
 * Copyright (c) 2022. Warren Gates
 * All rights reserved.
 */

package dev.warrengates.bettermetadata

import java.sql.DatabaseMetaData

/**
 * Procedure column nullable
 *
 * @property value
 */
enum class ProcedureColumnNullable(override val value: Int): IntegerEnum {
    /**
     * No
     *
     * Source value: [DatabaseMetaData.procedureNoNulls]
     */
    NO(DatabaseMetaData.procedureNoNulls),

    /**
     * Yes
     *
     * Source value: [DatabaseMetaData.procedureNullable]
     */
    YES(DatabaseMetaData.procedureNullable),

    /**
     * Unknown
     *
     * Source value: [DatabaseMetaData.procedureNullableUnknown]
     */
    UNKNOWN(DatabaseMetaData.procedureNullableUnknown);
}