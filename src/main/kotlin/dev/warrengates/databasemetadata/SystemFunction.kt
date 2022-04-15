package dev.warrengates.databasemetadata

/**
 * System function
 *
 * @property name
 * @constructor Create empty System function
 */
data class SystemFunction(val name: String) {
    override fun toString(): String = name
}
