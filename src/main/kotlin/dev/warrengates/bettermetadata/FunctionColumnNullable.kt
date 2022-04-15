/*
 * Copyright (c) 2022. Warren Gates
 * All rights reserved.
 */

package dev.warrengates.bettermetadata

import java.sql.DatabaseMetaData

/**
 * Function column nullable
 *
 * @property type
 * @property text
 * @constructor Create empty Function column nullable
 */
enum class FunctionColumnNullable(override val type: Int, private val text: String): IntegerEnum {
    /**
     * No
     *
     * @constructor Create empty No
     */// definition https://docs.oracle.com/en/java/javase/17/docs/api/java.sql/java/sql/DatabaseMetaData.html
    NO(DatabaseMetaData.functionNoNulls,"NO"),

    /**
     * Yes
     *
     * @constructor Create empty Yes
     */
    YES(DatabaseMetaData.functionNullable, "YES"),

    /**
     * Unknown
     *
     * @constructor Create empty Unknown
     */
    UNKNOWN(DatabaseMetaData.functionNullableUnknown, "");

    override fun toString(): String = text
}