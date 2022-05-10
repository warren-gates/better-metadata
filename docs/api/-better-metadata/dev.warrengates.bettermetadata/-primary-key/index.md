//[BetterMetadata](../../../index.md)/[dev.warrengates.bettermetadata](../index.md)/[PrimaryKey](index.md)

# PrimaryKey

[jvm]\
public final class [PrimaryKey](index.md)

Wrapper for results of [getPrimaryKeys](https://docs.oracle.com/en/java/javase/17/docs/api/java.sql/java/sql/DatabaseMetaData.html#getPrimaryKeys(java.lang.String,java.lang.String,java.lang.String)). It has been refactored to provide of [Column](../-column/index.md) object rather than the flattened view provided by the getPrimaryKeys method.

## Constructors

| | |
|---|---|
| [PrimaryKey](-primary-key.md) | [jvm]<br>[PrimaryKey](index.md)[PrimaryKey](-primary-key.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)name, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Column](../-column/index.md)&gt;columns)<br>Create empty Primary key |

## Functions

| Name | Summary |
|---|---|
| [equals](equals.md) | [jvm]<br>[Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[equals](equals.md)([Object](https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html)other) |
| [getColumns](get-columns.md) | [jvm]<br>final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Column](../-column/index.md)&gt;[getColumns](get-columns.md)()<br>List of [Column](../-column/index.md) objects selected by filtering for the appropriate TABLE_CAT, TABLE_SCHEM, TABLE_NAME, and COLUMN_NAME as returned by [java.sql.DatabaseMetaData.getPrimaryKeys](https://docs.oracle.com/javase/8/docs/api/java/sql/DatabaseMetaData.html#getPrimaryKeys-kotlin.String-kotlin.String-kotlin.String-), and the ordered by KEY_SEQ |
| [getName](get-name.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getName](get-name.md)()<br>Key name |
| [hashCode](hash-code.md) | [jvm]<br>[Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[hashCode](hash-code.md)() |

## Properties

| Name | Summary |
|---|---|
| [columns](index.md#-1504290412%2FProperties%2F-1216412040) | [jvm]<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Column](../-column/index.md)&gt;[columns](index.md#-1504290412%2FProperties%2F-1216412040)<br>List of [Column](../-column/index.md) objects selected by filtering for the appropriate TABLE_CAT, TABLE_SCHEM, TABLE_NAME, and COLUMN_NAME as returned by [java.sql.DatabaseMetaData.getPrimaryKeys](https://docs.oracle.com/javase/8/docs/api/java/sql/DatabaseMetaData.html#getPrimaryKeys-kotlin.String-kotlin.String-kotlin.String-), and the ordered by KEY_SEQ |
| [name](index.md#289265918%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[name](index.md#289265918%2FProperties%2F-1216412040)<br>Key name |
