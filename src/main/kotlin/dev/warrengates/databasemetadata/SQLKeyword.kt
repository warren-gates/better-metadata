package dev.warrengates.databasemetadata

/**
 * S q l keyword
 *
 * @property name
 * @constructor Create empty Sql keyword
 */
data class SQLKeyword(val name: String) {
    override fun toString(): String = name
}
