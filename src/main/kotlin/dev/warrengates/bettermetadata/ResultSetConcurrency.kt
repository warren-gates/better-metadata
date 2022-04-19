/*
 * Copyright (c) 2022. Warren Gates
 * All rights reserved.
 */

package dev.warrengates.bettermetadata

import java.sql.ResultSet

/**
 * Result set concurrency
 *
 * @property value
 */
enum class ResultSetConcurrency(override val value: Int): IntegerEnum {
    /**
     * Read Only
     *
     * Source value: [ResultSet.CONCUR_READ_ONLY]
     */
    READ_ONLY(ResultSet.CONCUR_READ_ONLY),

    /**
     * Updatable
     *
     * Source value: [ResultSet.CONCUR_UPDATABLE]
     */
    UPDATABLE(ResultSet.CONCUR_UPDATABLE);
}