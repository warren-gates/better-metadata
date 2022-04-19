/*
 * Copyright (c) 2022. Warren Gates
 * All rights reserved.
 */

package dev.warrengates.bettermetadata

import java.sql.JDBCType
import java.sql.ResultSet

/**
 * Wrapper for results of
 * [getProcedureColumns](https://docs.oracle.com/en/java/javase/17/docs/api/java.sql/java/sql/DatabaseMetaData.html#getProcedureColumns(java.lang.String,java.lang.String,java.lang.String,java.lang.String))
 *
 * Note that per the documentation SQL_DATA_TYPE and SQL_DATETIME_SUB are reserved for future use and have been left out of this class
 *
 * @constructor
 *
 * @param rs
 */
class ProcedureColumn(rs: ResultSet) {
    /**
     * Catalog
     *
     * Source column: PROCEDURE_CAT
     */
    val catalog: String? = rs.getString("PROCEDURE_CAT")

    /**
     * Schema
     *
     * Source column: PROCEDURE_SCHEM
     */
    val schema: String? = rs.getString("PROCEDURE_SCHEM")

    /**
     * Procedure name
     *
     * Source column: PROCEDURE_NAME
     */
    val procedureName: String? = rs.getString("PROCEDURE_NAME")

    /**
     * Name
     *
     * Source column: COLUMN_NAME
     */
    val name: String = rs.getString("COLUMN_NAME")

    /**
     * Column type, converted to [ProcedureColumnType]
     *
     * Source column: COLUMN_TYPE
     */
    val columnType: ProcedureColumnType = rs.getIntegerEnum("COLUMN_TYPE")

    /**
     * SQL type, converted to [JDBCType]
     *
     * Source column: DATA_TYPE
     */
    val dataType: JDBCType = rs.getJDBCType("DATA_TYPE")

    /**
     * Type name
     *
     * Source column: TYPE_NAME
     */
    val typeName: String? = rs.getString("TYPE_NAME")

    /**
     * Precision
     *
     * Source column: PRECISION
     */
    val precision: Int = rs.getInt("PRECISION")

    /**
     * Length
     *
     * Source column: LENGTH
     */
    val length: Int = rs.getInt("LENGTH")

    /**
     * Scale
     *
     * Source column: SCALE
     */
    val scale: MetadataInt = rs.getMetadataInt("SCALE")

    /**
     * Radix, converted to Int for consistency
     *
     * Source column: RADIX
     */
    val radix: Int = rs.getShort("RADIX").toInt()

    /**
     * Nullable, converted to [ProcedureColumnNullable]
     *
     * Source column: NULLABLE
     */
    val nullable: ProcedureColumnNullable = rs.getIntegerEnum("NULLABLE")

    /**
     * Remarks
     *
     * Source column: REMARKS
     */
    val remarks: String? = rs.getString("REMARKS")

    /**
     * Column default
     *
     * Source column: COLUMN_DEF
     */
    val columnDefault: String? = rs.getString("COLUMN_DEF")

    // following reserved for future use per https://docs.oracle.com/en/java/javase/17/docs/api/java.sql/java/sql/DatabaseMetaData.html#getProcedureColumns(java.lang.String,java.lang.String,java.lang.String,java.lang.String)
//    val sqlDataType: Int = rs.getInt("SQL_DATA_TYPE")
//    val sqlDatetimeSub: Int = rs.getInt("SQL_DATETIME_SUB")

    /**
     * Character octet length
     *
     * Source column: CHAR_OCTET_LENGTH
     */
    val characterOctetLength: Int = rs.getInt("CHAR_OCTET_LENGTH")

    /**
     * Ordinal position
     *
     * Source column: ORDINAL_POSITION
     */
    val ordinalPosition: Int = rs.getInt("ORDINAL_POSITION")

    /**
     * Is nullable, converted to [IsNullable]
     *
     * Source column: IS_NULLABLE
     */
    val isNullable: IsNullable = rs.getStringEnum("IS_NULLABLE")

    /**
     * Specific name
     *
     * Source column: SPECIFIC_NAME
     */
    val specificName: String? = rs.getString("SPECIFIC_NAME")
}