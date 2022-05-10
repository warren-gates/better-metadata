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

import java.sql.ResultSet

/**
 * Result set type
 *
 * @property value
 */
enum class ResultSetType(override val value: Int): IntegerEnum {
    /**
     * Forward Only
     *
     * Source value: [ResultSet.TYPE_FORWARD_ONLY]
     */
    FORWARD_ONLY(ResultSet.TYPE_FORWARD_ONLY),

    /**
     * Scroll Insensitive
     *
     * Source value: [ResultSet.TYPE_SCROLL_INSENSITIVE]
     */
    SCROLL_INSENSITIVE(ResultSet.TYPE_SCROLL_INSENSITIVE),

    /**
     * Scroll Sensitive
     *
     * Source value: [ResultSet.TYPE_SCROLL_SENSITIVE]
     */
    SCROLL_SENSITIVE(ResultSet.TYPE_SCROLL_SENSITIVE);
}