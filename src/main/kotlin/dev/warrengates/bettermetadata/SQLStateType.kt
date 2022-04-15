/*
 * Copyright (c) 2022. Warren Gates
 * All rights reserved.
 */

package dev.warrengates.bettermetadata

import java.sql.DatabaseMetaData

/**
 * S q l state type
 *
 * @property value
 * @constructor Create empty S q l state type
 */
enum class SQLStateType(override val value: Int): IntegerEnum {
    /**
     * Sql
     *
     * @constructor Create empty Sql
     */// definition https://docs.oracle.com/en/java/javase/17/docs/api/java.sql/java/sql/DatabaseMetaData.html
    SQL(DatabaseMetaData.sqlStateSQL),

    /**
     * X open
     *
     * @constructor Create empty X open
     */// TODO: document this, see above link
//    SQL99(DatabaseMetaData.sqlStateSQL99),
    XOpen(DatabaseMetaData.sqlStateXOpen);
}