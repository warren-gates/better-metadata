//[BetterMetadata](../../../index.md)/[dev.warrengates.bettermetadata](../index.md)/[Function](index.md)

# Function

[jvm]\
public final class [Function](index.md)

Function

## Parameters

jvm

| | |
|---|---|
| rs |  |

## Constructors

| | |
|---|---|
| [Function](-function.md) | [jvm]<br>[Function](index.md)[Function](-function.md)([DatabaseMetaData](https://docs.oracle.com/javase/8/docs/api/java/sql/DatabaseMetaData.html)metadata, [ResultSet](https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html)rs) |

## Functions

| Name | Summary |
|---|---|
| [getCatalog](get-catalog.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getCatalog](get-catalog.md)()<br>Catalog |
| [getFunctionColumns](get-function-columns.md) | [jvm]<br>final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[FunctionColumn](../-function-column/index.md)&gt;[getFunctionColumns](get-function-columns.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)columnNamePattern)<br>Get function columns |
| [getName](get-name.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getName](get-name.md)()<br>Name |
| [getRemarks](get-remarks.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getRemarks](get-remarks.md)()<br>Remarks |
| [getSchema](get-schema.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getSchema](get-schema.md)()<br>Schema |
| [getSpecificName](get-specific-name.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getSpecificName](get-specific-name.md)()<br>Specific name |
| [getType](get-type.md) | [jvm]<br>final [FunctionReturnType](../-function-return-type/index.md)[getType](get-type.md)()<br>Type |

## Properties

| Name | Summary |
|---|---|
| [catalog](index.md#-522384931%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[catalog](index.md#-522384931%2FProperties%2F-1216412040)<br>Catalog |
| [name](index.md#473137689%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[name](index.md#473137689%2FProperties%2F-1216412040)<br>Name |
| [remarks](index.md#7145027%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[remarks](index.md#7145027%2FProperties%2F-1216412040)<br>Remarks |
| [schema](index.md#-1427651069%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[schema](index.md#-1427651069%2FProperties%2F-1216412040)<br>Schema |
| [specificName](index.md#1640412935%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[specificName](index.md#1640412935%2FProperties%2F-1216412040)<br>Specific name |
| [type](index.md#1402912842%2FProperties%2F-1216412040) | [jvm]<br>private final [FunctionReturnType](../-function-return-type/index.md)[type](index.md#1402912842%2FProperties%2F-1216412040)<br>Type |
