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
 * Indicates whether best row column is a pseudo column like an Oracle ROWID
 *
 * @property value
 * @constructor Create empty Best row column type
 */
enum class BestRowColumnType(override val value: Int): IntegerEnum {
    /**
     * Indicates best row identifier is a pseudo column
     *
     * Source value: [DatabaseMetaData.bestRowPseudo]
     */
    IS_PSEUDO_COLUMN(DatabaseMetaData.bestRowPseudo),

    /**
     * Indicates best row identifier is NOT a pseudo column
     *
     * Source value: [DatabaseMetaData.bestRowNotPseudo]
     */
    NOT_PSEUDO_COLUMN(DatabaseMetaData.bestRowNotPseudo),

    /**
     * Indicates best row identifier may or may not be a pseudo column
     *
     * Source value: [DatabaseMetaData.bestRowUnknown]
     */
    UNKNOWN(DatabaseMetaData.bestRowUnknown);
}