/*
 * Copyright (c) 2022. Warren Gates
 * All rights reserved.
 */

package dev.warrengates.bettermetadata

/**
 * Is grantable, values taken from returned strings
 *
 * @property value
 * @constructor Create empty Is grantable
 */
enum class IsGrantable(override val value: String) : StringEnum {
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
     * Source value: NULL, converted to empty string here
     */
    UNKNOWN("");
}