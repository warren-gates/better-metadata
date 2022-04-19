/*
 * Copyright (c) 2022. Warren Gates
 * All rights reserved.
 */

package dev.warrengates.bettermetadata

import java.sql.DatabaseMetaData

/**
 * Type searchable
 *
 * @property value
 */
enum class TypeSearchable(override val value: Int): IntegerEnum {
    /**
     * Basic
     *
     * Source value: [DatabaseMetaData.typePredBasic]
     */
    BASIC(DatabaseMetaData.typePredBasic),

    /**
     * Character
     *
     * Source value: [DatabaseMetaData.typePredChar]
     */
    CHAR(DatabaseMetaData.typePredChar),

    /**
     * None
     *
     * Source value: [DatabaseMetaData.typePredNone]
     */
    NONE(DatabaseMetaData.typePredNone),

    /**
     * Searchable
     *
     * Source value: [DatabaseMetaData.typeSearchable]
     */
    SEARCHABLE(DatabaseMetaData.typeSearchable);
}