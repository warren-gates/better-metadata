package dev.warrengates.bettermetadata

import java.sql.ResultSet

/**
 * Result set type
 *
 * @property type
 * @constructor Create empty Result set type
 */
enum class ResultSetType(override val type: Int): IntegerEnum {
    /**
     * Forward Only
     *
     * @constructor Create empty Forward Only
     */
    FORWARD_ONLY(ResultSet.TYPE_FORWARD_ONLY),

    /**
     * Scroll Insensitive
     *
     * @constructor Create empty Scroll Insensitive
     */
    SCROLL_INSENSITIVE(ResultSet.TYPE_SCROLL_INSENSITIVE),

    /**
     * Scroll Sensitive
     *
     * @constructor Create empty Scroll Sensitive
     */
    SCROLL_SENSITIVE(ResultSet.TYPE_SCROLL_SENSITIVE);
}