/*
 * Copyright (c) 2022. Warren Gates
 * All rights reserved.
 */

package dev.warrengates.bettermetadata

/**
 * Is auto increment, values taken from returned strings
 *
 * @property value
 */
enum class IsAutoIncrement(override val value: String) : StringEnum {
    /**
     * Yes
     *
     * Source value: "YES"'"
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