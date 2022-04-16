//[BetterMetadata](../../../index.md)/[dev.warrengates.bettermetadata](../index.md)/[Procedure](index.md)

# Procedure

[jvm]\
public final class [Procedure](index.md)

Procedure

## Parameters

jvm

| | |
|---|---|
| rs |  |

## Constructors

| | |
|---|---|
| [Procedure](-procedure.md) | [jvm]<br>[Procedure](index.md)[Procedure](-procedure.md)([DatabaseMetaData](https://docs.oracle.com/javase/8/docs/api/java/sql/DatabaseMetaData.html)metadata, [ResultSet](https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html)rs) |

## Functions

| Name | Summary |
|---|---|
| [getCatalog](get-catalog.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getCatalog](get-catalog.md)()<br>Catalog |
| [getName](get-name.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getName](get-name.md)()<br>Name |
| [getProcedureColumns](get-procedure-columns.md) | [jvm]<br>final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[ProcedureColumn](../-procedure-column/index.md)&gt;[getProcedureColumns](get-procedure-columns.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)columnNamePattern)<br>Get procedure columns |
| [getRemarks](get-remarks.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getRemarks](get-remarks.md)()<br>Remarks |
| [getReturnType](get-return-type.md) | [jvm]<br>final [ProcedureReturnType](../-procedure-return-type/index.md)[getReturnType](get-return-type.md)()<br>Return type |
| [getSchema](get-schema.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getSchema](get-schema.md)()<br>Schema |
| [getSpecificName](get-specific-name.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getSpecificName](get-specific-name.md)()<br>Specific name |

## Properties

| Name | Summary |
|---|---|
| [catalog](index.md#-766302978%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[catalog](index.md#-766302978%2FProperties%2F-1216412040)<br>Catalog |
| [name](index.md#726868632%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[name](index.md#726868632%2FProperties%2F-1216412040)<br>Name |
| [remarks](index.md#-236773020%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[remarks](index.md#-236773020%2FProperties%2F-1216412040)<br>Remarks |
| [returnType](index.md#-1039072007%2FProperties%2F-1216412040) | [jvm]<br>private final [ProcedureReturnType](../-procedure-return-type/index.md)[returnType](index.md#-1039072007%2FProperties%2F-1216412040)<br>Return type |
| [schema](index.md#1889616578%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[schema](index.md#1889616578%2FProperties%2F-1216412040)<br>Schema |
| [specificName](index.md#892954758%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[specificName](index.md#892954758%2FProperties%2F-1216412040)<br>Specific name |
