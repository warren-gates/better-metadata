//[BetterMetadata](../../../index.md)/[dev.warrengates.bettermetadata](../index.md)/[Database](index.md)/[getProcedures](get-procedures.md)

# getProcedures

[jvm]\

@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()

final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Procedure](../-procedure/index.md)&gt;[getProcedures](get-procedures.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)namePattern)

@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()

final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Procedure](../-procedure/index.md)&gt;[getProcedures](get-procedures.md)()

Get procedures based on specified [namePattern](get-procedures.md) as well as [defaultCatalog](index.md#-1554206577%2FProperties%2F-1216412040) and [defaultSchema](index.md#2002747665%2FProperties%2F-1216412040)

#### Return

## Parameters

jvm

| | |
|---|---|
| namePattern |  |

[jvm]\

final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Procedure](../-procedure/index.md)&gt;[getProcedures](get-procedures.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)catalog, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)schemaPattern, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)namePattern)

Get procedures. If not specified, [catalog](get-procedures.md) defaults to [defaultCatalog](index.md#-1554206577%2FProperties%2F-1216412040) and [schemaPattern](get-procedures.md) defaults to [defaultSchema](index.md#2002747665%2FProperties%2F-1216412040)

#### Return

## Parameters

jvm

| | |
|---|---|
| catalog |  |
| schemaPattern |  |
| namePattern |  |
