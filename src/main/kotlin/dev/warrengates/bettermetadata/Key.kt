/*
 * Copyright (c) 2022. Warren Gates
 * All rights reserved.
 */

package dev.warrengates.bettermetadata


/**
 * Key
 *
 * @property primaryKeyName
 * @property foreignKeyName
 * @property updateRule
 * @property deleteRule
 * @property deferrability
 * @property keyColumns
 * @constructor Create empty Key
 */
@Suppress("unused")
class Key(

    /**
     * Primary key name
     *
     * Source column: PK_NAME
     */
    val primaryKeyName: String?,

    /**
     * Foreign key name
     *
     * Source column: FK_NAME
     */
    val foreignKeyName: String?,

    /**
     * Update rule, converted to [ForeignKeyUpdateRule]
     *
     * Source column: UPDATE_RULE
     */
    val updateRule: ForeignKeyUpdateRule,

    /**
     * Delete rule, converted to [ForeignKeyDeleteRule]
     *
     * Source column: DELETE_RULE
     */
    val deleteRule: ForeignKeyDeleteRule,

    /**
     * Deferrability, converted to [ForeignKeyInitialDeferrability]
     *
     * Source column: DEFERRABILITY
     */
    val deferrability: ForeignKeyInitialDeferrability,

    /**
     * List of [KeyColumn]s making up this key
     */
    val keyColumns: List<KeyColumn>
)