/*
 * Copyright (c) 2022. Warren Gates
 * All rights reserved.
 */

package dev.warrengates.bettermetadata

import java.sql.JDBCType
import java.sql.ResultSet

/**
 * Procedure column
 *
 * @constructor
 *
 * @param rs
 */
class ProcedureColumn(rs: ResultSet) {
    /**
     * Catalog
     */
    val catalog: String? = rs.getString("PROCEDURE_CAT")

    /**
     * Schema
     */
    val schema: String? = rs.getString("PROCEDURE_SCHEM")

    /**
     * Procedure name
     */
    val procedureName: String? = rs.getString("PROCEDURE_NAME")

    /**
     * Name
     */
    val name: String = rs.getString("COLUMN_NAME")

    /**
     * Column type
     */
    val columnType: ProcedureColumnType = rs.getIntegerEnum("COLUMN_TYPE")

    /**
     * SQL type from [java.sql.Types]
     */
    val dataType: JDBCType = rs.getJDBCType("DATA_TYPE")

    /**
     * Type name
     */
    val typeName: String? = rs.getString("TYPE_NAME")

    /**
     * Precision
     */
    val precision: Int = rs.getInt("PRECISION")

    /**
     * Length
     */
    val length: Int = rs.getInt("LENGTH")

    /**
     * Scale
     */
    val scale: MetadataInt = rs.getMetadataInt("SCALE")

    /**
     * Radix
     */
    val radix: Short = rs.getShort("RADIX")

    /**
     * Nullable
     */
    val nullable: ProcedureColumnNullable = rs.getIntegerEnum("NULLABLE")

    /**
     * Remarks
     */
    val remarks: String? = rs.getString("REMARKS")

    /**
     * Column default
     */
    val columnDefault: String? = rs.getString("COLUMN_DEF")

    // following reserved for future use per https://docs.oracle.com/en/java/javase/17/docs/api/java.sql/java/sql/DatabaseMetaData.html#getProcedureColumns(java.lang.String,java.lang.String,java.lang.String,java.lang.String)
//    val sqlDataType: Int = rs.getInt("SQL_DATA_TYPE")
//    val sqlDatetimeSub: Int = rs.getInt("SQL_DATETIME_SUB")

    /**
     * Character octet length
     */
    val characterOctetLength: Int = rs.getInt("CHAR_OCTET_LENGTH")

    /**
     * Ordinal position
     */
    val ordinalPosition: Int = rs.getInt("ORDINAL_POSITION")

    /**
     * Is nullable
     */
    val isNullable: IsNullable = rs.getStringEnum("IS_NULLABLE")

    /**
     * Specific name
     */
    val specificName: String? = rs.getString("SPECIFIC_NAME")
}