//[BetterMetadata](../../../index.md)/[dev.warrengates.bettermetadata](../index.md)/[Database](index.md)/[getUserDefinedTypes](get-user-defined-types.md)

# getUserDefinedTypes

[jvm]\

@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()

final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[UserDefinedType](../-user-defined-type/index.md)&gt;[getUserDefinedTypes](get-user-defined-types.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)namePattern, [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)&lt;[JDBCType](https://docs.oracle.com/javase/8/docs/api/java/sql/JDBCType.html)&gt;types)

@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()

final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[UserDefinedType](../-user-defined-type/index.md)&gt;[getUserDefinedTypes](get-user-defined-types.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)namePattern)

@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()

final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[UserDefinedType](../-user-defined-type/index.md)&gt;[getUserDefinedTypes](get-user-defined-types.md)()

Get user defined types based on specified [namePattern](get-user-defined-types.md) and [types](get-user-defined-types.md) as well as [defaultCatalog](index.md#-1554206577%2FProperties%2F-1216412040) and [defaultSchema](index.md#2002747665%2FProperties%2F-1216412040)

#### Return

## Parameters

jvm

| | |
|---|---|
| namePattern |  |
| types |  |

[jvm]\

final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[UserDefinedType](../-user-defined-type/index.md)&gt;[getUserDefinedTypes](get-user-defined-types.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)catalog, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)schemaPattern, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)namePattern, [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)&lt;[JDBCType](https://docs.oracle.com/javase/8/docs/api/java/sql/JDBCType.html)&gt;types)

Get user defined types. If not specified, [catalog](get-user-defined-types.md) defaults to [defaultCatalog](index.md#-1554206577%2FProperties%2F-1216412040) and [schemaPattern](get-user-defined-types.md) defaults to [defaultSchema](index.md#2002747665%2FProperties%2F-1216412040)

#### Return

## Parameters

jvm

| | |
|---|---|
| catalog |  |
| schemaPattern |  |
| namePattern |  |
| types |  |
