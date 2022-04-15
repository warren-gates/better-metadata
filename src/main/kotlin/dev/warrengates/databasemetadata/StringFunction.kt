package dev.warrengates.databasemetadata

/**
 * String function
 *
 * @property name
 * @constructor Create empty String function
 */
data class StringFunction(val name: String) {
    override fun toString(): String = name
}
