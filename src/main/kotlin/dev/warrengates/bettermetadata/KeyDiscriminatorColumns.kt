/*
 * Copyright (c) 2022. Warren Gates
 * All rights reserved.
 */

package dev.warrengates.bettermetadata

internal data class KeyDiscriminatorColumns(
    val catalogColumn: String,
    val schemaColumn: String,
    val tableColumn: String
)