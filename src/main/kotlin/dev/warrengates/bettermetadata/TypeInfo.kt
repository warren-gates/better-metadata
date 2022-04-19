/*
 * Copyright (c) 2022. Warren Gates
 * All rights reserved.
 */

package dev.warrengates.bettermetadata

import java.sql.JDBCType
import java.sql.ResultSet

/**
 * Wrapper for results of [getTypeInfo](https://docs.oracle.com/en/java/javase/17/docs/api/java.sql/java/sql/DatabaseMetaData.html#getTypeInfo())
 *
 * Note that per the documentation SQL_DATA_TYPE, and SQL_DATETIME_SUB are unused and have
 * been left out of this class
 */
class TypeInfo(rs: ResultSet) {
    /**
     * Name
     *
     * Source column: TYPE_NAME
     */
    val name: String = rs.getString("TYPE_NAME")

    /**
     * SQL type, converted to [JDBCType]
     *
     * Source column: DATA_TYPE
     */
    val dataType: JDBCType = rs.getJDBCType("DATA_TYPE")

    /**
     * Precision
     *
     * Source column: PRECISION
     */
    val precision: Int = rs.getInt("PRECISION")

    /**
     * Literal prefix
     *
     * Source column: LITERAL_PREFIX
     */
    val literalPrefix: String? = rs.getString("LITERAL_PREFIX")

    /**
     * Literal suffix
     *
     * Source column: LITERAL_SUFFIX
     */
    val literalSuffix: String? = rs.getString("LITERAL_SUFFIX")

    /**
     * Create params
     *
     * Source column: CREATE_PARAMS
     */
    val createParams: String? = rs.getString("CREATE_PARAMS")

    /**
     * Nullable, converted to [TypeNullable]
     *
     * Source column: NULLABLE
     */
    val nullable: TypeNullable = rs.getIntegerEnum("NULLABLE")

    /**
     * Case sensitive
     *
     * Source column: CASE_SENSITIVE
     */
    val caseSensitive: Boolean = rs.getBoolean("CASE_SENSITIVE")

    /**
     * Searchable, converted to [TypeSearchable]
     *
     * Source column: SEARCHABLE
     */
    val searchable: TypeSearchable = rs.getIntegerEnum("SEARCHABLE")

    /**
     * Is unsigned
     *
     * Source column: UNSIGNED_ATTRIBUTE
     */
    val isUnsigned: Boolean = rs.getBoolean("UNSIGNED_ATTRIBUTE")

    /**
     * Fixed precision scale
     *
     * Source column: FIXED_PREC_SCALE
     */
    val fixedPrecisionScale: Boolean = rs.getBoolean("FIXED_PREC_SCALE")

    /**
     * Auto increment
     *
     * Source column: AUTO_INCREMENT
     */
    val autoIncrement: Boolean = rs.getBoolean("AUTO_INCREMENT")

    /**
     * Local type name
     *
     * Source column: LOCAL_TYPE_NAME
     */
    val localTypeName: String? = rs.getString("LOCAL_TYPE_NAME")

    /**
     * Minimum scale
     *
     * Source column: MINIMUM_SCALE
     */
    val minimumScale: Int = rs.getInt("MINIMUM_SCALE")

    /**
     * Maximum scale
     *
     * Source column: MAXIMUM_SCALE
     */
    val maximumScale: Int = rs.getInt("MAXIMUM_SCALE")

    // unused per https://docs.oracle.com/en/java/javase/17/docs/api/java.sql/java/sql/DatabaseMetaData.html#getTypeInfo()
//    val sqlDataType: Int = rs.getInt("SQL_DATA_TYPE")
//    val sqlDatetimeSub: Int = rs.getInt("SQL_DATETIME_SUB")

    /**
     * Numeric precision radix
     *
     * Source column: NUM_PREC_RADIX
     */
    val radix: Int = rs.getInt("NUM_PREC_RADIX")
}