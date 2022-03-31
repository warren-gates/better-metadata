package dev.warrengates.databasemetadata

data class TimeDateFunction(val name: String) {
    override fun toString(): String {
        return name
    }
}
