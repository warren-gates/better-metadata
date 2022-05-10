//[BetterMetadata](../../../index.md)/[dev.warrengates.bettermetadata](../index.md)/[Database](index.md)/[getTables](get-tables.md)

# getTables

[jvm]\

@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()

final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Table](../-table/index.md)&gt;[getTables](get-tables.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)tableNamePattern, [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;types)

@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()

final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Table](../-table/index.md)&gt;[getTables](get-tables.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)tableNamePattern)

@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()

final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Table](../-table/index.md)&gt;[getTables](get-tables.md)()

Get tables with specified [tableNamePattern](get-tables.md) and [types](get-tables.md), as well as [defaultCatalog](index.md#-1554206577%2FProperties%2F-1216412040) and [defaultSchema](index.md#2002747665%2FProperties%2F-1216412040)

## Parameters

jvm

| | |
|---|---|
| tableNamePattern |  |
| types |  |

[jvm]\

final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Table](../-table/index.md)&gt;[getTables](get-tables.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)catalog, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)schemaPattern, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)tableNamePattern, [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;types)

Get tables. If not specified, [catalog](get-tables.md) defaults to [defaultCatalog](index.md#-1554206577%2FProperties%2F-1216412040) and [schemaPattern](get-tables.md) defaults to [defaultSchema](index.md#2002747665%2FProperties%2F-1216412040)

#### Return

## Parameters

jvm

| | |
|---|---|
| catalog |  |
| schemaPattern |  |
| tableNamePattern |  |
| types |  |
