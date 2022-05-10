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
 * Procedure column nullable
 *
 * @property value
 */
enum class ProcedureColumnNullable(override val value: Int): IntegerEnum {
    /**
     * No
     *
     * Source value: [DatabaseMetaData.procedureNoNulls]
     */
    NO(DatabaseMetaData.procedureNoNulls),

    /**
     * Yes
     *
     * Source value: [DatabaseMetaData.procedureNullable]
     */
    YES(DatabaseMetaData.procedureNullable),

    /**
     * Unknown
     *
     * Source value: [DatabaseMetaData.procedureNullableUnknown]
     */
    UNKNOWN(DatabaseMetaData.procedureNullableUnknown);
}