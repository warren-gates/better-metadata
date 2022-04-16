//[BetterMetadata](../../../index.md)/[dev.warrengates.bettermetadata](../index.md)/[PseudoColumn](index.md)

# PseudoColumn

[jvm]\
public final class [PseudoColumn](index.md)

Pseudo column

## Parameters

jvm

| | |
|---|---|
| rs |  |

## Constructors

| | |
|---|---|
| [PseudoColumn](-pseudo-column.md) | [jvm]<br>[PseudoColumn](index.md)[PseudoColumn](-pseudo-column.md)([ResultSet](https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html)rs) |

## Functions

| Name | Summary |
|---|---|
| [getCatalog](get-catalog.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getCatalog](get-catalog.md)()<br>Catalog |
| [getCharacterOctetLength](get-character-octet-length.md) | [jvm]<br>final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[getCharacterOctetLength](get-character-octet-length.md)()<br>Character octet length |
| [getColumnSize](get-column-size.md) | [jvm]<br>final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[getColumnSize](get-column-size.md)()<br>Column size |
| [getColumnUsage](get-column-usage.md) | [jvm]<br>final [PseudoColumnUsage](https://docs.oracle.com/javase/8/docs/api/java/sql/PseudoColumnUsage.html)[getColumnUsage](get-column-usage.md)()<br>Column usage |
| [getDataType](get-data-type.md) | [jvm]<br>final [JDBCType](https://docs.oracle.com/javase/8/docs/api/java/sql/JDBCType.html)[getDataType](get-data-type.md)()<br>SQL type from [java.sql.Types](https://docs.oracle.com/javase/8/docs/api/java/sql/Types.html) |
| [getDecimalDigits](get-decimal-digits.md) | [jvm]<br>final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[getDecimalDigits](get-decimal-digits.md)()<br>The number of fractional digits, null is returned when decimalDigits is not applicable |
| [getName](get-name.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getName](get-name.md)()<br>Name |
| [getRadix](get-radix.md) | [jvm]<br>final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[getRadix](get-radix.md)()<br>Numeric precision radix |
| [getRemarks](get-remarks.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getRemarks](get-remarks.md)()<br>Remarks |
| [getSchema](get-schema.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getSchema](get-schema.md)()<br>Schema |
| [getTableName](get-table-name.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getTableName](get-table-name.md)()<br>Table name |
| [isNullable](is-nullable.md) | [jvm]<br>final [IsNullable](../-is-nullable/index.md)[isNullable](is-nullable.md)()<br>Is nullable |

## Properties

| Name | Summary |
|---|---|
| [catalog](index.md#581934465%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[catalog](index.md#581934465%2FProperties%2F-1216412040)<br>Catalog |
| [characterOctetLength](index.md#823685620%2FProperties%2F-1216412040) | [jvm]<br>private final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[characterOctetLength](index.md#823685620%2FProperties%2F-1216412040)<br>Character octet length |
| [columnSize](index.md#-2029516215%2FProperties%2F-1216412040) | [jvm]<br>private final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[columnSize](index.md#-2029516215%2FProperties%2F-1216412040)<br>Column size |
| [columnUsage](index.md#706905967%2FProperties%2F-1216412040) | [jvm]<br>private final [PseudoColumnUsage](https://docs.oracle.com/javase/8/docs/api/java/sql/PseudoColumnUsage.html)[columnUsage](index.md#706905967%2FProperties%2F-1216412040)<br>Column usage |
| [dataType](index.md#-2128945636%2FProperties%2F-1216412040) | [jvm]<br>private final [JDBCType](https://docs.oracle.com/javase/8/docs/api/java/sql/JDBCType.html)[dataType](index.md#-2128945636%2FProperties%2F-1216412040)<br>SQL type from [java.sql.Types](https://docs.oracle.com/javase/8/docs/api/java/sql/Types.html) |
| [decimalDigits](index.md#-1895523837%2FProperties%2F-1216412040) | [jvm]<br>private final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[decimalDigits](index.md#-1895523837%2FProperties%2F-1216412040)<br>The number of fractional digits, null is returned when decimalDigits is not applicable |
| [isNullable](is-nullable.md) | [jvm]<br>private final [IsNullable](../-is-nullable/index.md)[isNullable](is-nullable.md)<br>Is nullable |
| [name](index.md#966668533%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[name](index.md#966668533%2FProperties%2F-1216412040)<br>Name |
| [radix](index.md#-782277834%2FProperties%2F-1216412040) | [jvm]<br>private final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[radix](index.md#-782277834%2FProperties%2F-1216412040)<br>Numeric precision radix |
| [remarks](index.md#1111464423%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[remarks](index.md#1111464423%2FProperties%2F-1216412040)<br>Remarks |
| [schema](index.md#409087455%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[schema](index.md#409087455%2FProperties%2F-1216412040)<br>Schema |
| [tableName](index.md#-744031519%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[tableName](index.md#-744031519%2FProperties%2F-1216412040)<br>Table name |
