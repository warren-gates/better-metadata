/*
 * Copyright (c) 2022. Warren Gates
 * All rights reserved.
 */

package dev.warrengates.bettermetadata

import java.sql.DatabaseMetaData

/**
 * Index type
 *
 * @property value
 */
enum class IndexType(override val value: Int): IntegerEnum {
    /**
     * Statistic
     *
     * Source value: [DatabaseMetaData.tableIndexStatistic]
     */
    STATISTIC(DatabaseMetaData.tableIndexStatistic.toInt()),

    /**
     * Clustered
     *
     * Source value: [DatabaseMetaData.tableIndexClustered]
     */
    CLUSTERED(DatabaseMetaData.tableIndexClustered.toInt()),

    /**
     * Hashed
     *
     * Source value: [DatabaseMetaData.tableIndexHashed]
     */
    HASHED(DatabaseMetaData.tableIndexHashed.toInt()),

    /**
     * Other
     *
     * Source value: [DatabaseMetaData.tableIndexOther]
     */
    OTHER(DatabaseMetaData.tableIndexOther.toInt());
}