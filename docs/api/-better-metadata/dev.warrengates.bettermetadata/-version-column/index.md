//[BetterMetadata](../../../index.md)/[dev.warrengates.bettermetadata](../index.md)/[VersionColumn](index.md)

# VersionColumn

[jvm]\
public final class [VersionColumn](index.md)

Wrapper for results of [getVersionColumns](https://docs.oracle.com/en/java/javase/17/docs/api/java.sql/java/sql/DatabaseMetaData.html#getVersionColumns(java.lang.String,java.lang.String,java.lang.String))

Note that per the documentation SCOPE is unused and has been left out of this class

## Constructors

| | |
|---|---|
| [VersionColumn](-version-column.md) | [jvm]<br>[VersionColumn](index.md)[VersionColumn](-version-column.md)([ResultSet](https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html)rs) |

## Functions

| Name | Summary |
|---|---|
| [getBufferLength](get-buffer-length.md) | [jvm]<br>final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[getBufferLength](get-buffer-length.md)()<br>Buffer length |
| [getColumnName](get-column-name.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getColumnName](get-column-name.md)()<br>Column name |
| [getColumnSize](get-column-size.md) | [jvm]<br>final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[getColumnSize](get-column-size.md)()<br>Column size |
| [getDataType](get-data-type.md) | [jvm]<br>final [JDBCType](https://docs.oracle.com/javase/8/docs/api/java/sql/JDBCType.html)[getDataType](get-data-type.md)()<br>SQL type, converted to [JDBCType](https://docs.oracle.com/javase/8/docs/api/java/sql/JDBCType.html) |
| [getDecimalDigits](get-decimal-digits.md) | [jvm]<br>final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[getDecimalDigits](get-decimal-digits.md)()<br>The number of fractional digits |
| [getPseudoColumn](get-pseudo-column.md) | [jvm]<br>final [VersionColumnType](../-version-column-type/index.md)[getPseudoColumn](get-pseudo-column.md)()<br>Pseudo column, converted to [VersionColumnType](../-version-column-type/index.md) |
| [getTypeName](get-type-name.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getTypeName](get-type-name.md)()<br>Type name |

## Properties

| Name | Summary |
|---|---|
| [bufferLength](index.md#213964408%2FProperties%2F-1216412040) | [jvm]<br>private final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[bufferLength](index.md#213964408%2FProperties%2F-1216412040)<br>Buffer length |
| [columnName](index.md#-1883820195%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[columnName](index.md#-1883820195%2FProperties%2F-1216412040)<br>Column name |
| [columnSize](index.md#-840123737%2FProperties%2F-1216412040) | [jvm]<br>private final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[columnSize](index.md#-840123737%2FProperties%2F-1216412040)<br>Column size |
| [dataType](index.md#-1618211334%2FProperties%2F-1216412040) | [jvm]<br>private final [JDBCType](https://docs.oracle.com/javase/8/docs/api/java/sql/JDBCType.html)[dataType](index.md#-1618211334%2FProperties%2F-1216412040)<br>SQL type, converted to [JDBCType](https://docs.oracle.com/javase/8/docs/api/java/sql/JDBCType.html) |
| [decimalDigits](index.md#2110563557%2FProperties%2F-1216412040) | [jvm]<br>private final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[decimalDigits](index.md#2110563557%2FProperties%2F-1216412040)<br>The number of fractional digits |
| [pseudoColumn](index.md#-330694966%2FProperties%2F-1216412040) | [jvm]<br>private final [VersionColumnType](../-version-column-type/index.md)[pseudoColumn](index.md#-330694966%2FProperties%2F-1216412040)<br>Pseudo column, converted to [VersionColumnType](../-version-column-type/index.md) |
| [typeName](index.md#-1187898823%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[typeName](index.md#-1187898823%2FProperties%2F-1216412040)<br>Type name |
