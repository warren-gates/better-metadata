package dev.warrengates.databasemetadata

import java.sql.Connection

enum class TransactionIsolation(override val type: Int): IntegerEnum {
    // defined in https://docs.oracle.com/en/java/javase/17/docs/api/java.sql/java/sql/Connection.html
    NONE(Connection.TRANSACTION_NONE),
    READ_COMMITTED(Connection.TRANSACTION_READ_COMMITTED),
    READ_UNCOMMITTED(Connection.TRANSACTION_READ_UNCOMMITTED),
    REPEATABLE_READ(Connection.TRANSACTION_REPEATABLE_READ),
    SERIALIZABLE(Connection.TRANSACTION_SERIALIZABLE);
}