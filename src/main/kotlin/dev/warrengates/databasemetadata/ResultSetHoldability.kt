package dev.warrengates.databasemetadata

import java.sql.ResultSet

enum class ResultSetHoldability(override val type: Int):IntegerEnum {
    // definition https://docs.oracle.com/en/java/javase/17/docs/api/java.sql/java/sql/ResultSet.html
    HOLD_CURSORS_OVER_COMMIT(ResultSet.HOLD_CURSORS_OVER_COMMIT),
    CLOSE_CURSORS_AT_COMMIT(ResultSet.CLOSE_CURSORS_AT_COMMIT);
}