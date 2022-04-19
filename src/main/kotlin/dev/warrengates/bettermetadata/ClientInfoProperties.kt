/*
 * Copyright (c) 2022. Warren Gates
 * All rights reserved.
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
    val name: String = rs.getString("NAME")

    /**
     * Maximum length of the value for the property
     *
     * Source column: MAX_LEN
     */
    val maxLength: Int = rs.getInt("MAX_LEN")

    /**
     * Default value of property
     *
     * Source column: DEFAULT_VALUE
     */
    val defaultValue: String? = rs.getString("DEFAULT_VALUE")

    /**
     * Description of property. Will typically contain information as to
     * where this property is stored in the database
     *
     * Source column: DESCRIPTION
     */
    val description: String? = rs.getString("DESCRIPTION")
}