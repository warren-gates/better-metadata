//[BetterMetadata](../../../index.md)/[dev.warrengates.bettermetadata](../index.md)/[Table](index.md)

# Table

[jvm]\
public final class [Table](index.md)

Table

## Parameters

jvm

| | |
|---|---|
| rs |  |

## Constructors

| | |
|---|---|
| [Table](-table.md) | [jvm]<br>[Table](index.md)[Table](-table.md)([DatabaseMetaData](https://docs.oracle.com/javase/8/docs/api/java/sql/DatabaseMetaData.html)metadata, [ResultSet](https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html)rs) |

## Functions

| Name | Summary |
|---|---|
| [getBestRowIdentifier](get-best-row-identifier.md) | [jvm]<br>final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[BestRowIdentifier](../-best-row-identifier/index.md)&gt;[getBestRowIdentifier](get-best-row-identifier.md)([BestRowIdentifierScope](../-best-row-identifier-scope/index.md)scope, [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)nullable)<br>Get best row identifier |
| [getCatalog](get-catalog.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getCatalog](get-catalog.md)()<br>Catalog |
| [getColumns](get-columns.md) | [jvm]<br>@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()<br>final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Column](../-column/index.md)&gt;[getColumns](get-columns.md)()<br>@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()<br>final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Column](../-column/index.md)&gt;[getColumns](get-columns.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)columnNamePattern)<br>Get columns |
| [getExportedKeys](get-exported-keys.md) | [jvm]<br>final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Key](../-key/index.md)&gt;[getExportedKeys](get-exported-keys.md)()<br>Get exported keys |
| [getImportedKeys](get-imported-keys.md) | [jvm]<br>final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Key](../-key/index.md)&gt;[getImportedKeys](get-imported-keys.md)()<br>Get imported keys |
| [getIndexes](get-indexes.md) | [jvm]<br>final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Index](../-index/index.md)&gt;[getIndexes](get-indexes.md)([Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)unique, [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)approximate)<br>Get indexes |
| [getName](get-name.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getName](get-name.md)()<br>Name |
| [getPrimayKeys](get-primay-keys.md) | [jvm]<br>final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[PrimaryKey](../-primary-key/index.md)&gt;[getPrimayKeys](get-primay-keys.md)()<br>Get primay keys |
| [getPseudoColumns](get-pseudo-columns.md) | [jvm]<br>@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()<br>final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[PseudoColumn](../-pseudo-column/index.md)&gt;[getPseudoColumns](get-pseudo-columns.md)()<br>@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()<br>final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[PseudoColumn](../-pseudo-column/index.md)&gt;[getPseudoColumns](get-pseudo-columns.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)columnNamePattern)<br>Get pseudo columns |
| [getReferencingColumnGeneration](get-referencing-column-generation.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getReferencingColumnGeneration](get-referencing-column-generation.md)()<br>Referencing column generation |
| [getRemarks](get-remarks.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getRemarks](get-remarks.md)()<br>Remarks |
| [getSchema](get-schema.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getSchema](get-schema.md)()<br>Schema |
| [getSelfReferencingColumnName](get-self-referencing-column-name.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getSelfReferencingColumnName](get-self-referencing-column-name.md)()<br>Self referencing column name |
| [getTablePrivileges](get-table-privileges.md) | [jvm]<br>final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[TablePrivilege](../-table-privilege/index.md)&gt;[getTablePrivileges](get-table-privileges.md)()<br>Get table privileges |
| [getType](get-type.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getType](get-type.md)()<br>Type |
| [getTypeCatalog](get-type-catalog.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getTypeCatalog](get-type-catalog.md)()<br>Type catalog |
| [getTypeName](get-type-name.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getTypeName](get-type-name.md)()<br>Type name |
| [getTypeSchema](get-type-schema.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getTypeSchema](get-type-schema.md)()<br>Type schema |

## Properties

| Name | Summary |
|---|---|
| [catalog](index.md#1799169635%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[catalog](index.md#1799169635%2FProperties%2F-1216412040)<br>Catalog |
| [name](index.md#1658725203%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[name](index.md#1658725203%2FProperties%2F-1216412040)<br>Name |
| [referencingColumnGeneration](index.md#-2027231962%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[referencingColumnGeneration](index.md#-2027231962%2FProperties%2F-1216412040)<br>Referencing column generation |
| [remarks](index.md#-1966267703%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[remarks](index.md#-1966267703%2FProperties%2F-1216412040)<br>Remarks |
| [schema](index.md#-244383555%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[schema](index.md#-244383555%2FProperties%2F-1216412040)<br>Schema |
| [selfReferencingColumnName](index.md#-102721%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[selfReferencingColumnName](index.md#-102721%2FProperties%2F-1216412040)<br>Self referencing column name |
| [type](index.md#-1706466940%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[type](index.md#-1706466940%2FProperties%2F-1216412040)<br>Type |
| [typeCatalog](index.md#-1383142851%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[typeCatalog](index.md#-1383142851%2FProperties%2F-1216412040)<br>Type catalog |
| [typeName](index.md#1675918777%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[typeName](index.md#1675918777%2FProperties%2F-1216412040)<br>Type name |
| [typeSchema](index.md#-901228125%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[typeSchema](index.md#-901228125%2FProperties%2F-1216412040)<br>Type schema |
