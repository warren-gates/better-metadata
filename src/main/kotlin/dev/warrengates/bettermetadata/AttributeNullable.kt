/*
 * Copyright (c) 2022. Warren Gates
 * All rights reserved.
 */

package dev.warrengates.bettermetadata

import java.sql.DatabaseMetaData

/**
 * Indicates whether NULL is allowed
 *
 * [value] values taken from [java.sql.DatabaseMetaData.attributeNoNulls],
 * [java.sql.DatabaseMetaData.attributeNullable], and
 * [java.sql.DatabaseMetaData.attributeNullableUnknown]
 *
 * @property value
 * @constructor
 */
enum class AttributeNullable(override val value: Int) : IntegerEnum {
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