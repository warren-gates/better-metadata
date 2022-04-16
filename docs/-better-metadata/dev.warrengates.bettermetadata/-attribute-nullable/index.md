//[BetterMetadata](../../../index.md)/[dev.warrengates.bettermetadata](../index.md)/[AttributeNullable](index.md)

# AttributeNullable

[jvm]\
public enum [AttributeNullable](index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[AttributeNullable](index.md)&gt; implements [IntegerEnum](../-integer-enum/index.md)

Indicates whether NULL is allowed

[value](-n-o/index.md#406812316%2FProperties%2F-1216412040) values taken from [java.sql.DatabaseMetaData.attributeNoNulls](https://docs.oracle.com/javase/8/docs/api/java/sql/DatabaseMetaData.html#attributeNoNulls--), [java.sql.DatabaseMetaData.attributeNullable](https://docs.oracle.com/javase/8/docs/api/java/sql/DatabaseMetaData.html#attributeNullable--), and [java.sql.DatabaseMetaData.attributeNullableUnknown](https://docs.oracle.com/javase/8/docs/api/java/sql/DatabaseMetaData.html#attributeNullableUnknown--)

## Entries

| | |
|---|---|
| [UNKNOWN](-u-n-k-n-o-w-n/index.md) | [jvm]<br>[UNKNOWN](-u-n-k-n-o-w-n/index.md)<br>Nullability unknown |
| [YES](-y-e-s/index.md) | [jvm]<br>[YES](-y-e-s/index.md)<br>Definitely allows NULL values |
| [NO](-n-o/index.md) | [jvm]<br>[NO](-n-o/index.md)<br>Might not allow NULL values |

## Functions

| Name | Summary |
|---|---|
| [getName](get-name.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getName](get-name.md)() |
| [getOrdinal](get-ordinal.md) | [jvm]<br>final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[getOrdinal](get-ordinal.md)() |
| [getValue](get-value.md) | [jvm]<br>[Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[getValue](get-value.md)() |

## Properties

| Name | Summary |
|---|---|
| [name](../-version-column-type/-i-s_-p-s-e-u-d-o_-c-o-l-u-m-n/index.md#-372974862%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[name](../-version-column-type/-i-s_-p-s-e-u-d-o_-c-o-l-u-m-n/index.md#-372974862%2FProperties%2F-1216412040) |
| [ordinal](../-version-column-type/-i-s_-p-s-e-u-d-o_-c-o-l-u-m-n/index.md#-739389684%2FProperties%2F-1216412040) | [jvm]<br>private final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[ordinal](../-version-column-type/-i-s_-p-s-e-u-d-o_-c-o-l-u-m-n/index.md#-739389684%2FProperties%2F-1216412040) |
| [value](-n-o/index.md#406812316%2FProperties%2F-1216412040) | [jvm]<br>private final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[value](-n-o/index.md#406812316%2FProperties%2F-1216412040) |
