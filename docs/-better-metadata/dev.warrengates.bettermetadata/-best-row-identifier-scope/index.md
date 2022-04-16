//[BetterMetadata](../../../index.md)/[dev.warrengates.bettermetadata](../index.md)/[BestRowIdentifierScope](index.md)

# BestRowIdentifierScope

[jvm]\
public enum [BestRowIdentifierScope](index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[BestRowIdentifierScope](index.md)&gt; implements [IntegerEnum](../-integer-enum/index.md)

Best row identifier scope

[value](-s-e-s-s-i-o-n/index.md#-54026360%2FProperties%2F-1216412040) values taken from [java.sql.DatabaseMetaData.bestRowTemporary](https://docs.oracle.com/javase/8/docs/api/java/sql/DatabaseMetaData.html#bestRowTemporary--), [java.sql.DatabaseMetaData.bestRowTransaction](https://docs.oracle.com/javase/8/docs/api/java/sql/DatabaseMetaData.html#bestRowTransaction--), and [java.sql.DatabaseMetaData.bestRowSession](https://docs.oracle.com/javase/8/docs/api/java/sql/DatabaseMetaData.html#bestRowSession--)

## Entries

| | |
|---|---|
| [TRANSACTION](-t-r-a-n-s-a-c-t-i-o-n/index.md) | [jvm]<br>[TRANSACTION](-t-r-a-n-s-a-c-t-i-o-n/index.md)<br>valid for remainder of current transaction |
| [TEMPORARY](-t-e-m-p-o-r-a-r-y/index.md) | [jvm]<br>[TEMPORARY](-t-e-m-p-o-r-a-r-y/index.md)<br>valid while using row |
| [SESSION](-s-e-s-s-i-o-n/index.md) | [jvm]<br>[SESSION](-s-e-s-s-i-o-n/index.md)<br>valid for remainder of current session |

## Functions

| Name | Summary |
|---|---|
| [getName](get-name.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getName](get-name.md)() |
| [getOrdinal](get-ordinal.md) | [jvm]<br>final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[getOrdinal](get-ordinal.md)() |
| [getValue](get-value.md) | [jvm]<br>[Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[getValue](get-value.md)()<br>Type |

## Properties

| Name | Summary |
|---|---|
| [name](../-version-column-type/-i-s_-p-s-e-u-d-o_-c-o-l-u-m-n/index.md#-372974862%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[name](../-version-column-type/-i-s_-p-s-e-u-d-o_-c-o-l-u-m-n/index.md#-372974862%2FProperties%2F-1216412040) |
| [ordinal](../-version-column-type/-i-s_-p-s-e-u-d-o_-c-o-l-u-m-n/index.md#-739389684%2FProperties%2F-1216412040) | [jvm]<br>private final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[ordinal](../-version-column-type/-i-s_-p-s-e-u-d-o_-c-o-l-u-m-n/index.md#-739389684%2FProperties%2F-1216412040) |
| [value](-s-e-s-s-i-o-n/index.md#-54026360%2FProperties%2F-1216412040) | [jvm]<br>private final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[value](-s-e-s-s-i-o-n/index.md#-54026360%2FProperties%2F-1216412040)<br>Type |
