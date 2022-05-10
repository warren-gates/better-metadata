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
//typealias MetadataInt = Int?
//internal fun ResultSet.getMetadataInt(columnName: String): MetadataInt {
//    val intValue = this.getInt(columnName)
//    return if (this.wasNull()) {
//        null
//    } else {
//        intValue
//    }
//}

/*
    Non-nullable int
    Use this to get 0 values instead of nulls
 */
typealias MetadataInt = Int
fun ResultSet.getMetadataInt(columnName: String): MetadataInt {
    return this.getInt(columnName)
}