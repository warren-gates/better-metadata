/*
 * Copyright (c) 2022. Warren Gates
 * All rights reserved.
 */

package dev.warrengates.bettermetadata

/**
 * Wrapper for results of [getPrimaryKeys](https://docs.oracle.com/en/java/javase/17/docs/api/java.sql/java/sql/DatabaseMetaData.html#getPrimaryKeys(java.lang.String,java.lang.String,java.lang.String)).
 * It has been refactored to provide of [Column] object rather than the flattened view provided by the getPrimaryKeys method.
 *
 *
 * @property name
 * @property primaryKeyColumns
 * @constructor Create empty Primary key
 */
class PrimaryKey(
    /**
     * Key name
     *
     * Source column: PK_NAME
     */
    val name: String?,

    /**
     * List of [PrimaryKeyColumn] objects. Each contains a [Column] and an sequenceNumber value.
     * The [Column] is selected by filtering for the appropriate TABLE_CAT, TABLE_SCHEM, TABLE_NAME, and
     * COLUMN_NAME as returned by [java.sql.DatabaseMetaData.getPrimaryKeys], and the sequenceNumber value
     * is from KEY_SEQ
     */
    val primaryKeyColumns: List<PrimaryKeyColumn>
)