//[BetterMetadata](../../../index.md)/[dev.warrengates.bettermetadata](../index.md)/[TablePrivilege](index.md)

# TablePrivilege

[jvm]\
public final class [TablePrivilege](index.md)

Wrapper for results of [getTablePrivileges](https://docs.oracle.com/en/java/javase/17/docs/api/java.sql/java/sql/DatabaseMetaData.html#getTablePrivileges(java.lang.String,java.lang.String,java.lang.String))

## Constructors

| | |
|---|---|
| [TablePrivilege](-table-privilege.md) | [jvm]<br>[TablePrivilege](index.md)[TablePrivilege](-table-privilege.md)([ResultSet](https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html)rs) |

## Functions

| Name | Summary |
|---|---|
| [equals](equals.md) | [jvm]<br>[Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[equals](equals.md)([Object](https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html)other) |
| [getCatalog](get-catalog.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getCatalog](get-catalog.md)()<br>Catalog |
| [getGrantee](get-grantee.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getGrantee](get-grantee.md)()<br>Grantee |
| [getGrantor](get-grantor.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getGrantor](get-grantor.md)()<br>Grantor |
| [getName](get-name.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getName](get-name.md)()<br>Name |
| [getPrivilege](get-privilege.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getPrivilege](get-privilege.md)()<br>Privilege |
| [getSchema](get-schema.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getSchema](get-schema.md)()<br>Schema |
| [hashCode](hash-code.md) | [jvm]<br>[Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[hashCode](hash-code.md)() |
| [isGrantable](is-grantable.md) | [jvm]<br>final [IsGrantable](../-is-grantable/index.md)[isGrantable](is-grantable.md)()<br>Is grantable, converted to [IsGrantable](../-is-grantable/index.md) |

## Properties

| Name | Summary |
|---|---|
| [catalog](index.md#-1091968238%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[catalog](index.md#-1091968238%2FProperties%2F-1216412040)<br>Catalog |
| [grantee](index.md#-1794573873%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[grantee](index.md#-1794573873%2FProperties%2F-1216412040)<br>Grantee |
| [grantor](index.md#-365110804%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[grantor](index.md#-365110804%2FProperties%2F-1216412040)<br>Grantor |
| [isGrantable](is-grantable.md) | [jvm]<br>private final [IsGrantable](../-is-grantable/index.md)[isGrantable](is-grantable.md)<br>Is grantable, converted to [IsGrantable](../-is-grantable/index.md) |
| [name](index.md#859782404%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[name](index.md#859782404%2FProperties%2F-1216412040)<br>Name |
| [privilege](index.md#-2129572870%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[privilege](index.md#-2129572870%2FProperties%2F-1216412040)<br>Privilege |
| [schema](index.md#770732590%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[schema](index.md#770732590%2FProperties%2F-1216412040)<br>Schema |
