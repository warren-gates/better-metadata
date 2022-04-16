//[BetterMetadata](../../../index.md)/[dev.warrengates.bettermetadata](../index.md)/[BestRowIdentifier](index.md)

# BestRowIdentifier

[jvm]\
public final class [BestRowIdentifier](index.md)

Best row identifier

## Parameters

jvm

| | |
|---|---|
| rs |  |

## Constructors

| | |
|---|---|
| [BestRowIdentifier](-best-row-identifier.md) | [jvm]<br>[BestRowIdentifier](index.md)[BestRowIdentifier](-best-row-identifier.md)([ResultSet](https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html)rs) |

## Functions

| Name | Summary |
|---|---|
| [getColumnName](get-column-name.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getColumnName](get-column-name.md)()<br>Column name |
| [getColumnSize](get-column-size.md) | [jvm]<br>final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[getColumnSize](get-column-size.md)()<br>Precision |
| [getDataType](get-data-type.md) | [jvm]<br>final [JDBCType](https://docs.oracle.com/javase/8/docs/api/java/sql/JDBCType.html)[getDataType](get-data-type.md)()<br>SQL type from [java.sql.Types](https://docs.oracle.com/javase/8/docs/api/java/sql/Types.html) |
| [getDecimalDigits](get-decimal-digits.md) | [jvm]<br>final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[getDecimalDigits](get-decimal-digits.md)()<br>The number of fractional digits, null is returned when decimalDigits is not applicable |
| [getPseudoColumn](get-pseudo-column.md) | [jvm]<br>final [BestRowColumnType](../-best-row-column-type/index.md)[getPseudoColumn](get-pseudo-column.md)()<br>Indicates whether this is a pseudo column like an Oracle ROWID |
| [getScope](get-scope.md) | [jvm]<br>final [BestRowIdentifierScope](../-best-row-identifier-scope/index.md)[getScope](get-scope.md)()<br>Scope of result |
| [getTypeName](get-type-name.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getTypeName](get-type-name.md)()<br>Data source dependent type name, for a [UserDefinedType](../-user-defined-type/index.md) the type name is fully qualified |

## Properties

| Name | Summary |
|---|---|
| [columnName](index.md#101848622%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[columnName](index.md#101848622%2FProperties%2F-1216412040)<br>Column name |
| [columnSize](index.md#1145545080%2FProperties%2F-1216412040) | [jvm]<br>private final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[columnSize](index.md#1145545080%2FProperties%2F-1216412040)<br>Precision |
| [dataType](index.md#1784968459%2FProperties%2F-1216412040) | [jvm]<br>private final [JDBCType](https://docs.oracle.com/javase/8/docs/api/java/sql/JDBCType.html)[dataType](index.md#1784968459%2FProperties%2F-1216412040)<br>SQL type from [java.sql.Types](https://docs.oracle.com/javase/8/docs/api/java/sql/Types.html) |
| [decimalDigits](index.md#-1709244300%2FProperties%2F-1216412040) | [jvm]<br>private final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[decimalDigits](index.md#-1709244300%2FProperties%2F-1216412040)<br>The number of fractional digits, null is returned when decimalDigits is not applicable |
| [pseudoColumn](index.md#931558747%2FProperties%2F-1216412040) | [jvm]<br>private final [BestRowColumnType](../-best-row-column-type/index.md)[pseudoColumn](index.md#931558747%2FProperties%2F-1216412040)<br>Indicates whether this is a pseudo column like an Oracle ROWID |
| [scope](index.md#-134620585%2FProperties%2F-1216412040) | [jvm]<br>private final [BestRowIdentifierScope](../-best-row-identifier-scope/index.md)[scope](index.md#-134620585%2FProperties%2F-1216412040)<br>Scope of result |
| [typeName](index.md#-2079686326%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[typeName](index.md#-2079686326%2FProperties%2F-1216412040)<br>Data source dependent type name, for a [UserDefinedType](../-user-defined-type/index.md) the type name is fully qualified |
