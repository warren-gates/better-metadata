package dev.warrengates.databasemetadata

data class SystemFunction(val name: String) {
    override fun toString(): String = name
}
