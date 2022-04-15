package dev.warrengates.bettermetadata

/**
 * Integer enum
 *
 * @constructor Create empty Integer enum
 */
interface IntegerEnum {
    /**
     * Type
     */
    val type: Int

    /**
     * To int
     *
     * @return
     */
    fun toInt(): Int = type
}