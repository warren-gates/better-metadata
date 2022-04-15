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
 * @constructor Create empty Result set holdability
 */
enum class ResultSetHoldability(override val value: Int):IntegerEnum {
    /**
     * Hold Cursors Over Commit
     *
     * @constructor Create empty Hold Cursors Over Commit
     */// definition https://docs.oracle.com/en/java/javase/17/docs/api/java.sql/java/sql/ResultSet.html
    HOLD_CURSORS_OVER_COMMIT(ResultSet.HOLD_CURSORS_OVER_COMMIT),

    /**
     * Close Cursors At Commit
     *
     * @constructor Create empty Close Cursors At Commit
     */
    CLOSE_CURSORS_AT_COMMIT(ResultSet.CLOSE_CURSORS_AT_COMMIT);
}