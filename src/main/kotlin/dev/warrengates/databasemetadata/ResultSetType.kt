package dev.warrengates.databasemetadata

import java.sql.ResultSet

enum class ResultSetType(override val type: Int): IntegerEnum {
    FORWARD_ONLY(ResultSet.TYPE_FORWARD_ONLY),
    SCROLL_INSENSITIVE(ResultSet.TYPE_SCROLL_INSENSITIVE),
    SCROLL_SENSITIVE(ResultSet.TYPE_SCROLL_SENSITIVE);
}