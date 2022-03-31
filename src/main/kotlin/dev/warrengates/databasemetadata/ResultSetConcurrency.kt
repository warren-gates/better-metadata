package dev.warrengates.databasemetadata

import java.sql.ResultSet

enum class ResultSetConcurrency(override val type: Int): IntegerEnum {
    READ_ONLY(ResultSet.CONCUR_READ_ONLY),
    UPDATABLE(ResultSet.CONCUR_UPDATABLE);
}