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
 * Function column type
 *
 * @property value
 */
enum class FunctionColumnType(override val value: Int): IntegerEnum {
    /**
     * In
     *
     * Source value: [DatabaseMetaData.functionColumnIn]
     */
    IN(DatabaseMetaData.functionColumnIn),

    /**
     * In Out
     *
     * Source value: [DatabaseMetaData.functionColumnInOut]
     */
    IN_OUT(DatabaseMetaData.functionColumnInOut),

    /**
     * Out
     *
     * Source value: [DatabaseMetaData.functionColumnOut]
     */
    OUT(DatabaseMetaData.functionColumnOut),

    /**
     * Result
     *
     * Source value: [DatabaseMetaData.functionColumnResult]
     */
    RESULT(DatabaseMetaData.functionColumnResult),

    /**
     * Return
     *
     * Source value: [DatabaseMetaData.functionReturn]
     */
    RETURN(DatabaseMetaData.functionReturn),

    /**
     * Unknown
     *
     * Source value: [DatabaseMetaData.functionColumnUnknown]
     */
    UNKNOWN(DatabaseMetaData.functionColumnUnknown);
}