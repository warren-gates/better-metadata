//[BetterMetadata](../../../index.md)/[dev.warrengates.bettermetadata](../index.md)/[Database](index.md)/[getFunctions](get-functions.md)

# getFunctions

[jvm]\

@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()

final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Function](../-function/index.md)&gt;[getFunctions](get-functions.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)namePattern)

@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()

final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Function](../-function/index.md)&gt;[getFunctions](get-functions.md)()

Gets functions using specified [namePattern](get-functions.md) along with [defaultCatalog](index.md#-1554206577%2FProperties%2F-1216412040) and [defaultCatalog](index.md#-1554206577%2FProperties%2F-1216412040) to filter results.

#### Return

## Parameters

jvm

| | |
|---|---|
| namePattern |  |

[jvm]\

final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Function](../-function/index.md)&gt;[getFunctions](get-functions.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)catalog, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)schemaPattern, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)namePattern)

Gets functions using the [catalog](get-functions.md), [schemaPattern](get-functions.md), and [namePattern](get-functions.md) to filter results. If not specified, [catalog](get-functions.md) defaults to [defaultCatalog](index.md#-1554206577%2FProperties%2F-1216412040) and [schemaPattern](get-functions.md) defaults to [defaultSchema](index.md#2002747665%2FProperties%2F-1216412040)

#### Return

List<[Function](../-function/index.md)>

## Parameters

jvm

| | |
|---|---|
| catalog |  |
| schemaPattern |  |
| namePattern |  |
