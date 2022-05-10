//[BetterMetadata](../../../index.md)/[dev.warrengates.bettermetadata](../index.md)/[FunctionColumn](index.md)

# FunctionColumn

[jvm]\
public final class [FunctionColumn](index.md)

Wrapper for results of [getFunctionColumns](https://docs.oracle.com/en/java/javase/17/docs/api/java.sql/java/sql/DatabaseMetaData.html#getFunctionColumns(java.lang.String,java.lang.String,java.lang.String,java.lang.String)) method and represents a column of [Function](../-function/index.md)

## Parameters

jvm

| | |
|---|---|
| rs |  |

## Constructors

| | |
|---|---|
| [FunctionColumn](-function-column.md) | [jvm]<br>[FunctionColumn](index.md)[FunctionColumn](-function-column.md)([ResultSet](https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html)rs) |

## Functions

| Name | Summary |
|---|---|
| [equals](equals.md) | [jvm]<br>[Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[equals](equals.md)([Object](https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html)other) |
| [getCatalog](get-catalog.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getCatalog](get-catalog.md)()<br>Catalog |
| [getCharacterOctetLength](get-character-octet-length.md) | [jvm]<br>final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[getCharacterOctetLength](get-character-octet-length.md)()<br>Character octet length |
| [getColumnType](get-column-type.md) | [jvm]<br>final [FunctionColumnType](../-function-column-type/index.md)[getColumnType](get-column-type.md)()<br>Column type, converted to [FunctionColumnType](../-function-column-type/index.md) |
| [getDataType](get-data-type.md) | [jvm]<br>final [JDBCType](https://docs.oracle.com/javase/8/docs/api/java/sql/JDBCType.html)[getDataType](get-data-type.md)()<br>SQL type from [java.sql.Types](https://docs.oracle.com/javase/8/docs/api/java/sql/Types.html), converted from int |
| [getFunctionName](get-function-name.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getFunctionName](get-function-name.md)()<br>Function name |
| [getLength](get-length.md) | [jvm]<br>final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[getLength](get-length.md)()<br>Length |
| [getName](get-name.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getName](get-name.md)()<br>Name |
| [getNullable](get-nullable.md) | [jvm]<br>final [FunctionColumnNullable](../-function-column-nullable/index.md)[getNullable](get-nullable.md)()<br>Nullable, converted to [FunctionColumnNullable](../-function-column-nullable/index.md) |
| [getOrdinalPosition](get-ordinal-position.md) | [jvm]<br>final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[getOrdinalPosition](get-ordinal-position.md)()<br>Ordinal position |
| [getPrecision](get-precision.md) | [jvm]<br>final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[getPrecision](get-precision.md)()<br>Precision |
| [getRadix](get-radix.md) | [jvm]<br>final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[getRadix](get-radix.md)()<br>Radix |
| [getRemarks](get-remarks.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getRemarks](get-remarks.md)()<br>Remarks |
| [getScale](get-scale.md) | [jvm]<br>final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[getScale](get-scale.md)()<br>Scale |
| [getSchema](get-schema.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getSchema](get-schema.md)()<br>Schema |
| [getSpecificName](get-specific-name.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getSpecificName](get-specific-name.md)()<br>Specific name |
| [getTypeName](get-type-name.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getTypeName](get-type-name.md)()<br>Type name |
| [hashCode](hash-code.md) | [jvm]<br>[Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[hashCode](hash-code.md)() |
| [isNullable](is-nullable.md) | [jvm]<br>final [IsNullable](../-is-nullable/index.md)[isNullable](is-nullable.md)()<br>Is nullable, converted to [IsNullable](../-is-nullable/index.md) |

## Properties

| Name | Summary |
|---|---|
| [catalog](index.md#2048752039%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[catalog](index.md#2048752039%2FProperties%2F-1216412040)<br>Catalog |
| [characterOctetLength](index.md#855376782%2FProperties%2F-1216412040) | [jvm]<br>private final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[characterOctetLength](index.md#855376782%2FProperties%2F-1216412040)<br>Character octet length |
| [columnType](index.md#-1178359990%2FProperties%2F-1216412040) | [jvm]<br>private final [FunctionColumnType](../-function-column-type/index.md)[columnType](index.md#-1178359990%2FProperties%2F-1216412040)<br>Column type, converted to [FunctionColumnType](../-function-column-type/index.md) |
| [dataType](index.md#392726198%2FProperties%2F-1216412040) | [jvm]<br>private final [JDBCType](https://docs.oracle.com/javase/8/docs/api/java/sql/JDBCType.html)[dataType](index.md#392726198%2FProperties%2F-1216412040)<br>SQL type from [java.sql.Types](https://docs.oracle.com/javase/8/docs/api/java/sql/Types.html), converted from int |
| [functionName](index.md#-1137601385%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[functionName](index.md#-1137601385%2FProperties%2F-1216412040)<br>Function name |
| [isNullable](is-nullable.md) | [jvm]<br>private final [IsNullable](../-is-nullable/index.md)[isNullable](is-nullable.md)<br>Is nullable, converted to [IsNullable](../-is-nullable/index.md) |
| [length](index.md#-2047133868%2FProperties%2F-1216412040) | [jvm]<br>private final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[length](index.md#-2047133868%2FProperties%2F-1216412040)<br>Length |
| [name](index.md#-537119089%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[name](index.md#-537119089%2FProperties%2F-1216412040)<br>Name |
| [nullable](index.md#-1765627911%2FProperties%2F-1216412040) | [jvm]<br>private final [FunctionColumnNullable](../-function-column-nullable/index.md)[nullable](index.md#-1765627911%2FProperties%2F-1216412040)<br>Nullable, converted to [FunctionColumnNullable](../-function-column-nullable/index.md) |
| [ordinalPosition](index.md#2080872230%2FProperties%2F-1216412040) | [jvm]<br>private final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[ordinalPosition](index.md#2080872230%2FProperties%2F-1216412040)<br>Ordinal position |
| [precision](index.md#1330742306%2FProperties%2F-1216412040) | [jvm]<br>private final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[precision](index.md#1330742306%2FProperties%2F-1216412040)<br>Precision |
| [radix](index.md#-155053860%2FProperties%2F-1216412040) | [jvm]<br>private final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[radix](index.md#-155053860%2FProperties%2F-1216412040)<br>Radix |
| [remarks](index.md#-1716685299%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[remarks](index.md#-1716685299%2FProperties%2F-1216412040)<br>Remarks |
| [scale](index.md#7173718%2FProperties%2F-1216412040) | [jvm]<br>private final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[scale](index.md#7173718%2FProperties%2F-1216412040)<br>Scale |
| [schema](index.md#-1621805831%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[schema](index.md#-1621805831%2FProperties%2F-1216412040)<br>Schema |
| [specificName](index.md#1395037565%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[specificName](index.md#1395037565%2FProperties%2F-1216412040)<br>Specific name |
| [typeName](index.md#823038709%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[typeName](index.md#823038709%2FProperties%2F-1216412040)<br>Type name |
