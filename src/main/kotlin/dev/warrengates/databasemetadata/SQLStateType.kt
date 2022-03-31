package dev.warrengates.databasemetadata

import java.sql.DatabaseMetaData

enum class SQLStateType(override val type: Int): IntegerEnum {
    // definition https://docs.oracle.com/en/java/javase/17/docs/api/java.sql/java/sql/DatabaseMetaData.html
    SQL(DatabaseMetaData.sqlStateSQL),

    // TODO: document this, see above link
//    SQL99(DatabaseMetaData.sqlStateSQL99),
    XOpen(DatabaseMetaData.sqlStateXOpen);
}