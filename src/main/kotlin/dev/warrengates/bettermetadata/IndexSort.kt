/*
 * Copyright (c) 2022. Warren Gates
 * All rights reserved.
 */

package dev.warrengates.bettermetadata

/**
 * Index sort
 *
 * @property value
 * @constructor Create empty Index sort
 */
enum class IndexSort(override val value: String):StringEnum {
    /**
     * Ascending
     *
     * Source value: "A"
     */
    ASCENDING("A"),

    /**
     * Descending
     *
     * Source value: "D"
     */
    DESCENDING("D"),

    /**
     * Not Applicable
     *
     * Source value: NULL, converted to empty string here
     */
    NOT_APPLICABLE("");
}