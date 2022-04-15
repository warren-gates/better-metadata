package dev.warrengates.databasemetadata

import java.sql.DatabaseMetaData
import java.sql.JDBCType
import java.sql.ResultSet

/**
 * Get iterable from rs
 *
 * @param T
 * @param rs
 * @param creator
 * @receiver
 * @return
 */
inline fun <reified T> getIterableFromRs(rs: ResultSet, creator: (ResultSet) -> T): List<T> {
    val items = mutableListOf<T>()
    while (rs.next()) {
        items.add(creator(rs))
    }
    return items.toList()
}

/**
 * Get iterable from rs
 *
 * @param T
 * @param metaData
 * @param rs
 * @param creator
 * @receiver
 * @return
 */
inline fun <reified T> getIterableFromRs(
    metaData: DatabaseMetaData, rs: ResultSet, creator: (DatabaseMetaData, ResultSet) -> T,
): List<T> {
    val items = mutableListOf<T>()
    while (rs.next()) {
        items.add(creator(metaData, rs))
    }
    return items.toList()
}

/**
 * Value of
 *
 * @param T
 * @param value
 * @return
 */
inline fun <reified T> valueOf(value: Int): T where T : Enum<T>, T : IntegerEnum {
    return enumValues<T>().first { value == it.type }
}

inline fun <reified T> ResultSet.getEnum(columnName: String): T where T : Enum<T>, T : IntegerEnum {
    val type = this.getObject(columnName) as Int
    return valueOf(type)
}

// TODO: document this, see if gradle can conditionally compile one version vs other
typealias MetadataInt = Int?
fun ResultSet.getMetadataInt(columnName: String): MetadataInt {
    val intValue = this.getInt(columnName)
    return if (this.wasNull()) {
        null
    } else {
        intValue
    }
}

//typealias MetadataInt = Int
//fun ResultSet.getMetadataInt(columnName: String): MetadataInt {
//    return this.getInt(columnName)
//}

fun ResultSet.getJDBCType(columnName: String): JDBCType {
    return JDBCType.valueOf(this.getInt(columnName))
}
