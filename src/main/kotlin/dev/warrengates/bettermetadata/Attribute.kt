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
import java.sql.ResultSet

/**
 * Wrapper for results of [getAttributes](https://docs.oracle.com/en/java/javase/17/docs/api/java.sql/java/sql/DatabaseMetaData.html#getAttributes(java.lang.String,java.lang.String,java.lang.String,java.lang.String))
 * method and represents an attribute of a [UserDefinedType].
 *
 * Note that per the documentation SQL_DATA_TYPE and SQL_DATETIME_SUB are unused and have been left out of this class
 *
 * @constructor
 *
 * @param rs a [ResultSet] 
 */
class Attribute(rs: ResultSet) {

    /**
     * Catalog name
     *
     * Source column: TYPE_CAT
     */
    @get:SourceColumn("TYPE_CAT")
    val catalog: String? = rs.getString("TYPE_CAT")

    /**
     * Schema name
     *
     * Source column: TYPE_SCHEM
     */
    @get:SourceColumn("TYPE_SCHEM")
    val schema: String? = rs.getString("TYPE_SCHEM")

    /**
     * Type name
     *
     * Source column: TYPE_NAME
     */
    @get:SourceColumn("TYPE_NAME")
    val typeName: String? = rs.getString("TYPE_NAME")

    /**
     * Attribute name
     *
     * Source column: ATTR_NAME
     */
    @get:SourceColumn("ATTR_NAME")
    val name: String? = rs.getString("ATTR_NAME")

    /**
     * SQL type, converted to [JDBCType]
     *
     * Source column: DATA_TYPE
     */
    @get:SourceColumn("DATA_TYPE")
    val dataType: JDBCType = rs.getJDBCType("DATA_TYPE")

    /**
     * Attribute type name
     *
     * Source column: ATTR_TYPE_NAME
     */
    @get:SourceColumn("ATTR_TYPE_NAME")
    val attributeTypeName: String? = rs.getString("ATTR_TYPE_NAME")

    /**
     * Column size, for char or date types this is the maximum number of characters, for numeric
     * or decimal types this is precision
     *
     * Source column: ATTR_SIZE
     */
    @get:SourceColumn("ATTR_SIZE")
    val attributeSize: Int = rs.getInt("ATTR_SIZE")

    /**
     * The number of fractional digits
     *
     * Source column: DECIMAL_DIGITS
     */
    @get:SourceColumn("DECIMAL_DIGITS")
    val decimalDigits: MetadataInt = rs.getMetadataInt("DECIMAL_DIGITS")

    /**
     * Numeric precision radix (typically either 10 or 2)
     *
     * Source column: NUM_PREC_RADIX
     */
    @get:SourceColumn("NUM_PREC_RADIX")
    val radix: MetadataInt = rs.getMetadataInt("NUM_PREC_RADIX")

    /**
     * Indicates whether attribute is nullable, converted to [AttributeNullable]
     *
     * Source column: NULLABLE
     */
    @get:SourceColumn("NULLABLE")
    val nullable: AttributeNullable = rs.getIntegerEnum("NULLABLE")

    /**
     * Comment describing column
     *
     * Source column: REMARKS
     */
    @get:SourceColumn("REMARKS")
    val remarks: String? = rs.getString("REMARKS")

    /**
     * Attribute default value
     *
     * Source column: ATTR_DEF
     */
    @get:SourceColumn("ATTR_DEF")
    val attributeDefault: String? = rs.getString("ATTR_DEF")

    /**
     * For character types this represents the maximum number of bytes in the column
     *
     * Source column: CHAR_OCTET_LENGTH
     */
    @get:SourceColumn("CHAR_OCTET_LENGTH")
    val characterOctetLength: MetadataInt = rs.getMetadataInt("CHAR_OCTET_LENGTH")

    /**
     * Index of the attribute in the [UserDefinedType] (starts at 1)
     *
     * Source column: ORDINAL_POSITION
     */
    @get:SourceColumn("ORDINAL_POSITION")
    val ordinalPosition: Int = rs.getInt("ORDINAL_POSITION")

    /**
     * Is nullable, converted to [IsNullable]
     *
     * Source column: IS_NULLABLE
     */
    @get:SourceColumn("IS_NULLABLE")
    val isNullable: IsNullable = rs.getStringEnum("IS_NULLABLE")

    /**
     * Catalog of table that is the scope of a reference attribute (null if [dataType] isn't REF)
     *
     * Source column: SCOPE_CATALOG
     */
    @get:SourceColumn("SCOPE_CATALOG")
    val scopeCatalog: String? = rs.getString("SCOPE_CATALOG")

    /**
     * Scope of table that is the scope of a reference attribute (null if [dataType] isn't REF)
     *
     * Source column: SCOPE_SCHEMA
     */
    @get:SourceColumn("SCOPE_SCHEMA")
    val scopeSchema: String? = rs.getString("SCOPE_SCHEMA")

    /**
     * Table name that is the scope of a reference attribute (null if [dataType] isn't REF)
     *
     * Source column: SCOPE_TABLE
     */
    @get:SourceColumn("SCOPE_TABLE")
    val scopeTable: String? = rs.getString("SCOPE_TABLE")

    /**
     * Source data type of a distinct type or user-generated REF type, [JDBCType.NULL] if
     * [dataType] isn't [JDBCType.DISTINCT] or [JDBCType.REF]. Converted to [JDBCType] from short.
     *
     * Source column: SOURCE_DATA_TYPE
     */
    @get:SourceColumn("SOURCE_DATA_TYPE")
    val sourceDataType: JDBCType = rs.getJDBCType("SOURCE_DATA_TYPE")

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Attribute

        if (catalog != other.catalog) return false
        if (schema != other.schema) return false
        if (typeName != other.typeName) return false
        if (name != other.name) return false
        if (ordinalPosition != other.ordinalPosition) return false

        return true
    }

    override fun hashCode(): Int {
        var result = catalog?.hashCode() ?: 0
        result = 31 * result + (schema?.hashCode() ?: 0)
        result = 31 * result + (typeName?.hashCode() ?: 0)
        result = 31 * result + (name?.hashCode() ?: 0)
        result = 31 * result + ordinalPosition
        return result
    }
}