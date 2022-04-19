/*
 * Copyright (c) 2022. Warren Gates
 * All rights reserved.
 */

package dev.warrengates.bettermetadata

import java.sql.DatabaseMetaData

/**
 * Indicates whether NULL is allowed
 *
 * @property value
 * @constructor
 */
enum class AttributeNullable(override val value: Int) : IntegerEnum {
    /**
     * Might not allow NULL values
     *
     * Source value: [DatabaseMetaData.attributeNoNulls]
     */
    NO(DatabaseMetaData.attributeNoNulls.toInt()),

    /**
     * Definitely allows NULL values
     *
     * Source value: [DatabaseMetaData.attributeNullable]
     */
    YES(DatabaseMetaData.attributeNullable.toInt()),

    /**
     * Nullability unknown
     *
     * Source value: [DatabaseMetaData.attributeNullableUnknown]
     */
    UNKNOWN(DatabaseMetaData.attributeNullableUnknown.toInt());
}