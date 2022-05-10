//[BetterMetadata](../../../index.md)/[dev.warrengates.bettermetadata](../index.md)/[PrimaryKey](index.md)/[getColumns](get-columns.md)

# getColumns

[jvm]\

final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Column](../-column/index.md)&gt;[getColumns](get-columns.md)()

List of [Column](../-column/index.md) objects selected by filtering for the appropriate TABLE_CAT, TABLE_SCHEM, TABLE_NAME, and COLUMN_NAME as returned by [java.sql.DatabaseMetaData.getPrimaryKeys](https://docs.oracle.com/javase/8/docs/api/java/sql/DatabaseMetaData.html#getPrimaryKeys-kotlin.String-kotlin.String-kotlin.String-), and the ordered by KEY_SEQ
