//[BetterMetadata](../../../index.md)/[dev.warrengates.bettermetadata](../index.md)/[ProcedureColumn](index.md)

# ProcedureColumn

[jvm]\
public final class [ProcedureColumn](index.md)

Wrapper for results of [getProcedureColumns](https://docs.oracle.com/en/java/javase/17/docs/api/java.sql/java/sql/DatabaseMetaData.html#getProcedureColumns(java.lang.String,java.lang.String,java.lang.String,java.lang.String))

Note that per the documentation SQL_DATA_TYPE and SQL_DATETIME_SUB are reserved for future use and have been left out of this class

## Parameters

jvm

| | |
|---|---|
| rs |  |

## Constructors

| | |
|---|---|
| [ProcedureColumn](-procedure-column.md) | [jvm]<br>[ProcedureColumn](index.md)[ProcedureColumn](-procedure-column.md)([ResultSet](https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html)rs) |

## Functions

| Name | Summary |
|---|---|
| [equals](equals.md) | [jvm]<br>[Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[equals](equals.md)([Object](https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html)other) |
| [getCatalog](get-catalog.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getCatalog](get-catalog.md)()<br>Catalog |
| [getCharacterOctetLength](get-character-octet-length.md) | [jvm]<br>final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[getCharacterOctetLength](get-character-octet-length.md)()<br>Character octet length |
| [getColumnDefault](get-column-default.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getColumnDefault](get-column-default.md)()<br>Column default |
| [getColumnType](get-column-type.md) | [jvm]<br>final [ProcedureColumnType](../-procedure-column-type/index.md)[getColumnType](get-column-type.md)()<br>Column type, converted to [ProcedureColumnType](../-procedure-column-type/index.md) |
| [getDataType](get-data-type.md) | [jvm]<br>final [JDBCType](https://docs.oracle.com/javase/8/docs/api/java/sql/JDBCType.html)[getDataType](get-data-type.md)()<br>SQL type, converted to [JDBCType](https://docs.oracle.com/javase/8/docs/api/java/sql/JDBCType.html) |
| [getLength](get-length.md) | [jvm]<br>final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[getLength](get-length.md)()<br>Length |
| [getName](get-name.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getName](get-name.md)()<br>Name |
| [getNullable](get-nullable.md) | [jvm]<br>final [ProcedureColumnNullable](../-procedure-column-nullable/index.md)[getNullable](get-nullable.md)()<br>Nullable, converted to [ProcedureColumnNullable](../-procedure-column-nullable/index.md) |
| [getOrdinalPosition](get-ordinal-position.md) | [jvm]<br>final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[getOrdinalPosition](get-ordinal-position.md)()<br>Ordinal position |
| [getPrecision](get-precision.md) | [jvm]<br>final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[getPrecision](get-precision.md)()<br>Precision |
| [getProcedureName](get-procedure-name.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getProcedureName](get-procedure-name.md)()<br>Procedure name |
| [getRadix](get-radix.md) | [jvm]<br>final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[getRadix](get-radix.md)()<br>Radix, converted to Int for consistency |
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
| [catalog](index.md#352385032%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[catalog](index.md#352385032%2FProperties%2F-1216412040)<br>Catalog |
| [characterOctetLength](index.md#1597942477%2FProperties%2F-1216412040) | [jvm]<br>private final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[characterOctetLength](index.md#1597942477%2FProperties%2F-1216412040)<br>Character octet length |
| [columnDefault](index.md#940931926%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[columnDefault](index.md#940931926%2FProperties%2F-1216412040)<br>Column default |
| [columnType](index.md#1232306505%2FProperties%2F-1216412040) | [jvm]<br>private final [ProcedureColumnType](../-procedure-column-type/index.md)[columnType](index.md#1232306505%2FProperties%2F-1216412040)<br>Column type, converted to [ProcedureColumnType](../-procedure-column-type/index.md) |
| [dataType](index.md#-655043467%2FProperties%2F-1216412040) | [jvm]<br>private final [JDBCType](https://docs.oracle.com/javase/8/docs/api/java/sql/JDBCType.html)[dataType](index.md#-655043467%2FProperties%2F-1216412040)<br>SQL type, converted to [JDBCType](https://docs.oracle.com/javase/8/docs/api/java/sql/JDBCType.html) |
| [isNullable](is-nullable.md) | [jvm]<br>private final [IsNullable](../-is-nullable/index.md)[isNullable](is-nullable.md)<br>Is nullable, converted to [IsNullable](../-is-nullable/index.md) |
| [length](index.md#1500375251%2FProperties%2F-1216412040) | [jvm]<br>private final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[length](index.md#1500375251%2FProperties%2F-1216412040)<br>Length |
| [name](index.md#-14992434%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[name](index.md#-14992434%2FProperties%2F-1216412040)<br>Name |
| [nullable](index.md#1481569720%2FProperties%2F-1216412040) | [jvm]<br>private final [ProcedureColumnNullable](../-procedure-column-nullable/index.md)[nullable](index.md#1481569720%2FProperties%2F-1216412040)<br>Nullable, converted to [ProcedureColumnNullable](../-procedure-column-nullable/index.md) |
| [ordinalPosition](index.md#1618683015%2FProperties%2F-1216412040) | [jvm]<br>private final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[ordinalPosition](index.md#1618683015%2FProperties%2F-1216412040)<br>Ordinal position |
| [precision](index.md#-1085346237%2FProperties%2F-1216412040) | [jvm]<br>private final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[precision](index.md#-1085346237%2FProperties%2F-1216412040)<br>Precision |
| [procedureName](index.md#252182723%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[procedureName](index.md#252182723%2FProperties%2F-1216412040)<br>Procedure name |
| [radix](index.md#-1148996739%2FProperties%2F-1216412040) | [jvm]<br>private final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[radix](index.md#-1148996739%2FProperties%2F-1216412040)<br>Radix, converted to Int for consistency |
| [remarks](index.md#881914990%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[remarks](index.md#881914990%2FProperties%2F-1216412040)<br>Remarks |
| [scale](index.md#-986769161%2FProperties%2F-1216412040) | [jvm]<br>private final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[scale](index.md#-986769161%2FProperties%2F-1216412040)<br>Scale |
| [schema](index.md#1925703288%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[schema](index.md#1925703288%2FProperties%2F-1216412040)<br>Schema |
| [specificName](index.md#-1236800580%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[specificName](index.md#-1236800580%2FProperties%2F-1216412040)<br>Specific name |
| [typeName](index.md#-224730956%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[typeName](index.md#-224730956%2FProperties%2F-1216412040)<br>Type name |
