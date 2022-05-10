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