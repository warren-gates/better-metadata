//[BetterMetadata](../../../index.md)/[dev.warrengates.bettermetadata](../index.md)/[HelpersKt](index.md)/[getIterableFromRs](get-iterable-from-rs.md)

# getIterableFromRs

[jvm]\

final static [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;T&gt;[getIterableFromRs](get-iterable-from-rs.md)&lt;T extends [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt;([ResultSet](https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html)rs, Function1&lt;[ResultSet](https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html), T&gt;creator)

Get iterable from rs

#### Receiver

#### Return

## Parameters

jvm

| | |
|---|---|
| T |  |
| rs |  |
| creator |  |

[jvm]\

final static [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;T&gt;[getIterableFromRs](get-iterable-from-rs.md)&lt;T extends [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt;([DatabaseMetaData](https://docs.oracle.com/javase/8/docs/api/java/sql/DatabaseMetaData.html)metaData, [ResultSet](https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html)rs, Function2&lt;[DatabaseMetaData](https://docs.oracle.com/javase/8/docs/api/java/sql/DatabaseMetaData.html), [ResultSet](https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html), T&gt;creator)

Get iterable from rs

#### Receiver

#### Return

## Parameters

jvm

| | |
|---|---|
| T |  |
| metaData |  |
| rs |  |
| creator |  |
