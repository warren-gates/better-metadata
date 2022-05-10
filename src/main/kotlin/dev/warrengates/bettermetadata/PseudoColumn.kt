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

import java.sql.JDBCType
import java.sql.PseudoColumnUsage
import java.sql.ResultSet

/**
 * Wrapper for results of [getPseudoColumns](https://docs.oracle.com/en/java/javase/17/docs/api/java.sql/java/sql/DatabaseMetaData.html#getPseudoColumns(java.lang.String,java.lang.String,java.lang.String,java.lang.String))
 *
 */
class PseudoColumn(rs: ResultSet) {
    /**
     * Catalog
     */
    @get:SourceColumn("TABLE_CAT")
    val catalog: String? = rs.getString("TABLE_CAT")

    /**
     * Schema
     */
    @get:SourceColumn("TABLE_SCHEM")
    val schema: String? = rs.getString("TABLE_SCHEM")

    /**
     * Table name
     */
    @get:SourceColumn("TABLE_NAME")
    val tableName: String? = rs.getString("TABLE_NAME")

    /**
     * Name
     */
    @get:SourceColumn("COLUMN_NAME")
    val name: String? = rs.getString("COLUMN_NAME")

    /**
     * SQL type, converted to [JDBCType]
     */
    @get:SourceColumn("DATA_TYPE")
    val dataType: JDBCType = rs.getJDBCType("DATA_TYPE")

    /**
     * Column size
     */
    @get:SourceColumn("COLUMN_SIZE")
    val columnSize: MetadataInt = rs.getMetadataInt("COLUMN_SIZE")

    /**
     * The number of fractional digits
     */
    @get:SourceColumn("DECIMAL_DIGITS")
    val decimalDigits: MetadataInt = rs.getMetadataInt("DECIMAL_DIGITS")

    /**
     * Numeric precision radix
     */
    @get:SourceColumn("NUM_PREC_RADIX")
    val radix: MetadataInt = rs.getMetadataInt("NUM_PREC_RADIX")

    /**
     * Column usage, converted to [PseudoColumnUsage]
     */
    @get:SourceColumn("COLUMN_USAGE")
    val columnUsage: PseudoColumnUsage = PseudoColumnUsage.valueOf(rs.getString("COLUMN_USAGE"))

    /**
     * Remarks
     */
    @get:SourceColumn("REMARKS")
    val remarks: String? = rs.getString("REMARKS")

    /**
     * Character octet length
     */
    @get:SourceColumn("CHAR_OCTET_LENGTH")
    val characterOctetLength: MetadataInt = rs.getMetadataInt("CHAR_OCTET_LENGTH")

    /**
     * Is nullable, converted to [IsNullable]
     */
    @get:SourceColumn("IS_NULLABLE")
    val isNullable: IsNullable = rs.getStringEnum("IS_NULLABLE")
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as PseudoColumn

        if (catalog != other.catalog) return false
        if (schema != other.schema) return false
        if (tableName != other.tableName) return false
        if (name != other.name) return false

        return true
    }

    override fun hashCode(): Int {
        var result = catalog?.hashCode() ?: 0
        result = 31 * result + (schema?.hashCode() ?: 0)
        result = 31 * result + (tableName?.hashCode() ?: 0)
        result = 31 * result + (name?.hashCode() ?: 0)
        return result
    }


}