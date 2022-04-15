package dev.warrengates.databasemetadata

import java.sql.DatabaseMetaData

/**
 * Indicates whether NULL is allowed
 *
 * [type] values taken from [java.sql.DatabaseMetaData.attributeNoNulls],
 * [java.sql.DatabaseMetaData.attributeNullable], and
 * [java.sql.DatabaseMetaData.attributeNullableUnknown]
 *
 * @property type
 * @constructor
 */
enum class AttributeNullable(override val type: Int) : IntegerEnum {
    /**
     * Might not allow NULL values
     */
    NO(DatabaseMetaData.attributeNoNulls.toInt()),

    /**
     * Definitely allows NULL values
     */
    YES(DatabaseMetaData.attributeNullable.toInt()),

    /**
     * Nullability unknown
     */
    UNKNOWN(DatabaseMetaData.attributeNullableUnknown.toInt());
}