/*
 * Copyright (c) 2022. Warren Gates
 * All rights reserved.
 */

package dev.warrengates.bettermetadata

import java.sql.DatabaseMetaData
import java.sql.JDBCType
import java.sql.ResultSet

/**
 * Wrapper for results of [getUDTs](https://docs.oracle.com/en/java/javase/17/docs/api/java.sql/java/sql/DatabaseMetaData.html#getUDTs(java.lang.String,java.lang.String,java.lang.String,int%5B%5D))
 *
 */
@Suppress("unused")
class UserDefinedType(private val metaData: DatabaseMetaData, rs: ResultSet) {
    /**
     * Catalog
     *
     * Source column: TYPE_CAT
     */
    val catalog: String? = rs.getString("TYPE_CAT")

    /**
     * Schema
     *
     * Source column: TYPE_SCHEM
     */
    val schema: String = rs.getString("TYPE_SCHEM")

    /**
     * Name
     *
     * Source column: TYPE_NAME
     */
    val name: String = rs.getString("TYPE_NAME")

    /**
     * Class name
     *
     * Source column: CLASS_NAME
     */
    val className: String? = rs.getString("CLASS_NAME")

    /**
     * SQL type, converted to [JDBCType]
     *
     * Source column: DATA_TYPE
     */
    val dataType: JDBCType = rs.getJDBCType("DATA_TYPE")

    /**
     * Remarks
     *
     * Source column: REMARKS
     */
    val remarks: String? = rs.getString("REMARKS")

    /**
     * Base type
     *
     * Source column: BASE_TYPE
     */
    val baseType: Int = rs.getInt("BASE_TYPE")

    /**
     * Get attributes
     *
     * Source: wrapped results of [getAttributes](https://docs.oracle.com/en/java/javase/17/docs/api/java.sql/java/sql/DatabaseMetaData.html#getAttributes(java.lang.String,java.lang.String,java.lang.String,java.lang.String))
     * filtered to this types's catalog, schema, and name
     */
    @JvmOverloads
    fun getAttributes(attributeNamePattern: String? = null): List<Attribute> {
        return getIterableFromRs(
            metaData.getAttributes(catalog, schema, name, attributeNamePattern)
        ) { x -> Attribute(x) }
    }
}