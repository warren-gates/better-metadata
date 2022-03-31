package dev.warrengates.databasemetadata

import java.sql.DatabaseMetaData

enum class IndexType(override val type: Int): IntegerEnum {
    STATISTIC(DatabaseMetaData.tableIndexStatistic.toInt()),
    CLUSTERED(DatabaseMetaData.tableIndexClustered.toInt()),
    HASHED(DatabaseMetaData.tableIndexHashed.toInt()),
    OTHER(DatabaseMetaData.tableIndexOther.toInt());
}