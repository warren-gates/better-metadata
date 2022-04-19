/*
 * Copyright (c) 2022. Warren Gates
 * All rights reserved.
 */

package dev.warrengates.bettermetadata

/**
 * Key column
 *
 * @property primaryKeyColumn
 * @property foreignKeyColumn
 * @property sequenceNumber
 * @constructor Create empty Key column
 */
class KeyColumn(
    val primaryKeyColumn: Column,
    val foreignKeyColumn: Column,
    val sequenceNumber: Int
)