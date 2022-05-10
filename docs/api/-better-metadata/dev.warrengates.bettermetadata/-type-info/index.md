//[BetterMetadata](../../../index.md)/[dev.warrengates.bettermetadata](../index.md)/[TypeInfo](index.md)

# TypeInfo

[jvm]\
public final class [TypeInfo](index.md)

Wrapper for results of [getTypeInfo](https://docs.oracle.com/en/java/javase/17/docs/api/java.sql/java/sql/DatabaseMetaData.html#getTypeInfo())

Note that per the documentation SQL_DATA_TYPE, and SQL_DATETIME_SUB are unused and have been left out of this class

## Constructors

| | |
|---|---|
| [TypeInfo](-type-info.md) | [jvm]<br>[TypeInfo](index.md)[TypeInfo](-type-info.md)([ResultSet](https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html)rs) |

## Functions

| Name | Summary |
|---|---|
| [equals](equals.md) | [jvm]<br>[Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[equals](equals.md)([Object](https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html)other) |
| [getAutoIncrement](get-auto-increment.md) | [jvm]<br>final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[getAutoIncrement](get-auto-increment.md)()<br>Auto increment |
| [getCaseSensitive](get-case-sensitive.md) | [jvm]<br>final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[getCaseSensitive](get-case-sensitive.md)()<br>Case sensitive |
| [getCreateParams](get-create-params.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getCreateParams](get-create-params.md)()<br>Create params |
| [getDataType](get-data-type.md) | [jvm]<br>final [JDBCType](https://docs.oracle.com/javase/8/docs/api/java/sql/JDBCType.html)[getDataType](get-data-type.md)()<br>SQL type, converted to [JDBCType](https://docs.oracle.com/javase/8/docs/api/java/sql/JDBCType.html) |
| [getFixedPrecisionScale](get-fixed-precision-scale.md) | [jvm]<br>final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[getFixedPrecisionScale](get-fixed-precision-scale.md)()<br>Fixed precision scale |
| [getLiteralPrefix](get-literal-prefix.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getLiteralPrefix](get-literal-prefix.md)()<br>Literal prefix |
| [getLiteralSuffix](get-literal-suffix.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getLiteralSuffix](get-literal-suffix.md)()<br>Literal suffix |
| [getLocalTypeName](get-local-type-name.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getLocalTypeName](get-local-type-name.md)()<br>Local type name |
| [getMaximumScale](get-maximum-scale.md) | [jvm]<br>final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[getMaximumScale](get-maximum-scale.md)()<br>Maximum scale |
| [getMinimumScale](get-minimum-scale.md) | [jvm]<br>final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[getMinimumScale](get-minimum-scale.md)()<br>Minimum scale |
| [getName](get-name.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getName](get-name.md)()<br>Name |
| [getNullable](get-nullable.md) | [jvm]<br>final [TypeNullable](../-type-nullable/index.md)[getNullable](get-nullable.md)()<br>Nullable, converted to [TypeNullable](../-type-nullable/index.md) |
| [getPrecision](get-precision.md) | [jvm]<br>final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[getPrecision](get-precision.md)()<br>Precision |
| [getRadix](get-radix.md) | [jvm]<br>final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[getRadix](get-radix.md)()<br>Numeric precision radix |
| [getSearchable](get-searchable.md) | [jvm]<br>final [TypeSearchable](../-type-searchable/index.md)[getSearchable](get-searchable.md)()<br>Searchable, converted to [TypeSearchable](../-type-searchable/index.md) |
| [hashCode](hash-code.md) | [jvm]<br>[Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[hashCode](hash-code.md)() |
| [isUnsigned](is-unsigned.md) | [jvm]<br>final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[isUnsigned](is-unsigned.md)()<br>Is unsigned |

## Properties

| Name | Summary |
|---|---|
| [autoIncrement](index.md#1217701222%2FProperties%2F-1216412040) | [jvm]<br>private final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[autoIncrement](index.md#1217701222%2FProperties%2F-1216412040)<br>Auto increment |
| [caseSensitive](index.md#-2063799968%2FProperties%2F-1216412040) | [jvm]<br>private final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[caseSensitive](index.md#-2063799968%2FProperties%2F-1216412040)<br>Case sensitive |
| [createParams](index.md#1814292242%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[createParams](index.md#1814292242%2FProperties%2F-1216412040)<br>Create params |
| [dataType](index.md#-1125582736%2FProperties%2F-1216412040) | [jvm]<br>private final [JDBCType](https://docs.oracle.com/javase/8/docs/api/java/sql/JDBCType.html)[dataType](index.md#-1125582736%2FProperties%2F-1216412040)<br>SQL type, converted to [JDBCType](https://docs.oracle.com/javase/8/docs/api/java/sql/JDBCType.html) |
| [fixedPrecisionScale](index.md#1778972966%2FProperties%2F-1216412040) | [jvm]<br>private final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[fixedPrecisionScale](index.md#1778972966%2FProperties%2F-1216412040)<br>Fixed precision scale |
| [isUnsigned](is-unsigned.md) | [jvm]<br>private final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[isUnsigned](is-unsigned.md)<br>Is unsigned |
| [literalPrefix](index.md#-2019815707%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[literalPrefix](index.md#-2019815707%2FProperties%2F-1216412040)<br>Literal prefix |
| [literalSuffix](index.md#-240365818%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[literalSuffix](index.md#-240365818%2FProperties%2F-1216412040)<br>Literal suffix |
| [localTypeName](index.md#-1377166218%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[localTypeName](index.md#-1377166218%2FProperties%2F-1216412040)<br>Local type name |
| [maximumScale](index.md#-1413681494%2FProperties%2F-1216412040) | [jvm]<br>private final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[maximumScale](index.md#-1413681494%2FProperties%2F-1216412040)<br>Maximum scale |
| [minimumScale](index.md#1228878872%2FProperties%2F-1216412040) | [jvm]<br>private final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[minimumScale](index.md#1228878872%2FProperties%2F-1216412040)<br>Minimum scale |
| [name](index.md#-274819767%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[name](index.md#-274819767%2FProperties%2F-1216412040)<br>Name |
| [nullable](index.md#1011030451%2FProperties%2F-1216412040) | [jvm]<br>private final [TypeNullable](../-type-nullable/index.md)[nullable](index.md#1011030451%2FProperties%2F-1216412040)<br>Nullable, converted to [TypeNullable](../-type-nullable/index.md) |
| [precision](index.md#1507805608%2FProperties%2F-1216412040) | [jvm]<br>private final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[precision](index.md#1507805608%2FProperties%2F-1216412040)<br>Precision |
| [radix](index.md#-613709470%2FProperties%2F-1216412040) | [jvm]<br>private final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[radix](index.md#-613709470%2FProperties%2F-1216412040)<br>Numeric precision radix |
| [searchable](index.md#-968497294%2FProperties%2F-1216412040) | [jvm]<br>private final [TypeSearchable](../-type-searchable/index.md)[searchable](index.md#-968497294%2FProperties%2F-1216412040)<br>Searchable, converted to [TypeSearchable](../-type-searchable/index.md) |
