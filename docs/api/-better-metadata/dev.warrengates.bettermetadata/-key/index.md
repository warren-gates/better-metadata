//[BetterMetadata](../../../index.md)/[dev.warrengates.bettermetadata](../index.md)/[Key](index.md)

# Key

[jvm]\
public final class [Key](index.md)

Key

## Constructors

| | |
|---|---|
| [Key](-key.md) | [jvm]<br>[Key](index.md)[Key](-key.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)primaryKeyName, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)foreignKeyName, [ForeignKeyUpdateRule](../-foreign-key-update-rule/index.md)updateRule, [ForeignKeyDeleteRule](../-foreign-key-delete-rule/index.md)deleteRule, [ForeignKeyInitialDeferrability](../-foreign-key-initial-deferrability/index.md)deferrability, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[KeyColumn](../-key-column/index.md)&gt;keyColumns)<br>Create empty Key |

## Functions

| Name | Summary |
|---|---|
| [equals](equals.md) | [jvm]<br>[Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[equals](equals.md)([Object](https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html)other) |
| [getDeferrability](get-deferrability.md) | [jvm]<br>final [ForeignKeyInitialDeferrability](../-foreign-key-initial-deferrability/index.md)[getDeferrability](get-deferrability.md)()<br>Deferrability, converted to [ForeignKeyInitialDeferrability](../-foreign-key-initial-deferrability/index.md) |
| [getDeleteRule](get-delete-rule.md) | [jvm]<br>final [ForeignKeyDeleteRule](../-foreign-key-delete-rule/index.md)[getDeleteRule](get-delete-rule.md)()<br>Delete rule, converted to [ForeignKeyDeleteRule](../-foreign-key-delete-rule/index.md) |
| [getForeignKeyName](get-foreign-key-name.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getForeignKeyName](get-foreign-key-name.md)()<br>Foreign key name |
| [getKeyColumns](get-key-columns.md) | [jvm]<br>final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[KeyColumn](../-key-column/index.md)&gt;[getKeyColumns](get-key-columns.md)()<br>List of [KeyColumn](../-key-column/index.md)s making up this key |
| [getPrimaryKeyName](get-primary-key-name.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getPrimaryKeyName](get-primary-key-name.md)()<br>Primary key name |
| [getUpdateRule](get-update-rule.md) | [jvm]<br>final [ForeignKeyUpdateRule](../-foreign-key-update-rule/index.md)[getUpdateRule](get-update-rule.md)()<br>Update rule, converted to [ForeignKeyUpdateRule](../-foreign-key-update-rule/index.md) |
| [hashCode](hash-code.md) | [jvm]<br>[Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[hashCode](hash-code.md)() |

## Properties

| Name | Summary |
|---|---|
| [deferrability](index.md#14172737%2FProperties%2F-1216412040) | [jvm]<br>private final [ForeignKeyInitialDeferrability](../-foreign-key-initial-deferrability/index.md)[deferrability](index.md#14172737%2FProperties%2F-1216412040)<br>Deferrability, converted to [ForeignKeyInitialDeferrability](../-foreign-key-initial-deferrability/index.md) |
| [deleteRule](index.md#1684522984%2FProperties%2F-1216412040) | [jvm]<br>private final [ForeignKeyDeleteRule](../-foreign-key-delete-rule/index.md)[deleteRule](index.md#1684522984%2FProperties%2F-1216412040)<br>Delete rule, converted to [ForeignKeyDeleteRule](../-foreign-key-delete-rule/index.md) |
| [foreignKeyName](index.md#1556701945%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[foreignKeyName](index.md#1556701945%2FProperties%2F-1216412040)<br>Foreign key name |
| [keyColumns](index.md#-906588527%2FProperties%2F-1216412040) | [jvm]<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[KeyColumn](../-key-column/index.md)&gt;[keyColumns](index.md#-906588527%2FProperties%2F-1216412040)<br>List of [KeyColumn](../-key-column/index.md)s making up this key |
| [primaryKeyName](index.md#498776103%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[primaryKeyName](index.md#498776103%2FProperties%2F-1216412040)<br>Primary key name |
| [updateRule](index.md#-911535734%2FProperties%2F-1216412040) | [jvm]<br>private final [ForeignKeyUpdateRule](../-foreign-key-update-rule/index.md)[updateRule](index.md#-911535734%2FProperties%2F-1216412040)<br>Update rule, converted to [ForeignKeyUpdateRule](../-foreign-key-update-rule/index.md) |
