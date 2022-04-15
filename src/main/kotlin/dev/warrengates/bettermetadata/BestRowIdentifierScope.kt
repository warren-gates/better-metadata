/*
 * Copyright (c) 2022. Warren Gates
 * All rights reserved.
 */

package dev.warrengates.bettermetadata

import java.sql.DatabaseMetaData

/**
 * Best row identifier scope
 *
 * [type] values taken from [java.sql.DatabaseMetaData.bestRowTemporary],
 * [java.sql.DatabaseMetaData.bestRowTransaction], and
 * [java.sql.DatabaseMetaData.bestRowSession]
 */
enum class BestRowIdentifierScope(override val type: Int): IntegerEnum {
    /**
     * valid for remainder of current session
     */
    SESSION(DatabaseMetaData.bestRowSession),

    /**
     * valid while using row
     */
    TEMPORARY(DatabaseMetaData.bestRowTemporary),

    /**
     * valid for remainder of current transaction
     */
    TRANSACTION(DatabaseMetaData.bestRowTransaction);
}