//[BetterMetadata](../../../index.md)/[dev.warrengates.bettermetadata](../index.md)/[UserDefinedType](index.md)

# UserDefinedType

[jvm]\
public final class [UserDefinedType](index.md)

Wrapper for results of [getUDTs](https://docs.oracle.com/en/java/javase/17/docs/api/java.sql/java/sql/DatabaseMetaData.html#getUDTs(java.lang.String,java.lang.String,java.lang.String,int%5B%5D))

## Constructors

| | |
|---|---|
| [UserDefinedType](-user-defined-type.md) | [jvm]<br>[UserDefinedType](index.md)[UserDefinedType](-user-defined-type.md)([DatabaseMetaData](https://docs.oracle.com/javase/8/docs/api/java/sql/DatabaseMetaData.html)metadata, [ResultSet](https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html)rs) |

## Functions

| Name | Summary |
|---|---|
| [equals](equals.md) | [jvm]<br>[Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[equals](equals.md)([Object](https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html)other) |
| [getAttributes](get-attributes.md) | [jvm]<br>@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()<br>final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Attribute](../-attribute/index.md)&gt;[getAttributes](get-attributes.md)()<br>@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()<br>final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Attribute](../-attribute/index.md)&gt;[getAttributes](get-attributes.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)attributeNamePattern)<br>Get attributes |
| [getBaseType](get-base-type.md) | [jvm]<br>final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[getBaseType](get-base-type.md)()<br>Base type |
| [getCatalog](get-catalog.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getCatalog](get-catalog.md)()<br>Catalog |
| [getClassName](get-class-name.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getClassName](get-class-name.md)()<br>Class name |
| [getDataType](get-data-type.md) | [jvm]<br>final [JDBCType](https://docs.oracle.com/javase/8/docs/api/java/sql/JDBCType.html)[getDataType](get-data-type.md)()<br>SQL type, converted to [JDBCType](https://docs.oracle.com/javase/8/docs/api/java/sql/JDBCType.html) |
| [getName](get-name.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getName](get-name.md)()<br>Name |
| [getRemarks](get-remarks.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getRemarks](get-remarks.md)()<br>Remarks |
| [getSchema](get-schema.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getSchema](get-schema.md)()<br>Schema |
| [getSuperTypes](get-super-types.md) | [jvm]<br>final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[SuperType](../-super-type/index.md)&gt;[getSuperTypes](get-super-types.md)()<br>Get super types for this type |
| [hashCode](hash-code.md) | [jvm]<br>[Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[hashCode](hash-code.md)() |

## Properties

| Name | Summary |
|---|---|
| [baseType](index.md#992287485%2FProperties%2F-1216412040) | [jvm]<br>private final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[baseType](index.md#992287485%2FProperties%2F-1216412040)<br>Base type |
| [catalog](index.md#2075613657%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[catalog](index.md#2075613657%2FProperties%2F-1216412040)<br>Catalog |
| [className](index.md#1987619791%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[className](index.md#1987619791%2FProperties%2F-1216412040)<br>Class name |
| [dataType](index.md#1225436356%2FProperties%2F-1216412040) | [jvm]<br>private final [JDBCType](https://docs.oracle.com/javase/8/docs/api/java/sql/JDBCType.html)[dataType](index.md#1225436356%2FProperties%2F-1216412040)<br>SQL type, converted to [JDBCType](https://docs.oracle.com/javase/8/docs/api/java/sql/JDBCType.html) |
| [name](index.md#332370845%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[name](index.md#332370845%2FProperties%2F-1216412040)<br>Name |
| [remarks](index.md#-1689823681%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[remarks](index.md#-1689823681%2FProperties%2F-1216412040)<br>Remarks |
| [schema](index.md#734365319%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[schema](index.md#734365319%2FProperties%2F-1216412040)<br>Schema |
