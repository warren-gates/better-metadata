package dev.warrengates.databasemetadata

import java.sql.JDBCType
import java.sql.ResultSet

/**
 * Attribute represents an attribute of a [UserDefinedType]. It does not contain inherited attributes.
 *
 * @constructor
 *
 * @param rs a [ResultSet] 
 */
class Attribute(rs: ResultSet) {

    /**
     * Catalog name
     */
    val catalog: String? = rs.getString("TYPE_CAT")

    /**
     * Schema name
     */
    val schema: String? = rs.getString("TYPE_SCHEM")

    /**
     * Type name
     */
    val typeName: String? = rs.getString("TYPE_NAME")

    /**
     * Attribute name
     */
    val name: String? = rs.getString("ATTR_NAME")

    /**
     * SQL type from [java.sql.Types]
     */
    val dataType: JDBCType = rs.getJDBCType("DATA_TYPE")

    /**
     * Attribute type name
     *
     * Data source dependent type name. For a [UserDefinedType] the name is fully qualified.
     * For a REF, the type name is fully qualified and represents the target type of the
     * reference type.
     */
    val attributeTypeName: String? = rs.getString("ATTR_TYPE_NAME")

    /**
     * Column size. For char or date types this is the maximum number of characters, for numeric
     * or decimal types this is precision
     *
     */
    val attributeSize: Int = rs.getInt("ATTR_SIZE")

    /**
     * The number of fractional digits, null is returned when decimalDigits is not applicable
     */
    val decimalDigits: MetadataInt = rs.getMetadataInt("DECIMAL_DIGITS")

    /**
     * Numeric precision radix (typically either 10 or 2)
     */
    val numericPrecisionRadix: Int = rs.getInt("NUM_PREC_RADIX")

    /**
     * Indicates whether attribute is nullable
     */
    val nullable: AttributeNullable = rs.getEnum("NULLABLE")

    /**
     * Comment describing column
     */
    val remarks: String? = rs.getString("REMARKS")

    /**
     * Attribute default value
     */
    val attributeDefault: String? = rs.getString("ATTR_DEF")

    // unused
//    val sqlDataType: Int? = rs.getInt("SQL_DATA_TYPE")
//    val sqlDatetimeSub: Int? = rs.getInt("SQL_DATETIME_SUB")

    /**
     * For character types this represents the maximum number of bytes in the column
     */
    val characterOctetLength: Int = rs.getInt("CHAR_OCTET_LENGTH")

    /**
     * Index of the attribute in the [UserDefinedType] (starts at 1)
     */
    val ordinalPosition: Int = rs.getInt("ORDINAL_POSITION")

    /**
     * Is nullable value as string
     *
     * YES if the attribute can include NULLs
     * NO if the attribute cannot include NULLs
     * empty string if nullability is unknown
     */
    val isNullable: String? = rs.getString("IS_NULLABLE")

    /**
     * Catalog of table that is the scope of a reference attribute (null if [dataType] isn't REF
     */
    val scopeCatalog: String? = rs.getString("SCOPE_CATALOG")

    /**
     * Scope of table that is the scope of a reference attribute (null if [dataType] isn't REF
     */
    val scopeSchema: String? = rs.getString("SCOPE_SCHEMA")

    /**
     * Table name that is the scope of a reference attribute (null if [dataType] isn't REF
     */
    val scopeTable: String? = rs.getString("SCOPE_TABLE")

    // TODO: test that this is correct mapping
    /**
     * Source data type of a distinct type or user-generated REF type, [JDBCType.NULL] if
     * [dataType] isn't [JDBCType.DISTINCT] or [JDBCType.REF]
     */
    val sourceDataType: JDBCType = rs.getJDBCType("SOURCE_DATA_TYPE")

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Attribute

        if (catalog != other.catalog) return false
        if (schema != other.schema) return false
        if (typeName != other.typeName) return false
        if (name != other.name) return false

        return true
    }

    override fun hashCode(): Int {
        var result = catalog?.hashCode() ?: 0
        result = 31 * result + (schema?.hashCode() ?: 0)
        result = 31 * result + (typeName?.hashCode() ?: 0)
        result = 31 * result + (name?.hashCode() ?: 0)
        return result
    }
}