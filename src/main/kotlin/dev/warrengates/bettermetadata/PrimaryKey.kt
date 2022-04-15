/*
 * Copyright (c) 2022. Warren Gates
 * All rights reserved.
 */

package dev.warrengates.bettermetadata

/**
 * Primary key
 *
 * @property name
 * @property columnSequence
 * @constructor Create empty Primary key
 */
class PrimaryKey(val name: String, val columnSequence: List<ColumnSequenceEntry>)