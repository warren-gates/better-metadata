/*
 * Copyright (c) 2022. Warren Gates
 * All rights reserved.
 */

package dev.warrengates.bettermetadata

import java.sql.ResultSet


/**
 * Various integer columns (such as DECIMAL_DIGTS) returned from DatabaseMetaData functions indicate
 * that null is returned when the value is not applicable. Since [ResultSet.getInt] returns 0 for null values,
 * you'll never actually get null returned. If you'd prefer to have nulls returned when null exists in the ResultSet,
 * use the below code. It uses a nullable Int (kotlin) or Integer (java) and sets it to null appropriately.
 *
 * If you'd rather get 0 values instead of nulls, comment out the code immediately below and use the
 * 'Non-nullable int' code at the bottom
 *
 * Note that at this point not all possible values are using this type alias
 *
 */
typealias MetadataInt = Int?
internal fun ResultSet.getMetadataInt(columnName: String): MetadataInt {
    val intValue = this.getInt(columnName)
    return if (this.wasNull()) {
        null
    } else {
        intValue
    }
}

/*
    Non-nullable int
    Use this to get 0 values instead of nulls
 */
//typealias MetadataInt = Int
//fun ResultSet.getMetadataInt(columnName: String): MetadataInt {
//    return this.getInt(columnName)
//}