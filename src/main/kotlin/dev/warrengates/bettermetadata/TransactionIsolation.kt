/*
 * Copyright (c) 2022 Warren Gates
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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