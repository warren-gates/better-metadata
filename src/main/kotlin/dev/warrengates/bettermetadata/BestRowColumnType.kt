/*
 * Copyright (c) 2022. Warren Gates
 * All rights reserved.
 */

package dev.warrengates.bettermetadata

import java.sql.DatabaseMetaData

/**
 * Best row column type
 *
 * [value] values taken from [java.sql.DatabaseMetaData.bestRowPseudo],
 * [java.sql.DatabaseMetaData.bestRowNotPseudo], and
 * [java.sql.DatabaseMetaData.bestRowUnknown]
 *
 * @property value
 * @constructor Create empty Best row column type
 */
enum class BestRowColumnType(override val value: Int): IntegerEnum {
    /**
     * Indicates best row identifier is a pseudo column
     */
    IS_PSEUDO_COLUMN(DatabaseMetaData.bestRowPseudo),

    /**
     * Indicates best row identifier is NOT a pseudo column
     */
    NOT_PSEUDO_COLUMN(DatabaseMetaData.bestRowNotPseudo),

    /**
     * Indicates best row identifier may or may not be a pseudo column
     */
    UNKNOWN(DatabaseMetaData.bestRowUnknown);
}