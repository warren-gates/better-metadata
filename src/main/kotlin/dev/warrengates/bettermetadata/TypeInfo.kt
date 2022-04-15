package dev.warrengates.bettermetadata

import java.sql.JDBCType
import java.sql.ResultSet

/**
 * Type info
 *
 * @constructor
 *
 * @param rs
 */
class TypeInfo(rs: ResultSet) {
    /**
     * Name
     */
    val name: String = rs.getString("TYPE_NAME")

    /**
     * SQL type from [java.sql.Types]
     */
    val dataType: JDBCType = rs.getJDBCType("DATA_TYPE")

    /**
     * Precision
     */
    val precision: Int = rs.getInt("PRECISION")

    /**
     * Literal prefix
     */
    val literalPrefix: String? = rs.getString("LITERAL_PREFIX")

    /**
     * Literal suffix
     */
    val literalSuffix: String? = rs.getString("LITERAL_SUFFIX")

    /**
     * Create params
     */
    val createParams: String? = rs.getString("CREATE_PARAMS")

    /**
     * Nullable
     */
    val nullable: TypeNullable = rs.getEnum("NULLABLE")

    /**
     * Case sensitive
     */
    val caseSensitive: Boolean = rs.getBoolean("CASE_SENSITIVE")

    /**
     * Searchable
     */
    val searchable: TypeSearchable = rs.getEnum("SEARCHABLE")

    /**
     * Is unsigned
     */
    val isUnsigned: Boolean = rs.getBoolean("UNSIGNED_ATTRIBUTE")

    /**
     * Fixed precision scale
     */
    val fixedPrecisionScale: Boolean = rs.getBoolean("FIXED_PREC_SCALE")

    /**
     * Auto increment
     */
    val autoIncrement: Boolean = rs.getBoolean("AUTO_INCREMENT")

    /**
     * Local type name
     */
    val localTypeName: String? = rs.getString("LOCAL_TYPE_NAME")

    /**
     * Minimum scale
     */
    val minimumScale: Short = rs.getShort("MINIMUM_SCALE")

    /**
     * Maximum scale
     */
    val maximumScale: Short = rs.getShort("MAXIMUM_SCALE")

    // unused per https://docs.oracle.com/en/java/javase/17/docs/api/java.sql/java/sql/DatabaseMetaData.html#getTypeInfo()
//    val sqlDataType: Int = rs.getInt("SQL_DATA_TYPE")
//    val sqlDatetimeSub: Int = rs.getInt("SQL_DATETIME_SUB")

    /**
     * Numeric precision radix
     */
    val numericPrecisionRadix: Int = rs.getInt("NUM_PREC_RADIX")
}