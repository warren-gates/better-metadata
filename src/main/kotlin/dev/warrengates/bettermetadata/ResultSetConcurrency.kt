/*
 * Copyright (c) 2022. Warren Gates
 * All rights reserved.
 */

package dev.warrengates.bettermetadata

import java.sql.ResultSet

/**
 * Result set concurrency
 *
 * @property type
 * @constructor Create empty Result set concurrency
 */
enum class ResultSetConcurrency(override val type: Int): IntegerEnum {
    /**
     * Read Only
     *
     * @constructor Create empty Read Only
     */
    READ_ONLY(ResultSet.CONCUR_READ_ONLY),

    /**
     * Updatable
     *
     * @constructor Create empty Updatable
     */
    UPDATABLE(ResultSet.CONCUR_UPDATABLE);
}