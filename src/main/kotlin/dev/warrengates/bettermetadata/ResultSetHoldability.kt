/*
 * Copyright (c) 2022. Warren Gates
 * All rights reserved.
 */

package dev.warrengates.bettermetadata

import java.sql.ResultSet

/**
 * Result set holdability
 *
 * @property value
 */
enum class ResultSetHoldability(override val value: Int):IntegerEnum {
    /**
     * Hold Cursors Over Commit
     *
     * Source value: [ResultSet.HOLD_CURSORS_OVER_COMMIT]
     */
    HOLD_CURSORS_OVER_COMMIT(ResultSet.HOLD_CURSORS_OVER_COMMIT),

    /**
     * Close Cursors At Commit
     *
     * Source value: [ResultSet.CLOSE_CURSORS_AT_COMMIT]
     */
    CLOSE_CURSORS_AT_COMMIT(ResultSet.CLOSE_CURSORS_AT_COMMIT);
}