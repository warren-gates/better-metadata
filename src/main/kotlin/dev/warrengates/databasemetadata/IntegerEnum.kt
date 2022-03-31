package dev.warrengates.databasemetadata

interface IntegerEnum {
    val type: Int

    fun toInt(): Int = type
}