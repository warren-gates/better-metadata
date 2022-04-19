/*
 * Copyright (c) 2022. Warren Gates
 * All rights reserved.
 */

package dev.warrengates.bettermetadata

/**
 * Holds a [Column] and its sequence number for use in [PrimaryKey]
 *
 * @property column A primary key column
 * @property sequenceNumber Column's sequence number in primary key, starting with 1
 * @constructor
 */
class PrimaryKeyColumn(val column: Column, val sequenceNumber: Int)