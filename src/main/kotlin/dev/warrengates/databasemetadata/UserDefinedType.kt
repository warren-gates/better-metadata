package dev.warrengates.databasemetadata

import java.sql.DatabaseMetaData
import java.sql.JDBCType
import java.sql.ResultSet

/**
 * User defined type
 *
 * @property metaData
 * @constructor
 *
 * @param rs
 */
@Suppress("unused")
class UserDefinedType(private val metaData: DatabaseMetaData, rs: ResultSet) {
    /**
     * Catalog
     */
    val catalog: String? = rs.getString("TYPE_CAT")

    /**
     * Schema
     */
    val schema: String = rs.getString("TYPE_SCHEM")

    /**
     * Name
     */
    val name: String = rs.getString("TYPE_NAME")

    /**
     * Class name
     */
    val className: String? = rs.getString("CLASS_NAME")

    /**
     * SQL type from [java.sql.Types]
     */
    val dataType: JDBCType = rs.getJDBCType("DATA_TYPE")

    /**
     * Remarks
     */
    val remarks: String? = rs.getString("REMARKS")

    /**
     * Base type
     */
    val baseType: Int = rs.getInt("BASE_TYPE")

    /**
     * Get attributes
     *
     * @param attributeNamePattern
     * @return
     */
    fun getAttributes(attributeNamePattern: String?): List<Attribute> {
        return getIterableFromRs(
            metaData.getAttributes(catalog, schema, name, attributeNamePattern)
        ) { x -> Attribute(x) }
    }
}