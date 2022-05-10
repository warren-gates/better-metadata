//[BetterMetadata](../../../index.md)/[dev.warrengates.bettermetadata](../index.md)/[Procedure](index.md)

# Procedure

[jvm]\
public final class [Procedure](index.md)

Wrapper around the [getProcedures](https://docs.oracle.com/en/java/javase/17/docs/api/java.sql/java/sql/DatabaseMetaData.html#getProcedures(java.lang.String,java.lang.String,java.lang.String)) method and represents a stored procedure

## Constructors

| | |
|---|---|
| [Procedure](-procedure.md) | [jvm]<br>[Procedure](index.md)[Procedure](-procedure.md)([DatabaseMetaData](https://docs.oracle.com/javase/8/docs/api/java/sql/DatabaseMetaData.html)metadata, [ResultSet](https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html)rs) |

## Functions

| Name | Summary |
|---|---|
| [equals](equals.md) | [jvm]<br>[Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[equals](equals.md)([Object](https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html)other) |
| [getCatalog](get-catalog.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getCatalog](get-catalog.md)()<br>Catalog |
| [getName](get-name.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getName](get-name.md)()<br>Name |
| [getProcedureColumns](get-procedure-columns.md) | [jvm]<br>@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()<br>final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[ProcedureColumn](../-procedure-column/index.md)&gt;[getProcedureColumns](get-procedure-columns.md)()<br>@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()<br>final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[ProcedureColumn](../-procedure-column/index.md)&gt;[getProcedureColumns](get-procedure-columns.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)columnNamePattern)<br>Wrapper around [getProcedureColumns](https://docs.oracle.com/en/java/javase/17/docs/api/java.sql/java/sql/DatabaseMetaData.html#getProcedureColumns(java.lang.String,java.lang.String,java.lang.String,java.lang.String)) and returns a list of [ProcedureColumn](../-procedure-column/index.md)s for this procedure only |
| [getRemarks](get-remarks.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getRemarks](get-remarks.md)()<br>Remarks |
| [getReturnType](get-return-type.md) | [jvm]<br>final [ProcedureReturnType](../-procedure-return-type/index.md)[getReturnType](get-return-type.md)()<br>Return type, converted to [ProcedureReturnType](../-procedure-return-type/index.md) |
| [getSchema](get-schema.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getSchema](get-schema.md)()<br>Schema |
| [getSpecificName](get-specific-name.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getSpecificName](get-specific-name.md)()<br>Specific name |
| [hashCode](hash-code.md) | [jvm]<br>[Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[hashCode](hash-code.md)() |

## Properties

| Name | Summary |
|---|---|
| [catalog](index.md#-766302978%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[catalog](index.md#-766302978%2FProperties%2F-1216412040)<br>Catalog |
| [name](index.md#726868632%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[name](index.md#726868632%2FProperties%2F-1216412040)<br>Name |
| [remarks](index.md#-236773020%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[remarks](index.md#-236773020%2FProperties%2F-1216412040)<br>Remarks |
| [returnType](index.md#-1039072007%2FProperties%2F-1216412040) | [jvm]<br>private final [ProcedureReturnType](../-procedure-return-type/index.md)[returnType](index.md#-1039072007%2FProperties%2F-1216412040)<br>Return type, converted to [ProcedureReturnType](../-procedure-return-type/index.md) |
| [schema](index.md#1889616578%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[schema](index.md#1889616578%2FProperties%2F-1216412040)<br>Schema |
| [specificName](index.md#892954758%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[specificName](index.md#892954758%2FProperties%2F-1216412040)<br>Specific name |
