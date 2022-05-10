//[BetterMetadata](../../../index.md)/[dev.warrengates.bettermetadata](../index.md)/[Table](index.md)

# Table

[jvm]\
public final class [Table](index.md)

Wrapper for the results of [getTables](https://docs.oracle.com/en/java/javase/17/docs/api/java.sql/java/sql/DatabaseMetaData.html#getTables(java.lang.String,java.lang.String,java.lang.String,java.lang.String%5B%5D))

## Constructors

| | |
|---|---|
| [Table](-table.md) | [jvm]<br>[Table](index.md)[Table](-table.md)([DatabaseMetaData](https://docs.oracle.com/javase/8/docs/api/java/sql/DatabaseMetaData.html)metadata, [ResultSet](https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html)rs) |

## Functions

| Name | Summary |
|---|---|
| [equals](equals.md) | [jvm]<br>[Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[equals](equals.md)([Object](https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html)other) |
| [getBestRowIdentifier](get-best-row-identifier.md) | [jvm]<br>final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[BestRowIdentifier](../-best-row-identifier/index.md)&gt;[getBestRowIdentifier](get-best-row-identifier.md)([BestRowIdentifierScope](../-best-row-identifier-scope/index.md)scope, [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)nullable)<br>Get best row identifier for this table |
| [getCatalog](get-catalog.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getCatalog](get-catalog.md)()<br>Catalog |
| [getColumns](get-columns.md) | [jvm]<br>@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()<br>final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Column](../-column/index.md)&gt;[getColumns](get-columns.md)()<br>@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()<br>final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Column](../-column/index.md)&gt;[getColumns](get-columns.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)columnNamePattern)<br>Get columns for this table |
| [getExportedKeys](get-exported-keys.md) | [jvm]<br>final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Key](../-key/index.md)&gt;[getExportedKeys](get-exported-keys.md)()<br>Get keys exported from this table |
| [getImportedKeys](get-imported-keys.md) | [jvm]<br>final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Key](../-key/index.md)&gt;[getImportedKeys](get-imported-keys.md)()<br>Get keys imported from other tables |
| [getIndexes](get-indexes.md) | [jvm]<br>final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Index](../-index/index.md)&gt;[getIndexes](get-indexes.md)([Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)unique, [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)approximate)<br>Get indexes |
| [getName](get-name.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getName](get-name.md)()<br>Name |
| [getPrimaryKey](get-primary-key.md) | [jvm]<br>final [PrimaryKey](../-primary-key/index.md)[getPrimaryKey](get-primary-key.md)() |
| [getPseudoColumns](get-pseudo-columns.md) | [jvm]<br>@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()<br>final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[PseudoColumn](../-pseudo-column/index.md)&gt;[getPseudoColumns](get-pseudo-columns.md)()<br>@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()<br>final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[PseudoColumn](../-pseudo-column/index.md)&gt;[getPseudoColumns](get-pseudo-columns.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)columnNamePattern)<br>Get pseudo columns |
| [getReferencingColumnGeneration](get-referencing-column-generation.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getReferencingColumnGeneration](get-referencing-column-generation.md)()<br>Referencing column generation |
| [getRemarks](get-remarks.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getRemarks](get-remarks.md)()<br>Remarks |
| [getSchema](get-schema.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getSchema](get-schema.md)()<br>Schema |
| [getSelfReferencingColumnName](get-self-referencing-column-name.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getSelfReferencingColumnName](get-self-referencing-column-name.md)()<br>Self referencing column name |
| [getSuperTables](get-super-tables.md) | [jvm]<br>final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Table](index.md)&gt;[getSuperTables](get-super-tables.md)()<br>Get super tables of this table |
| [getTablePrivileges](get-table-privileges.md) | [jvm]<br>final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[TablePrivilege](../-table-privilege/index.md)&gt;[getTablePrivileges](get-table-privileges.md)()<br>Get table privileges |
| [getType](get-type.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getType](get-type.md)()<br>Type |
| [getTypeCatalog](get-type-catalog.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getTypeCatalog](get-type-catalog.md)()<br>Type catalog |
| [getTypeName](get-type-name.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getTypeName](get-type-name.md)()<br>Type name |
| [getTypeSchema](get-type-schema.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getTypeSchema](get-type-schema.md)()<br>Type schema |
| [getVersionColumns](get-version-columns.md) | [jvm]<br>final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[VersionColumn](../-version-column/index.md)&gt;[getVersionColumns](get-version-columns.md)()<br>Get version columns |
| [hashCode](hash-code.md) | [jvm]<br>[Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[hashCode](hash-code.md)() |

## Properties

| Name | Summary |
|---|---|
| [catalog](index.md#1799169635%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[catalog](index.md#1799169635%2FProperties%2F-1216412040)<br>Catalog |
| [name](index.md#1658725203%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[name](index.md#1658725203%2FProperties%2F-1216412040)<br>Name |
| [primaryKey](index.md#761695329%2FProperties%2F-1216412040) | [jvm]<br>private final [PrimaryKey](../-primary-key/index.md)[primaryKey](index.md#761695329%2FProperties%2F-1216412040)<br>Get primary keys |
| [referencingColumnGeneration](index.md#-2027231962%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[referencingColumnGeneration](index.md#-2027231962%2FProperties%2F-1216412040)<br>Referencing column generation |
| [remarks](index.md#-1966267703%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[remarks](index.md#-1966267703%2FProperties%2F-1216412040)<br>Remarks |
| [schema](index.md#-244383555%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[schema](index.md#-244383555%2FProperties%2F-1216412040)<br>Schema |
| [selfReferencingColumnName](index.md#-102721%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[selfReferencingColumnName](index.md#-102721%2FProperties%2F-1216412040)<br>Self referencing column name |
| [type](index.md#-1706466940%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[type](index.md#-1706466940%2FProperties%2F-1216412040)<br>Type |
| [typeCatalog](index.md#-1383142851%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[typeCatalog](index.md#-1383142851%2FProperties%2F-1216412040)<br>Type catalog |
| [typeName](index.md#1675918777%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[typeName](index.md#1675918777%2FProperties%2F-1216412040)<br>Type name |
| [typeSchema](index.md#-901228125%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[typeSchema](index.md#-901228125%2FProperties%2F-1216412040)<br>Type schema |
