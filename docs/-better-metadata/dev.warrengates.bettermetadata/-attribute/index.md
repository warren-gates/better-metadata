//[BetterMetadata](../../../index.md)/[dev.warrengates.bettermetadata](../index.md)/[Attribute](index.md)

# Attribute

[jvm]\
public final class [Attribute](index.md)

Attribute represents an attribute of a [UserDefinedType](../-user-defined-type/index.md). It does not contain inherited attributes.

See documentation [here](https://docs.oracle.com/en/java/javase/17/docs/api/java.sql/java/sql/DatabaseMetaData.html#getAttributes(java.lang.String,java.lang.String,java.lang.String,java.lang.String))

## Parameters

jvm

| | |
|---|---|
| rs | a [ResultSet](https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html) |

## Constructors

| | |
|---|---|
| [Attribute](-attribute.md) | [jvm]<br>[Attribute](index.md)[Attribute](-attribute.md)([ResultSet](https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html)rs) |

## Functions

| Name | Summary |
|---|---|
| [equals](equals.md) | [jvm]<br>[Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[equals](equals.md)([Object](https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html)other) |
| [getAttributeDefault](get-attribute-default.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getAttributeDefault](get-attribute-default.md)()<br>Attribute default value |
| [getAttributeSize](get-attribute-size.md) | [jvm]<br>final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[getAttributeSize](get-attribute-size.md)()<br>Column size, from &quot;&quot; column |
| [getAttributeTypeName](get-attribute-type-name.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getAttributeTypeName](get-attribute-type-name.md)()<br>Attribute type name, from &quot;&quot; column |
| [getCatalog](get-catalog.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getCatalog](get-catalog.md)()<br>Catalog name, from &quot;TYPE_CAT&quot; column |
| [getCharacterOctetLength](get-character-octet-length.md) | [jvm]<br>final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[getCharacterOctetLength](get-character-octet-length.md)()<br>For character types this represents the maximum number of bytes in the column |
| [getDataType](get-data-type.md) | [jvm]<br>final [JDBCType](https://docs.oracle.com/javase/8/docs/api/java/sql/JDBCType.html)[getDataType](get-data-type.md)()<br>SQL type, from &quot;&quot; column |
| [getDecimalDigits](get-decimal-digits.md) | [jvm]<br>final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[getDecimalDigits](get-decimal-digits.md)()<br>The number of fractional digits, null is returned when decimalDigits is not applicable |
| [getName](get-name.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getName](get-name.md)()<br>Attribute name, from &quot;&quot; column |
| [getNullable](get-nullable.md) | [jvm]<br>final [AttributeNullable](../-attribute-nullable/index.md)[getNullable](get-nullable.md)()<br>Indicates whether attribute is nullable |
| [getOrdinalPosition](get-ordinal-position.md) | [jvm]<br>final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[getOrdinalPosition](get-ordinal-position.md)()<br>Index of the attribute in the [UserDefinedType](../-user-defined-type/index.md) (starts at 1) |
| [getRadix](get-radix.md) | [jvm]<br>final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[getRadix](get-radix.md)()<br>Numeric precision radix (typically either 10 or 2) |
| [getRemarks](get-remarks.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getRemarks](get-remarks.md)()<br>Comment describing column |
| [getSchema](get-schema.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getSchema](get-schema.md)()<br>Schema name, from &quot;&quot; column |
| [getScopeCatalog](get-scope-catalog.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getScopeCatalog](get-scope-catalog.md)()<br>Catalog of table that is the scope of a reference attribute (null if [dataType](index.md#-1986249784%2FProperties%2F-1216412040) isn't REF |
| [getScopeSchema](get-scope-schema.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getScopeSchema](get-scope-schema.md)()<br>Scope of table that is the scope of a reference attribute (null if [dataType](index.md#-1986249784%2FProperties%2F-1216412040) isn't REF |
| [getScopeTable](get-scope-table.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getScopeTable](get-scope-table.md)()<br>Table name that is the scope of a reference attribute (null if [dataType](index.md#-1986249784%2FProperties%2F-1216412040) isn't REF |
| [getSourceDataType](get-source-data-type.md) | [jvm]<br>final [JDBCType](https://docs.oracle.com/javase/8/docs/api/java/sql/JDBCType.html)[getSourceDataType](get-source-data-type.md)()<br>Source data type of a distinct type or user-generated REF type, [JDBCType.NULL](https://docs.oracle.com/javase/8/docs/api/java/sql/JDBCType.html#NULL) if [dataType](index.md#-1986249784%2FProperties%2F-1216412040) isn't [JDBCType.DISTINCT](https://docs.oracle.com/javase/8/docs/api/java/sql/JDBCType.html#DISTINCT) or [JDBCType.REF](https://docs.oracle.com/javase/8/docs/api/java/sql/JDBCType.html#REF) |
| [getTypeName](get-type-name.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getTypeName](get-type-name.md)()<br>Type name, from &quot;&quot; column |
| [hashCode](hash-code.md) | [jvm]<br>[Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[hashCode](hash-code.md)() |
| [isNullable](is-nullable.md) | [jvm]<br>final [IsNullable](../-is-nullable/index.md)[isNullable](is-nullable.md)()<br>Is nullable value as string |

## Properties

| Name | Summary |
|---|---|
| [attributeDefault](index.md#-1551597081%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[attributeDefault](index.md#-1551597081%2FProperties%2F-1216412040)<br>Attribute default value |
| [attributeSize](index.md#533313905%2FProperties%2F-1216412040) | [jvm]<br>private final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[attributeSize](index.md#533313905%2FProperties%2F-1216412040)<br>Column size, from &quot;&quot; column |
| [attributeTypeName](index.md#808517261%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[attributeTypeName](index.md#808517261%2FProperties%2F-1216412040)<br>Attribute type name, from &quot;&quot; column |
| [catalog](index.md#586537557%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[catalog](index.md#586537557%2FProperties%2F-1216412040)<br>Catalog name, from &quot;TYPE_CAT&quot; column |
| [characterOctetLength](index.md#1501474208%2FProperties%2F-1216412040) | [jvm]<br>private final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[characterOctetLength](index.md#1501474208%2FProperties%2F-1216412040)<br>For character types this represents the maximum number of bytes in the column |
| [dataType](index.md#-1986249784%2FProperties%2F-1216412040) | [jvm]<br>private final [JDBCType](https://docs.oracle.com/javase/8/docs/api/java/sql/JDBCType.html)[dataType](index.md#-1986249784%2FProperties%2F-1216412040)<br>SQL type, from &quot;&quot; column |
| [decimalDigits](index.md#-2024347689%2FProperties%2F-1216412040) | [jvm]<br>private final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[decimalDigits](index.md#-2024347689%2FProperties%2F-1216412040)<br>The number of fractional digits, null is returned when decimalDigits is not applicable |
| [isNullable](is-nullable.md) | [jvm]<br>private final [IsNullable](../-is-nullable/index.md)[isNullable](is-nullable.md)<br>Is nullable value as string |
| [name](index.md#-1972812639%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[name](index.md#-1972812639%2FProperties%2F-1216412040)<br>Attribute name, from &quot;&quot; column |
| [nullable](index.md#150363403%2FProperties%2F-1216412040) | [jvm]<br>private final [AttributeNullable](../-attribute-nullable/index.md)[nullable](index.md#150363403%2FProperties%2F-1216412040)<br>Indicates whether attribute is nullable |
| [ordinalPosition](index.md#1023633876%2FProperties%2F-1216412040) | [jvm]<br>private final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[ordinalPosition](index.md#1023633876%2FProperties%2F-1216412040)<br>Index of the attribute in the [UserDefinedType](../-user-defined-type/index.md) (starts at 1) |
| [radix](index.md#-1711880950%2FProperties%2F-1216412040) | [jvm]<br>private final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[radix](index.md#-1711880950%2FProperties%2F-1216412040)<br>Numeric precision radix (typically either 10 or 2) |
| [remarks](index.md#1116067515%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[remarks](index.md#1116067515%2FProperties%2F-1216412040)<br>Comment describing column |
| [schema](index.md#1656161931%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[schema](index.md#1656161931%2FProperties%2F-1216412040)<br>Schema name, from &quot;&quot; column |
| [scopeCatalog](index.md#1372294727%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[scopeCatalog](index.md#1372294727%2FProperties%2F-1216412040)<br>Catalog of table that is the scope of a reference attribute (null if [dataType](index.md#-1986249784%2FProperties%2F-1216412040) isn't REF |
| [scopeSchema](index.md#-2059269031%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[scopeSchema](index.md#-2059269031%2FProperties%2F-1216412040)<br>Scope of table that is the scope of a reference attribute (null if [dataType](index.md#-1986249784%2FProperties%2F-1216412040) isn't REF |
| [scopeTable](index.md#-1498014478%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[scopeTable](index.md#-1498014478%2FProperties%2F-1216412040)<br>Table name that is the scope of a reference attribute (null if [dataType](index.md#-1986249784%2FProperties%2F-1216412040) isn't REF |
| [sourceDataType](index.md#-308323411%2FProperties%2F-1216412040) | [jvm]<br>private final [JDBCType](https://docs.oracle.com/javase/8/docs/api/java/sql/JDBCType.html)[sourceDataType](index.md#-308323411%2FProperties%2F-1216412040)<br>Source data type of a distinct type or user-generated REF type, [JDBCType.NULL](https://docs.oracle.com/javase/8/docs/api/java/sql/JDBCType.html#NULL) if [dataType](index.md#-1986249784%2FProperties%2F-1216412040) isn't [JDBCType.DISTINCT](https://docs.oracle.com/javase/8/docs/api/java/sql/JDBCType.html#DISTINCT) or [JDBCType.REF](https://docs.oracle.com/javase/8/docs/api/java/sql/JDBCType.html#REF) |
| [typeName](index.md#-1555937273%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[typeName](index.md#-1555937273%2FProperties%2F-1216412040)<br>Type name, from &quot;&quot; column |
