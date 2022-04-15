package dev.warrengates.databasemetadata

/**
 * Numeric function
 *
 * @property name
 * @constructor Create empty Numeric function
 */
data class NumericFunction(val name: String) {
    override fun toString(): String = name
}
