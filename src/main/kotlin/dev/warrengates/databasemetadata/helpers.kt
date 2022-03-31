package dev.warrengates.databasemetadata

import java.sql.DatabaseMetaData
import java.sql.ResultSet

inline fun <reified T> getIterableFromRs(rs: ResultSet, creator: (ResultSet) -> T): List<T> {
    val items = mutableListOf<T>()
    while (rs.next()) {
        items.add(creator(rs))
    }
    return items.toList()
}

inline fun <reified T> getIterableFromRs(
    metaData: DatabaseMetaData, rs: ResultSet, creator: (DatabaseMetaData, ResultSet) -> T
): List<T> {
    val items = mutableListOf<T>()
    while (rs.next()) {
        items.add(creator(metaData, rs))
    }
    return items.toList()
}

inline fun <reified T> valueOf(value: Int): T where T: Enum<T>, T:IntegerEnum {
    return enumValues<T>().first { value == it.type }
}