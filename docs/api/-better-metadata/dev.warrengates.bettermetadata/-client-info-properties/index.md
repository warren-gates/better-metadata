//[BetterMetadata](../../../index.md)/[dev.warrengates.bettermetadata](../index.md)/[ClientInfoProperties](index.md)

# ClientInfoProperties

[jvm]\
public final class [ClientInfoProperties](index.md)

Wrapper for results of [getClientInfoProperties](https://docs.oracle.com/en/java/javase/17/docs/api/java.sql/java/sql/DatabaseMetaData.html#getClientInfoProperties()) method and represents a list of the client info properties supported by the current driver

## Parameters

jvm

| | |
|---|---|
| rs |  |

## Constructors

| | |
|---|---|
| [ClientInfoProperties](-client-info-properties.md) | [jvm]<br>[ClientInfoProperties](index.md)[ClientInfoProperties](-client-info-properties.md)([ResultSet](https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html)rs) |

## Functions

| Name | Summary |
|---|---|
| [equals](equals.md) | [jvm]<br>[Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[equals](equals.md)([Object](https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html)other) |
| [getDefaultValue](get-default-value.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getDefaultValue](get-default-value.md)()<br>Default value of property |
| [getDescription](get-description.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getDescription](get-description.md)()<br>Description of property. Will typically contain information as to where this property is stored in the database |
| [getMaxLength](get-max-length.md) | [jvm]<br>final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[getMaxLength](get-max-length.md)()<br>Maximum length of the value for the property |
| [getName](get-name.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getName](get-name.md)()<br>Name of client info property |
| [hashCode](hash-code.md) | [jvm]<br>[Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[hashCode](hash-code.md)() |

## Properties

| Name | Summary |
|---|---|
| [defaultValue](index.md#-540521752%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[defaultValue](index.md#-540521752%2FProperties%2F-1216412040)<br>Default value of property |
| [description](index.md#-1726537978%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[description](index.md#-1726537978%2FProperties%2F-1216412040)<br>Description of property. Will typically contain information as to where this property is stored in the database |
| [maxLength](index.md#-1243548008%2FProperties%2F-1216412040) | [jvm]<br>private final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[maxLength](index.md#-1243548008%2FProperties%2F-1216412040)<br>Maximum length of the value for the property |
| [name](index.md#555303789%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[name](index.md#555303789%2FProperties%2F-1216412040)<br>Name of client info property |
