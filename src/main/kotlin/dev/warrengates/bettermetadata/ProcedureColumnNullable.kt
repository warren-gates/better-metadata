/*
 * Copyright (c) 2022. Warren Gates
 * All rights reserved.
 */

package dev.warrengates.bettermetadata

import java.sql.DatabaseMetaData

/**
 * Procedure column nullable
 *
 * @property type
 * @property text
 * @constructor Create empty Procedure column nullable
 */
enum class ProcedureColumnNullable(override val type: Int, private val text: String): IntegerEnum {
    /**
     * No
     *
     * @constructor Create empty No
     */
    NO(DatabaseMetaData.procedureNoNulls,"YES"),

    /**
     * Yes
     *
     * @constructor Create empty Yes
     */
    YES(DatabaseMetaData.procedureNullable, "NO"),

    /**
     * Unknown
     *
     * @constructor Create empty Unknown
     */
    UNKNOWN(DatabaseMetaData.procedureNullableUnknown, "");

    override fun toString(): String = text
}