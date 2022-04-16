//[BetterMetadata](../../../index.md)/[dev.warrengates.bettermetadata](../index.md)/[Column](index.md)

# Column

[jvm]\
public final class [Column](index.md)

Column represents a [Table](../-table/index.md) column

## Parameters

jvm

| | |
|---|---|
| rs |  |

## Constructors

| | |
|---|---|
| [Column](-column.md) | [jvm]<br>[Column](index.md)[Column](-column.md)([DatabaseMetaData](https://docs.oracle.com/javase/8/docs/api/java/sql/DatabaseMetaData.html)metadata, [ResultSet](https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html)rs) |

## Functions

| Name | Summary |
|---|---|
| [getCatalog](get-catalog.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getCatalog](get-catalog.md)()<br>Containing Table's catalog |
| [getCharacterOctetLength](get-character-octet-length.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getCharacterOctetLength](get-character-octet-length.md)()<br>Character octet length |
| [getColumnDefault](get-column-default.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getColumnDefault](get-column-default.md)()<br>Column default |
| [getColumnPrivileges](get-column-privileges.md) | [jvm]<br>final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[ColumnPrivilege](../-column-privilege/index.md)&gt;[getColumnPrivileges](get-column-privileges.md)()<br>Get column privileges |
| [getColumnSize](get-column-size.md) | [jvm]<br>final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[getColumnSize](get-column-size.md)()<br>Column size |
| [getDataType](get-data-type.md) | [jvm]<br>final [JDBCType](https://docs.oracle.com/javase/8/docs/api/java/sql/JDBCType.html)[getDataType](get-data-type.md)()<br>SQL type from [java.sql.Types](https://docs.oracle.com/javase/8/docs/api/java/sql/Types.html) |
| [getDecimalDigits](get-decimal-digits.md) | [jvm]<br>final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[getDecimalDigits](get-decimal-digits.md)()<br>The number of fractional digits, null is returned when decimalDigits is not applicable |
| [getName](get-name.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getName](get-name.md)()<br>Column name |
| [getNullable](get-nullable.md) | [jvm]<br>final [ColumnNullable](../-column-nullable/index.md)[getNullable](get-nullable.md)()<br>Nullable |
| [getOrdinalPosition](get-ordinal-position.md) | [jvm]<br>final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[getOrdinalPosition](get-ordinal-position.md)()<br>Ordinal position |
| [getRadix](get-radix.md) | [jvm]<br>final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[getRadix](get-radix.md)()<br>Numeric precision radix |
| [getRemarks](get-remarks.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getRemarks](get-remarks.md)()<br>Remarks |
| [getSchema](get-schema.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getSchema](get-schema.md)()<br>Containing Table's schema |
| [getScopeCatalog](get-scope-catalog.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getScopeCatalog](get-scope-catalog.md)()<br>Scope catalog |
| [getScopeSchema](get-scope-schema.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getScopeSchema](get-scope-schema.md)()<br>Scope schema |
| [getScopeTable](get-scope-table.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getScopeTable](get-scope-table.md)()<br>Scope table |
| [getSourceDataType](get-source-data-type.md) | [jvm]<br>final [JDBCType](https://docs.oracle.com/javase/8/docs/api/java/sql/JDBCType.html)[getSourceDataType](get-source-data-type.md)()<br>Source data type |
| [getTableName](get-table-name.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getTableName](get-table-name.md)()<br>Containing Table's name |
| [getTypeName](get-type-name.md) | [jvm]<br>final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getTypeName](get-type-name.md)()<br>Data source dependent type name, for [UserDefinedType](../-user-defined-type/index.md) the type name is fully qualified |
| [isAutoincrement](is-autoincrement.md) | [jvm]<br>final [IsAutoIncrement](../-is-auto-increment/index.md)[isAutoincrement](is-autoincrement.md)()<br>Is autoincrement |
| [isGeneratedColumn](is-generated-column.md) | [jvm]<br>final [IsGeneratedColumn](../-is-generated-column/index.md)[isGeneratedColumn](is-generated-column.md)()<br>Is generated column |
| [isNullable](is-nullable.md) | [jvm]<br>final [IsNullable](../-is-nullable/index.md)[isNullable](is-nullable.md)()<br>Is nullable |

## Properties

| Name | Summary |
|---|---|
| [catalog](index.md#-1960551777%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[catalog](index.md#-1960551777%2FProperties%2F-1216412040)<br>Containing Table's catalog |
| [characterOctetLength](index.md#1526494614%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[characterOctetLength](index.md#1526494614%2FProperties%2F-1216412040)<br>Character octet length |
| [columnDefault](index.md#-1636544339%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[columnDefault](index.md#-1636544339%2FProperties%2F-1216412040)<br>Column default |
| [columnSize](index.md#806080619%2FProperties%2F-1216412040) | [jvm]<br>private final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[columnSize](index.md#806080619%2FProperties%2F-1216412040)<br>Column size |
| [dataType](index.md#658359486%2FProperties%2F-1216412040) | [jvm]<br>private final [JDBCType](https://docs.oracle.com/javase/8/docs/api/java/sql/JDBCType.html)[dataType](index.md#658359486%2FProperties%2F-1216412040)<br>SQL type from [java.sql.Types](https://docs.oracle.com/javase/8/docs/api/java/sql/Types.html) |
| [decimalDigits](index.md#-47019871%2FProperties%2F-1216412040) | [jvm]<br>private final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[decimalDigits](index.md#-47019871%2FProperties%2F-1216412040)<br>The number of fractional digits, null is returned when decimalDigits is not applicable |
| [isAutoincrement](is-autoincrement.md) | [jvm]<br>private final [IsAutoIncrement](../-is-auto-increment/index.md)[isAutoincrement](is-autoincrement.md)<br>Is autoincrement |
| [isGeneratedColumn](is-generated-column.md) | [jvm]<br>private final [IsGeneratedColumn](../-is-generated-column/index.md)[isGeneratedColumn](is-generated-column.md)<br>Is generated column |
| [isNullable](is-nullable.md) | [jvm]<br>private final [IsNullable](../-is-nullable/index.md)[isNullable](is-nullable.md)<br>Is nullable |
| [name](index.md#-906905449%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[name](index.md#-906905449%2FProperties%2F-1216412040)<br>Column name |
| [nullable](index.md#-1499994623%2FProperties%2F-1216412040) | [jvm]<br>private final [ColumnNullable](../-column-nullable/index.md)[nullable](index.md#-1499994623%2FProperties%2F-1216412040)<br>Nullable |
| [ordinalPosition](index.md#-1434845154%2FProperties%2F-1216412040) | [jvm]<br>private final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[ordinalPosition](index.md#-1434845154%2FProperties%2F-1216412040)<br>Ordinal position |
| [radix](index.md#1266470868%2FProperties%2F-1216412040) | [jvm]<br>private final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[radix](index.md#1266470868%2FProperties%2F-1216412040)<br>Numeric precision radix |
| [remarks](index.md#-1431021819%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[remarks](index.md#-1431021819%2FProperties%2F-1216412040)<br>Remarks |
| [schema](index.md#-504212223%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[schema](index.md#-504212223%2FProperties%2F-1216412040)<br>Containing Table's schema |
| [scopeCatalog](index.md#-1057772483%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[scopeCatalog](index.md#-1057772483%2FProperties%2F-1216412040)<br>Scope catalog |
| [scopeSchema](index.md#910383011%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[scopeSchema](index.md#910383011%2FProperties%2F-1216412040)<br>Scope schema |
| [scopeTable](index.md#1645822056%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[scopeTable](index.md#1645822056%2FProperties%2F-1216412040)<br>Scope table |
| [sourceDataType](index.md#859296803%2FProperties%2F-1216412040) | [jvm]<br>private final [JDBCType](https://docs.oracle.com/javase/8/docs/api/java/sql/JDBCType.html)[sourceDataType](index.md#859296803%2FProperties%2F-1216412040)<br>Source data type |
| [tableName](index.md#-236918657%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[tableName](index.md#-236918657%2FProperties%2F-1216412040)<br>Containing Table's name |
| [typeName](index.md#1088671997%2FProperties%2F-1216412040) | [jvm]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[typeName](index.md#1088671997%2FProperties%2F-1216412040)<br>Data source dependent type name, for [UserDefinedType](../-user-defined-type/index.md) the type name is fully qualified |
