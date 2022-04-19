/*
 * Copyright (c) 2022. Warren Gates
 * All rights reserved.
 */

package dev.warrengates.bettermetadata

import java.sql.Connection

/**
 * Transaction isolation
 *
 */
enum class TransactionIsolation(override val value: Int): IntegerEnum {
    /**
     * None
     *
     * Source value: [Connection.TRANSACTION_NONE]
     */
    NONE(Connection.TRANSACTION_NONE),

    /**
     * Read Committed
     *
     * Source value: [Connection.TRANSACTION_READ_COMMITTED]
     */
    READ_COMMITTED(Connection.TRANSACTION_READ_COMMITTED),

    /**
     * Read Uncommitted
     *
     * Source value: [Connection.TRANSACTION_READ_UNCOMMITTED]
     */
    READ_UNCOMMITTED(Connection.TRANSACTION_READ_UNCOMMITTED),

    /**
     * Repeatable Read
     *
     * Source value: [Connection.TRANSACTION_REPEATABLE_READ]
     */
    REPEATABLE_READ(Connection.TRANSACTION_REPEATABLE_READ),

    /**
     * Serializable
     *
     * Source value: [Connection.TRANSACTION_SERIALIZABLE]
     */
    SERIALIZABLE(Connection.TRANSACTION_SERIALIZABLE);
}