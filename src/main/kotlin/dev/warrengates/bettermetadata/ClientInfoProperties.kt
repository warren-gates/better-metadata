/*
 * Copyright (c) 2022. Warren Gates
 * All rights reserved.
 */

package dev.warrengates.bettermetadata

import java.sql.ResultSet

/**
 * Client info properties
 *
 * @constructor
 *
 * @param rs
 */
class ClientInfoProperties(rs: ResultSet) {
    /**
     * Name of client info property
     */
    val name: String = rs.getString("NAME")

    /**
     * Maximum length of the value for the property
     */
    val maxLength: Int = rs.getInt("MAX_LEN")

    /**
     * Default value of property
     */
    val defaultValue: String? = rs.getString("DEFAULT_VALUE")

    /**
     * Description of property. Will typically contain information as to
     * where this property is stored in the database
     */
    val description: String? = rs.getString("DESCRIPTION")
}