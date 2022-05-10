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
 * Procedure column type
 *
 * @property value
 */
enum class ProcedureColumnType(override val value: Int): IntegerEnum {
    /**
     * In
     *
     * Source value: [DatabaseMetaData.procedureColumnIn]
     */
    IN(DatabaseMetaData.procedureColumnIn),

    /**
     * In Out
     *
     * Source value: [DatabaseMetaData.procedureColumnInOut]
     */
    IN_OUT(DatabaseMetaData.procedureColumnInOut),

    /**
     * Out
     *
     * Source value: [DatabaseMetaData.procedureColumnOut]
     */
    OUT(DatabaseMetaData.procedureColumnOut),

    /**
     * Return
     *
     * Source value: [DatabaseMetaData.procedureColumnReturn]
     */
    RETURN(DatabaseMetaData.procedureColumnReturn),

    /**
     * Result
     *
     * Source value: [DatabaseMetaData.procedureColumnResult]
     */
    RESULT(DatabaseMetaData.procedureColumnResult),

    /**
     * Unknown
     *
     * Source value: [DatabaseMetaData.procedureColumnUnknown]
     */
    UNKNOWN(DatabaseMetaData.procedureColumnUnknown);
}