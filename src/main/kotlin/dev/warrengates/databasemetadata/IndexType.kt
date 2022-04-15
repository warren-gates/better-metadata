package dev.warrengates.databasemetadata

import java.sql.DatabaseMetaData

/**
 * Index type
 *
 * @property type
 * @constructor Create empty Index type
 */
enum class IndexType(override val type: Int): IntegerEnum {
    /**
     * Statistic
     *
     * @constructor Create empty Statistic
     */
    STATISTIC(DatabaseMetaData.tableIndexStatistic.toInt()),

    /**
     * Clustered
     *
     * @constructor Create empty Clustered
     */
    CLUSTERED(DatabaseMetaData.tableIndexClustered.toInt()),

    /**
     * Hashed
     *
     * @constructor Create empty Hashed
     */
    HASHED(DatabaseMetaData.tableIndexHashed.toInt()),

    /**
     * Other
     *
     * @constructor Create empty Other
     */
    OTHER(DatabaseMetaData.tableIndexOther.toInt());
}