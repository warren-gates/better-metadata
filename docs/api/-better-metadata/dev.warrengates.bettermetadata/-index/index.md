//[BetterMetadata](../../../index.md)/[dev.warrengates.bettermetadata](../index.md)/[Index](index.md)

# Index

[jvm]\
public final class [Index](index.md)

Wrapper for the results of the [getIndexInfo](https://docs.oracle.com/en/java/javase/17/docs/api/java.sql/java/sql/DatabaseMetaData.html#getIndexInfo(java.lang.String,java.lang.String,java.lang.String,boolean,boolean)) method and represents a [Table](../-table/index.md)'s indices and statistics.  Returned from [Table.getIndexes](../-table/get-indexes.md)

## Constructors

| | |
|---|---|
| [Index](-index.md) | [jvm]<br>[Index](index.md)[Index](-index.md)([Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [Object](https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html)&gt;values) |

## Functions

| Name | Summary |
|---|---|
| [equals](equals.md) | [jvm]<br>[Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[equals](equals.md)([Object](https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html)other) |
| [getCardinality](get-cardinality.md) | [jvm]<br>final [Long](https://docs.oracle.com/javase/8/docs/api/java/lang/Long.html)[getCardinality](get-cardinality.md)()<br>Cardinality, when [type](index.md#423276424%2FProperties%2F-1216412040) is [IndexType.STATISTIC](../-index-type/-s-t-a-t-i-s-t-i-c/index.md) this is the number of rows in the table, otherwise it is the number of unique values in the index |
| [getCatalog](get-catalog.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getCatalog](get-catalog.md)()<br>Catalog |
| [getFilterCondition](get-filter-condition.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getFilterCondition](get-filter-condition.md)()<br>Filter condition |
| [getIndexColumns](get-index-columns.md) | [jvm]<br>final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[IndexColumn](../-index-column/index.md)&gt;[getIndexColumns](get-index-columns.md)()<br>Index columns |
| [getIndexQualifier](get-index-qualifier.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getIndexQualifier](get-index-qualifier.md)()<br>Index qualifier, null when [type](index.md#423276424%2FProperties%2F-1216412040) is [IndexType.STATISTIC](../-index-type/-s-t-a-t-i-s-t-i-c/index.md) |
| [getName](get-name.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getName](get-name.md)()<br>Name, null when [type](index.md#423276424%2FProperties%2F-1216412040) is [IndexType.STATISTIC](../-index-type/-s-t-a-t-i-s-t-i-c/index.md) |
| [getNonUnique](get-non-unique.md) | [jvm]<br>final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[getNonUnique](get-non-unique.md)()<br>Non unique, false when [type](index.md#423276424%2FProperties%2F-1216412040) is [IndexType.STATISTIC](../-index-type/-s-t-a-t-i-s-t-i-c/index.md) |
| [getPages](get-pages.md) | [jvm]<br>final [Long](https://docs.oracle.com/javase/8/docs/api/java/lang/Long.html)[getPages](get-pages.md)()<br>Pages, when [type](index.md#423276424%2FProperties%2F-1216412040) is [IndexType.STATISTIC](../-index-type/-s-t-a-t-i-s-t-i-c/index.md) this is then number pages used for the table, otherwise it is the number of pages used for the current index |
| [getSchema](get-schema.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getSchema](get-schema.md)()<br>Schema |
| [getTableName](get-table-name.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getTableName](get-table-name.md)()<br>Table name |
| [getType](get-type.md) | [jvm]<br>final [IndexType](../-index-type/index.md)[getType](get-type.md)()<br>Type |
| [hashCode](hash-code.md) | [jvm]<br>[Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[hashCode](hash-code.md)() |

## Properties

| Name | Summary |
|---|---|
| [cardinality](index.md#-157977462%2FProperties%2F-1216412040) | [jvm]<br>private final [Long](https://docs.oracle.com/javase/8/docs/api/java/lang/Long.html)[cardinality](index.md#-157977462%2FProperties%2F-1216412040)<br>Cardinality, when [type](index.md#423276424%2FProperties%2F-1216412040) is [IndexType.STATISTIC](../-index-type/-s-t-a-t-i-s-t-i-c/index.md) this is the number of rows in the table, otherwise it is the number of unique values in the index |
| [catalog](index.md#-568137249%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[catalog](index.md#-568137249%2FProperties%2F-1216412040)<br>Catalog |
| [filterCondition](index.md#-1683275339%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[filterCondition](index.md#-1683275339%2FProperties%2F-1216412040)<br>Filter condition |
| [indexColumns](index.md#-1146198985%2FProperties%2F-1216412040) | [jvm]<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[IndexColumn](../-index-column/index.md)&gt;[indexColumns](index.md#-1146198985%2FProperties%2F-1216412040)<br>Index columns |
| [indexQualifier](index.md#267389514%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[indexQualifier](index.md#267389514%2FProperties%2F-1216412040)<br>Index qualifier, null when [type](index.md#423276424%2FProperties%2F-1216412040) is [IndexType.STATISTIC](../-index-type/-s-t-a-t-i-s-t-i-c/index.md) |
| [name](index.md#-506498729%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[name](index.md#-506498729%2FProperties%2F-1216412040)<br>Name, null when [type](index.md#423276424%2FProperties%2F-1216412040) is [IndexType.STATISTIC](../-index-type/-s-t-a-t-i-s-t-i-c/index.md) |
| [nonUnique](index.md#-1393068582%2FProperties%2F-1216412040) | [jvm]<br>private final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[nonUnique](index.md#-1393068582%2FProperties%2F-1216412040)<br>Non unique, false when [type](index.md#423276424%2FProperties%2F-1216412040) is [IndexType.STATISTIC](../-index-type/-s-t-a-t-i-s-t-i-c/index.md) |
| [pages](index.md#300747604%2FProperties%2F-1216412040) | [jvm]<br>private final [Long](https://docs.oracle.com/javase/8/docs/api/java/lang/Long.html)[pages](index.md#300747604%2FProperties%2F-1216412040)<br>Pages, when [type](index.md#423276424%2FProperties%2F-1216412040) is [IndexType.STATISTIC](../-index-type/-s-t-a-t-i-s-t-i-c/index.md) this is then number pages used for the table, otherwise it is the number of pages used for the current index |
| [schema](index.md#2034556353%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[schema](index.md#2034556353%2FProperties%2F-1216412040)<br>Schema |
| [tableName](index.md#2138613695%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[tableName](index.md#2138613695%2FProperties%2F-1216412040)<br>Table name |
| [type](index.md#423276424%2FProperties%2F-1216412040) | [jvm]<br>private final [IndexType](../-index-type/index.md)[type](index.md#423276424%2FProperties%2F-1216412040)<br>Type |
