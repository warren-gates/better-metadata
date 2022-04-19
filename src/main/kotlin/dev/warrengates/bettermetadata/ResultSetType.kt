/*
 * Copyright (c) 2022. Warren Gates
 * All rights reserved.
 */

package dev.warrengates.bettermetadata

import java.sql.ResultSet

/**
 * Result set type
 *
 * @property value
 */
enum class ResultSetType(override val value: Int): IntegerEnum {
    /**
     * Forward Only
     *
     * Source value: [ResultSet.TYPE_FORWARD_ONLY]
     */
    FORWARD_ONLY(ResultSet.TYPE_FORWARD_ONLY),

    /**
     * Scroll Insensitive
     *
     * Source value: [ResultSet.TYPE_SCROLL_INSENSITIVE]
     */
    SCROLL_INSENSITIVE(ResultSet.TYPE_SCROLL_INSENSITIVE),

    /**
     * Scroll Sensitive
     *
     * Source value: [ResultSet.TYPE_SCROLL_SENSITIVE]
     */
    SCROLL_SENSITIVE(ResultSet.TYPE_SCROLL_SENSITIVE);
}