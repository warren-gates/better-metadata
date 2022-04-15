/*
 * Copyright (c) 2022. Warren Gates
 * All rights reserved.
 */

package dev.warrengates.bettermetadata

import java.sql.Connection

/**
 * Transaction isolation
 *
 * @property type
 * @constructor Create empty Transaction isolation
 */
enum class TransactionIsolation(override val type: Int): IntegerEnum {
    /**
     * None
     *
     * @constructor Create empty None
     */// defined in https://docs.oracle.com/en/java/javase/17/docs/api/java.sql/java/sql/Connection.html
    NONE(Connection.TRANSACTION_NONE),

    /**
     * Read Committed
     *
     * @constructor Create empty Read Committed
     */
    READ_COMMITTED(Connection.TRANSACTION_READ_COMMITTED),

    /**
     * Read Uncommitted
     *
     * @constructor Create empty Read Uncommitted
     */
    READ_UNCOMMITTED(Connection.TRANSACTION_READ_UNCOMMITTED),

    /**
     * Repeatable Read
     *
     * @constructor Create empty Repeatable Read
     */
    REPEATABLE_READ(Connection.TRANSACTION_REPEATABLE_READ),

    /**
     * Serializable
     *
     * @constructor Create empty Serializable
     */
    SERIALIZABLE(Connection.TRANSACTION_SERIALIZABLE);
}