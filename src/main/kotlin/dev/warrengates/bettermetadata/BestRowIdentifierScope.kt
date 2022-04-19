/*
 * Copyright (c) 2022. Warren Gates
 * All rights reserved.
 */

package dev.warrengates.bettermetadata

import java.sql.DatabaseMetaData

/**
 * Best row identifier scope
 *
 */
enum class BestRowIdentifierScope(override val value: Int): IntegerEnum {
    /**
     * valid for remainder of current session
     *
     * Source value: [DatabaseMetaData.bestRowTemporary]
     */
    SESSION(DatabaseMetaData.bestRowSession),

    /**
     * valid while using row
     *
     * Source value: [DatabaseMetaData.bestRowTransaction]
     */
    TEMPORARY(DatabaseMetaData.bestRowTemporary),

    /**
     * valid for remainder of current transaction
     *
     * Source value: [DatabaseMetaData.bestRowSession]
     */
    TRANSACTION(DatabaseMetaData.bestRowTransaction);
}