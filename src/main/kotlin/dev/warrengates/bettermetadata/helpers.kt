/*
 * Copyright (c) 2022 Warren Gates
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.warrengates.bettermetadata

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
internal inline fun <reified T> getIterableFromRs(rs: ResultSet, creator: (ResultSet) -> T): List<T> {
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
internal inline fun <reified T> getIterableFromRs(
    metaData: DatabaseMetaData, rs: ResultSet, creator: (DatabaseMetaData, ResultSet) -> T,
): List<T> {
    val items = mutableListOf<T>()
    while (rs.next()) {
        items.add(creator(metaData, rs))
    }
    return items.toList()
}


internal fun getKeys(metadata: DatabaseMetaData, rs: ResultSet, discriminator: KeyDiscriminatorColumns): List<Key> {
    val dtoKeys = mutableMapOf<Triple<String, String, String>, KeyDTO>()
    val columns = getIterableFromRs(metadata.getColumns(null, null, null, null))
    { Column(metadata, it) }

    while (rs.next()) {
        val pkTableCat = rs.getString(discriminator.catalogColumn)
        val pkTableSchema = rs.getString(discriminator.schemaColumn)
        val pkTableName = rs.getString(discriminator.tableColumn)
        val mapKey = Triple(pkTableCat, pkTableSchema, pkTableName)
        val dtoKey = dtoKeys.getOrDefault(
            mapKey, KeyDTO(
                rs.getString("PK_NAME"),
                rs.getString("FK_NAME"),
                valueOf(rs.getShort("UPDATE_RULE").toInt()),
                valueOf(rs.getShort("DELETE_RULE").toInt()),
                valueOf(rs.getShort("DEFERRABILITY").toInt())
            )
        )
        val pkColumn = columns.first {
            it.catalog == rs.getString("PKTABLE_CAT") &&
                    it.schema == rs.getString("PKTABLE_SCHEM") &&
                    it.tableName == rs.getString("PKTABLE_NAME") &&
                    it.name == rs.getString("PKCOLUMN_NAME")
        }

        val fkColumn = columns.first {
            it.catalog == rs.getString("FKTABLE_CAT") &&
                    it.schema == rs.getString("FKTABLE_SCHEM") &&
                    it.tableName == rs.getString("FKTABLE_NAME") &&
                    it.name == rs.getString("FKCOLUMN_NAME")
        }

        val sequenceNumber = rs.getShort("KEY_SEQ").toInt()

        dtoKey.keys.add(KeyColumn(pkColumn, fkColumn, sequenceNumber))
        dtoKeys[mapKey] = dtoKey
    }

    return dtoKeys.map { (_, value) ->
        Key(
            value.pkName,
            value.fkName,
            value.updateRule,
            value.deleteRule,
            value.deferrability,
            value.keys.toList()
        )
    }
}

/**
 * Gets enum of type [T] where the enums' value matches [value]. The enum must implement [IntegerEnum]
 *
 * @param T
 * @param value
 * @return
 */
inline fun <reified T> valueOf(value: Int): T where T : Enum<T>, T : IntegerEnum {
    return enumValues<T>().first { it.value == value }
}


/**
 * Gets enum of type [T] where the enums' value matches [value]. The enum must implement [StringEnum]
 *
 * @param T
 * @param value
 * @return
 */
inline fun <reified T> valueOf(value: String): T where T : Enum<T>, T : StringEnum {
    return enumValues<T>().first { value == it.value }
}

internal inline fun <reified T> ResultSet.getIntegerEnum(columnName: String): T where T : Enum<T>, T : IntegerEnum {
    val type = this.getInt(columnName)
    return valueOf(type)
}

internal inline fun <reified T> ResultSet.getStringEnum(columnName: String): T where T : Enum<T>, T : StringEnum {
    // elvis needed for isGrantable in ColumnPrivilege which returns null for unknown,
    // other uses return empty string
    val type = this.getString(columnName) ?: ""
    return valueOf(type)
}

internal fun ResultSet.getJDBCType(columnName: String): JDBCType {
    try {
        val value = this.getObject(columnName)

        if (this.wasNull()) {
            return JDBCType.NULL
        }
        return JDBCType.valueOf(value.toString().toInt())
    } catch (ex: Exception) {
        println("no JDBCType for for column $columnName value '${this.getObject(columnName).toString()}'")
        throw ex
    }
}
