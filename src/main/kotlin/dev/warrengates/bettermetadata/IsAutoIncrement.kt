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

/**
 * Is auto increment, values taken from returned strings
 *
 * @property value
 */
enum class IsAutoIncrement(override val value: String) : StringEnum {
    /**
     * Yes
     *
     * Source value: "YES"'"
     */
    YES("YES"),

    /**
     * No
     *
     * Source value: "NO"
     */
    NO("NO"),

    /**
     * Unknown
     *
     * Source value: "" (empty string)
     */
    UNKNOWN("");
}