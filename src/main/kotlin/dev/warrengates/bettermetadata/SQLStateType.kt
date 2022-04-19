/*
 * Copyright (c) 2022. Warren Gates
 * All rights reserved.
 */

package dev.warrengates.bettermetadata

import java.sql.DatabaseMetaData

/**
 * SQL state type
 *
 * @property value
 */
enum class SQLStateType(override val value: Int): IntegerEnum {
    /**
     * Sql
     *
     * Source value: [DatabaseMetaData.sqlStateSQL]
     */
    SQL(DatabaseMetaData.sqlStateSQL),


    /**
     * Sql99, per documentation, this is for compatibility reasons, developer should use
     * [XOpen] instead
     *
     * Source value: [DatabaseMetaData.sqlStateSQL99]
     */
    SQL99(DatabaseMetaData.sqlStateSQL99),

    /**
     * X open
     *
     * Source value: [DatabaseMetaData.sqlStateXOpen]
     */
    XOpen(DatabaseMetaData.sqlStateXOpen);
}