/*
 * Copyright (c) 2022. Warren Gates
 * All rights reserved.
 */

package dev.warrengates.bettermetadata

import java.sql.ResultSet


// TODO: document this, see if gradle can conditionally compile one version vs other

/**
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

//typealias MetadataInt = Int
//fun ResultSet.getMetadataInt(columnName: String): MetadataInt {
//    return this.getInt(columnName)
//}