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
    @get:SourceColumn("PK_NAME")
    val primaryKeyName: String?,

    /**
     * Foreign key name
     *
     * Source column: FK_NAME
     */
    @get:SourceColumn("FK_NAME")
    val foreignKeyName: String?,

    /**
     * Update rule, converted to [ForeignKeyUpdateRule]
     *
     * Source column: UPDATE_RULE
     */
    @get:SourceColumn("UPDATE_RULE")
    val updateRule: ForeignKeyUpdateRule,

    /**
     * Delete rule, converted to [ForeignKeyDeleteRule]
     *
     * Source column: DELETE_RULE
     */
    @get:SourceColumn("DELETE_RULE")
    val deleteRule: ForeignKeyDeleteRule,

    /**
     * Deferrability, converted to [ForeignKeyInitialDeferrability]
     *
     * Source column: DEFERRABILITY
     */
    @get:SourceColumn("DEFERRABILITY")
    val deferrability: ForeignKeyInitialDeferrability,

    /**
     * List of [KeyColumn]s making up this key
     */
    val keyColumns: List<KeyColumn>

) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Key

        if (primaryKeyName != other.primaryKeyName) return false
        if (foreignKeyName != other.foreignKeyName) return false
        if (updateRule != other.updateRule) return false
        if (deleteRule != other.deleteRule) return false
        if (deferrability != other.deferrability) return false
        if (keyColumns != other.keyColumns) return false

        return true
    }

    override fun hashCode(): Int {
        var result = primaryKeyName?.hashCode() ?: 0
        result = 31 * result + (foreignKeyName?.hashCode() ?: 0)
        result = 31 * result + updateRule.hashCode()
        result = 31 * result + deleteRule.hashCode()
        result = 31 * result + deferrability.hashCode()
        result = 31 * result + keyColumns.hashCode()
        return result
    }
}