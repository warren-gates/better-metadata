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
 * SQL state type
 *
 * @property value
 */
enum class SQLStateType(override val value: Int): IntegerEnum {
    /**
     * Sql
     *
     * Source value: [DatabaseMetaData.sqlStateSQL]
     */
    SQL(DatabaseMetaData.sqlStateSQL),


    /**
     * Sql99, per documentation, this is for compatibility reasons, developer should use
     * [XOpen] instead
     *
     * Source value: [DatabaseMetaData.sqlStateSQL99]
     */
    SQL99(DatabaseMetaData.sqlStateSQL99),

    /**
     * X open
     *
     * Source value: [DatabaseMetaData.sqlStateXOpen]
     */
    XOpen(DatabaseMetaData.sqlStateXOpen);
}