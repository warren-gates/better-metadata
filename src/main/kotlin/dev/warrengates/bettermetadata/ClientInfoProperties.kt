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
 * Wrapper for results of [getClientInfoProperties](https://docs.oracle.com/en/java/javase/17/docs/api/java.sql/java/sql/DatabaseMetaData.html#getClientInfoProperties())
 * method and represents a list of the client info properties supported by the current driver
 *
 * @constructor
 *
 * @param rs
 */
class ClientInfoProperties(rs: ResultSet) {
    /**
     * Name of client info property
     *
     * Source column: NAME
     */
    @get:SourceColumn("NAME")
    val name: String = rs.getString("NAME")

    /**
     * Maximum length of the value for the property
     *
     * Source column: MAX_LEN
     */
    @get:SourceColumn("MAX_LEN")
    val maxLength: Int = rs.getInt("MAX_LEN")

    /**
     * Default value of property
     *
     * Source column: DEFAULT_VALUE
     */
    @get:SourceColumn("DEFAULT_VALUE")
    val defaultValue: String? = rs.getString("DEFAULT_VALUE")

    /**
     * Description of property. Will typically contain information as to
     * where this property is stored in the database
     *
     * Source column: DESCRIPTION
     */
    @get:SourceColumn("DESCRIPTION")
    val description: String? = rs.getString("DESCRIPTION")

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ClientInfoProperties

        if (name != other.name) return false

        return true
    }

    override fun hashCode(): Int {
        return name.hashCode()
    }
}