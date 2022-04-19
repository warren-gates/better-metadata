/*
 * Copyright (c) 2022. Warren Gates
 * All rights reserved.
 */

package dev.warrengates.bettermetadata

import java.sql.DatabaseMetaData

/**
 * Indicates whether best row column is a pseudo column like an Oracle ROWID
 *
 * @property value
 * @constructor Create empty Best row column type
 */
enum class BestRowColumnType(override val value: Int): IntegerEnum {
    /**
     * Indicates best row identifier is a pseudo column
     *
     * Source value: [DatabaseMetaData.bestRowPseudo]
     */
    IS_PSEUDO_COLUMN(DatabaseMetaData.bestRowPseudo),

    /**
     * Indicates best row identifier is NOT a pseudo column
     *
     * Source value: [DatabaseMetaData.bestRowNotPseudo]
     */
    NOT_PSEUDO_COLUMN(DatabaseMetaData.bestRowNotPseudo),

    /**
     * Indicates best row identifier may or may not be a pseudo column
     *
     * Source value: [DatabaseMetaData.bestRowUnknown]
     */
    UNKNOWN(DatabaseMetaData.bestRowUnknown);
}