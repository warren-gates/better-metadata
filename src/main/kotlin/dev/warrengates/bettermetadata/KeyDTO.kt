/*
 * Copyright (c) 2022. Warren Gates
 * All rights reserved.
 */

package dev.warrengates.bettermetadata

internal data class KeyDTO(
    val pkName: String?,
    val fkName: String?,
    val updateRule: ForeignKeyUpdateRule,
    val deleteRule: ForeignKeyDeleteRule,
    val deferrability: ForeignKeyInitialDeferrability,
    val keys: MutableList<KeyColumn> = mutableListOf()
)