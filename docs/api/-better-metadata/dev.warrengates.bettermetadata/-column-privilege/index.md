//[BetterMetadata](../../../index.md)/[dev.warrengates.bettermetadata](../index.md)/[ColumnPrivilege](index.md)

# ColumnPrivilege

[jvm]\
public final class [ColumnPrivilege](index.md)

Wrapper for results of [getColumnPrivileges](https://docs.oracle.com/en/java/javase/17/docs/api/java.sql/java/sql/DatabaseMetaData.html#getColumns(java.lang.String,java.lang.String,java.lang.String,java.lang.String)) method. Used from [Column.getColumnPrivileges](../-column/get-column-privileges.md)

## Parameters

jvm

| | |
|---|---|
| rs |  |

## Constructors

| | |
|---|---|
| [ColumnPrivilege](-column-privilege.md) | [jvm]<br>[ColumnPrivilege](index.md)[ColumnPrivilege](-column-privilege.md)([ResultSet](https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html)rs) |

## Functions

| Name | Summary |
|---|---|
| [equals](equals.md) | [jvm]<br>[Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[equals](equals.md)([Object](https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html)other) |
| [getCatalog](get-catalog.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getCatalog](get-catalog.md)()<br>Catalog |
| [getColumnName](get-column-name.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getColumnName](get-column-name.md)()<br>Column name |
| [getGrantee](get-grantee.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getGrantee](get-grantee.md)()<br>Grantee |
| [getGrantor](get-grantor.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getGrantor](get-grantor.md)()<br>Grantor |
| [getPrivilege](get-privilege.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getPrivilege](get-privilege.md)()<br>Privilege |
| [getSchema](get-schema.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getSchema](get-schema.md)()<br>Schema |
| [getTableName](get-table-name.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getTableName](get-table-name.md)()<br>Table name |
| [hashCode](hash-code.md) | [jvm]<br>[Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[hashCode](hash-code.md)() |
| [isGrantable](is-grantable.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[isGrantable](is-grantable.md)()<br>Is grantable, converted to [IsGrantable](../-is-grantable/index.md) |

## Properties

| Name | Summary |
|---|---|
| [catalog](index.md#-1089228202%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[catalog](index.md#-1089228202%2FProperties%2F-1216412040)<br>Catalog |
| [columnName](index.md#-1419330038%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[columnName](index.md#-1419330038%2FProperties%2F-1216412040)<br>Column name |
| [grantee](index.md#-1791833837%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[grantee](index.md#-1791833837%2FProperties%2F-1216412040)<br>Grantee |
| [grantor](index.md#-362370768%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[grantor](index.md#-362370768%2FProperties%2F-1216412040)<br>Grantor |
| [isGrantable](is-grantable.md) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[isGrantable](is-grantable.md)<br>Is grantable, converted to [IsGrantable](../-is-grantable/index.md) |
| [privilege](index.md#503601726%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[privilege](index.md#503601726%2FProperties%2F-1216412040)<br>Privilege |
| [schema](index.md#493726314%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[schema](index.md#493726314%2FProperties%2F-1216412040)<br>Schema |
| [tableName](index.md#-413585802%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[tableName](index.md#-413585802%2FProperties%2F-1216412040)<br>Table name |
