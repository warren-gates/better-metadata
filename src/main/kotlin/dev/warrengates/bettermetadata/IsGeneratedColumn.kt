/*
 * Copyright (c) 2022. Warren Gates
 * All rights reserved.
 */

package dev.warrengates.bettermetadata

/**
 * Is generated column, values taken from returned strings
 *
 * @property value
 * @constructor Create empty Is generated column
 */
enum class IsGeneratedColumn(override val value: String) : StringEnum {
    /**
     * Yes
     *
     * Source value: "YES"
     */
    YES("YES"),

    /**
     * No
     *
     * Source value: "NO"
     */
    NO("NO"),

    /**
     * Unknown
     *
     * Source value: "" (empty string)
     */
    UNKNOWN("");
}