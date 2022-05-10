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
 * Wrapper for results of [getColumnPrivileges](https://docs.oracle.com/en/java/javase/17/docs/api/java.sql/java/sql/DatabaseMetaData.html#getColumns(java.lang.String,java.lang.String,java.lang.String,java.lang.String))
 * method. Used from [Column.getColumnPrivileges]
 *
 * @constructor
 *
 * @param rs
 */
class ColumnPrivilege(rs: ResultSet) {
    /**
     * Catalog
     *
     * Source column: TABLE_CAT
     */
    @get:SourceColumn("TABLE_CAT")
    val catalog: String? = rs.getString("TABLE_CAT")

    /**
     * Schema
     *
     * Source column: TABLE_SCHEM
     */
    @get:SourceColumn("TABLE_SCHEM")
    val schema: String? = rs.getString("TABLE_SCHEM")

    /**
     * Table name
     *
     * Source column: TABLE_NAME
     */
    @get:SourceColumn("TABLE_NAME")
    val tableName: String? = rs.getString("TABLE_NAME")

    /**
     * Column name
     *
     * Source column: COLUMN_NAME
     */
    @get:SourceColumn("COLUMN_NAME")
    val columnName: String? = rs.getString("COLUMN_NAME")

    /**
     * Grantor
     *
     * Source column: GRANTOR
     */
    @get:SourceColumn("GRANTOR")
    val grantor: String? = rs.getString("GRANTOR")

    /**
     * Grantee
     *
     * Source column: GRANTEE
     */
    @get:SourceColumn("GRANTEE")
    val grantee: String? = rs.getString("GRANTEE")

    /**
     * Privilege
     *
     * Source column: PRIVILEGE
     */
    @get:SourceColumn("PRIVILEGE")
    val privilege: String? = rs.getString("PRIVILEGE")

    /**
     * Is grantable, converted to [IsGrantable]
     *
     * Source column: IS_GRANTABLE
     */
    @get:SourceColumn("IS_GRANTABLE")
    val isGrantable: String? = rs.getString("IS_GRANTABLE")
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ColumnPrivilege

        if (catalog != other.catalog) return false
        if (schema != other.schema) return false
        if (tableName != other.tableName) return false
        if (columnName != other.columnName) return false
        if (grantor != other.grantor) return false
        if (grantee != other.grantee) return false
        if (privilege != other.privilege) return false
        if (isGrantable != other.isGrantable) return false

        return true
    }

    override fun hashCode(): Int {
        var result = catalog?.hashCode() ?: 0
        result = 31 * result + (schema?.hashCode() ?: 0)
        result = 31 * result + (tableName?.hashCode() ?: 0)
        result = 31 * result + (columnName?.hashCode() ?: 0)
        result = 31 * result + (grantor?.hashCode() ?: 0)
        result = 31 * result + (grantee?.hashCode() ?: 0)
        result = 31 * result + (privilege?.hashCode() ?: 0)
        result = 31 * result + (isGrantable?.hashCode() ?: 0)
        return result
    }


}