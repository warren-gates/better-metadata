package dev.warrengates.bettermetadata

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.sql.Connection
import java.sql.DatabaseMetaData
import java.sql.JDBCType
import java.sql.ResultSet
import java.sql.Types
import java.util.stream.Stream
import kotlin.reflect.full.staticProperties
import kotlin.reflect.typeOf

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class EnumTests {

    @ParameterizedTest
    @MethodSource
    fun testEnumValueMapping(source: Int, enumValue: Int) {
        assertEquals(source, enumValue)
    }

    @Suppress("unused")
    fun testEnumValueMapping(): Stream<out Arguments> {
        return Stream.of(
            Arguments.of(Connection.TRANSACTION_NONE, TransactionIsolation.NONE.value),
            Arguments.of(Connection.TRANSACTION_READ_COMMITTED, TransactionIsolation.READ_COMMITTED.value),
            Arguments.of(Connection.TRANSACTION_READ_UNCOMMITTED, TransactionIsolation.READ_UNCOMMITTED.value),
            Arguments.of(Connection.TRANSACTION_REPEATABLE_READ, TransactionIsolation.REPEATABLE_READ.value),
            Arguments.of(Connection.TRANSACTION_SERIALIZABLE, TransactionIsolation.SERIALIZABLE.value),

            Arguments.of(ResultSet.CLOSE_CURSORS_AT_COMMIT, ResultSetHoldability.CLOSE_CURSORS_AT_COMMIT.value),
            Arguments.of(ResultSet.HOLD_CURSORS_OVER_COMMIT, ResultSetHoldability.HOLD_CURSORS_OVER_COMMIT.value),

            Arguments.of(DatabaseMetaData.sqlStateSQL, SQLStateType.SQL.value),
            Arguments.of(DatabaseMetaData.sqlStateSQL99, SQLStateType.SQL.value),
            Arguments.of(DatabaseMetaData.sqlStateXOpen, SQLStateType.XOpen.value),

            Arguments.of(DatabaseMetaData.columnNoNulls, ColumnNullable.NO.value),
            Arguments.of(DatabaseMetaData.columnNullable, ColumnNullable.YES.value),
            Arguments.of(DatabaseMetaData.columnNullableUnknown, ColumnNullable.UNKNOWN.value),

            Arguments.of(DatabaseMetaData.importedKeyNoAction, ForeignKeyDeleteRule.NO_ACTION.value),
            Arguments.of(DatabaseMetaData.importedKeyCascade, ForeignKeyDeleteRule.CASCADE.value),
            Arguments.of(DatabaseMetaData.importedKeySetNull, ForeignKeyDeleteRule.SET_NULL.value),
            Arguments.of(DatabaseMetaData.importedKeySetDefault, ForeignKeyDeleteRule.SET_DEFAULT.value),
            Arguments.of(DatabaseMetaData.importedKeyRestrict, ForeignKeyDeleteRule.RESTRICT.value),

            Arguments.of(DatabaseMetaData.importedKeyNoAction, ForeignKeyUpdateRule.NO_ACTION.value),
            Arguments.of(DatabaseMetaData.importedKeyCascade, ForeignKeyUpdateRule.CASCADE.value),
            Arguments.of(DatabaseMetaData.importedKeySetNull, ForeignKeyUpdateRule.SET_NULL.value),
            Arguments.of(DatabaseMetaData.importedKeySetDefault, ForeignKeyUpdateRule.SET_DEFAULT.value),
            Arguments.of(DatabaseMetaData.importedKeyRestrict, ForeignKeyUpdateRule.RESTRICT.value),

            Arguments.of(DatabaseMetaData.importedKeyInitiallyDeferred, ForeignKeyInitialDeferrability.DEFERRED.value),
            Arguments.of(DatabaseMetaData.importedKeyInitiallyImmediate, ForeignKeyInitialDeferrability.IMMEDIATE.value),
            Arguments.of(DatabaseMetaData.importedKeyNotDeferrable, ForeignKeyInitialDeferrability.NOT_DEFERRABLE.value),

            Arguments.of(DatabaseMetaData.functionNoNulls, FunctionColumnNullable.NO.value),
            Arguments.of(DatabaseMetaData.functionNullable, FunctionColumnNullable.YES.value),
            Arguments.of(DatabaseMetaData.functionNullableUnknown, FunctionColumnNullable.UNKNOWN.value),

            Arguments.of(DatabaseMetaData.functionColumnIn, FunctionColumnType.IN.value),
            Arguments.of(DatabaseMetaData.functionColumnInOut, FunctionColumnType.IN_OUT.value),
            Arguments.of(DatabaseMetaData.functionColumnOut, FunctionColumnType.OUT.value),
            Arguments.of(DatabaseMetaData.functionReturn, FunctionColumnType.RETURN.value),
            Arguments.of(DatabaseMetaData.functionColumnResult, FunctionColumnType.RESULT.value),
            Arguments.of(DatabaseMetaData.functionColumnUnknown, FunctionColumnType.UNKNOWN.value),

            Arguments.of(DatabaseMetaData.functionNoTable, FunctionReturnType.NO_TABLE.value),
            Arguments.of(DatabaseMetaData.functionReturnsTable, FunctionReturnType.TABLE.value),
            Arguments.of(DatabaseMetaData.functionResultUnknown, FunctionReturnType.UNKNOWN.value),

            Arguments.of(DatabaseMetaData.tableIndexStatistic, IndexType.STATISTIC.value),
            Arguments.of(DatabaseMetaData.tableIndexClustered, IndexType.CLUSTERED.value),
            Arguments.of(DatabaseMetaData.tableIndexHashed, IndexType.HASHED.value),
            Arguments.of(DatabaseMetaData.tableIndexOther, IndexType.OTHER.value),

            Arguments.of(DatabaseMetaData.procedureNoNulls, ProcedureColumnNullable.NO.value),
            Arguments.of(DatabaseMetaData.procedureNullable, ProcedureColumnNullable.YES.value),
            Arguments.of(DatabaseMetaData.procedureNullableUnknown, ProcedureColumnNullable.UNKNOWN.value),

            Arguments.of(DatabaseMetaData.procedureColumnIn, ProcedureColumnType.IN.value),
            Arguments.of(DatabaseMetaData.procedureColumnInOut, ProcedureColumnType.IN_OUT.value),
            Arguments.of(DatabaseMetaData.procedureColumnOut, ProcedureColumnType.OUT.value),
            Arguments.of(DatabaseMetaData.procedureColumnReturn, ProcedureColumnType.RETURN.value),
            Arguments.of(DatabaseMetaData.procedureColumnResult, ProcedureColumnType.RESULT.value),
            Arguments.of(DatabaseMetaData.procedureColumnUnknown, ProcedureColumnType.UNKNOWN.value),

            Arguments.of(DatabaseMetaData.procedureNoResult, ProcedureReturnType.NO_RESULT.value),
            Arguments.of(DatabaseMetaData.procedureReturnsResult, ProcedureReturnType.RETURNS_RESULT.value),
            Arguments.of(DatabaseMetaData.procedureResultUnknown, ProcedureReturnType.UNKNOWN.value),

            Arguments.of(DatabaseMetaData.versionColumnNotPseudo, VersionColumnType.NOT_PSEUDO_COLUMN.value),
            Arguments.of(DatabaseMetaData.versionColumnPseudo, VersionColumnType.IS_PSEUDO_COLUMN.value),
            Arguments.of(DatabaseMetaData.versionColumnUnknown, VersionColumnType.UNKNOWN.value),

            Arguments.of(ResultSet.TYPE_FORWARD_ONLY, ResultSetType.FORWARD_ONLY.value),
            Arguments.of(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSetType.SCROLL_INSENSITIVE.value),
            Arguments.of(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSetType.SCROLL_SENSITIVE.value),

            Arguments.of(ResultSet.CONCUR_READ_ONLY, ResultSetConcurrency.READ_ONLY.value),
            Arguments.of(ResultSet.CONCUR_UPDATABLE, ResultSetConcurrency.UPDATABLE.value),

            Arguments.of(DatabaseMetaData.typeNoNulls, TypeNullable.NO.value),
            Arguments.of(DatabaseMetaData.typeNullable, TypeNullable.YES.value),
            Arguments.of(DatabaseMetaData.typeNullableUnknown, TypeNullable.UNKNOWN.value),

            Arguments.of(DatabaseMetaData.typePredBasic, TypeSearchable.BASIC.value),
            Arguments.of(DatabaseMetaData.typePredChar, TypeSearchable.CHARACTER.value),
            Arguments.of(DatabaseMetaData.typePredNone, TypeSearchable.NONE.value),
            Arguments.of(DatabaseMetaData.typeSearchable, TypeSearchable.SEARCHABLE.value),

            Arguments.of(DatabaseMetaData.bestRowNotPseudo, BestRowColumnType.NOT_PSEUDO_COLUMN.value),
            Arguments.of(DatabaseMetaData.bestRowPseudo, BestRowColumnType.IS_PSEUDO_COLUMN.value),
            Arguments.of(DatabaseMetaData.bestRowUnknown, BestRowColumnType.UNKNOWN.value),

            Arguments.of(DatabaseMetaData.bestRowSession, BestRowIdentifierScope.SESSION.value),
            Arguments.of(DatabaseMetaData.bestRowTemporary, BestRowIdentifierScope.TEMPORARY.value),
            Arguments.of(DatabaseMetaData.bestRowTransaction, BestRowIdentifierScope.TRANSACTION.value),

            Arguments.of(DatabaseMetaData.attributeNoNulls, AttributeNullable.NO.value),
            Arguments.of(DatabaseMetaData.attributeNullable, AttributeNullable.YES.value),
            Arguments.of(DatabaseMetaData.attributeNullableUnknown, AttributeNullable.UNKNOWN.value),
        )
    }

    @ParameterizedTest
    @MethodSource
    fun testEnumValueOf(mappedValue: Enum<*>, expected: Enum<*>) {
        assertEquals(expected, mappedValue)
    }

    @Suppress("unused")
    fun testEnumValueOf(): Stream<out Arguments> {
        return Stream.of(
            Arguments.of(valueOf<TransactionIsolation>(Connection.TRANSACTION_NONE), TransactionIsolation.NONE),
            Arguments.of(valueOf<TransactionIsolation>(Connection.TRANSACTION_READ_COMMITTED), TransactionIsolation.READ_COMMITTED),
            Arguments.of(valueOf<TransactionIsolation>(Connection.TRANSACTION_READ_UNCOMMITTED), TransactionIsolation.READ_UNCOMMITTED),
            Arguments.of(valueOf<TransactionIsolation>(Connection.TRANSACTION_REPEATABLE_READ), TransactionIsolation.REPEATABLE_READ),
            Arguments.of(valueOf<TransactionIsolation>(Connection.TRANSACTION_SERIALIZABLE), TransactionIsolation.SERIALIZABLE),

            Arguments.of(valueOf<ResultSetHoldability>(ResultSet.CLOSE_CURSORS_AT_COMMIT), ResultSetHoldability.CLOSE_CURSORS_AT_COMMIT),
            Arguments.of(valueOf<ResultSetHoldability>(ResultSet.HOLD_CURSORS_OVER_COMMIT), ResultSetHoldability.HOLD_CURSORS_OVER_COMMIT),

            Arguments.of(valueOf<SQLStateType>(DatabaseMetaData.sqlStateSQL), SQLStateType.SQL),
            Arguments.of(valueOf<SQLStateType>(DatabaseMetaData.sqlStateSQL99), SQLStateType.SQL),
            Arguments.of(valueOf<SQLStateType>(DatabaseMetaData.sqlStateXOpen), SQLStateType.XOpen),

            Arguments.of(valueOf<ColumnNullable>(DatabaseMetaData.columnNoNulls), ColumnNullable.NO),
            Arguments.of(valueOf<ColumnNullable>(DatabaseMetaData.columnNullable), ColumnNullable.YES),
            Arguments.of(valueOf<ColumnNullable>(DatabaseMetaData.columnNullableUnknown), ColumnNullable.UNKNOWN),

            Arguments.of(valueOf<ForeignKeyDeleteRule>(DatabaseMetaData.importedKeyNoAction), ForeignKeyDeleteRule.NO_ACTION),
            Arguments.of(valueOf<ForeignKeyDeleteRule>(DatabaseMetaData.importedKeyCascade), ForeignKeyDeleteRule.CASCADE),
            Arguments.of(valueOf<ForeignKeyDeleteRule>(DatabaseMetaData.importedKeySetNull), ForeignKeyDeleteRule.SET_NULL),
            Arguments.of(valueOf<ForeignKeyDeleteRule>(DatabaseMetaData.importedKeySetDefault), ForeignKeyDeleteRule.SET_DEFAULT),
            Arguments.of(valueOf<ForeignKeyDeleteRule>(DatabaseMetaData.importedKeyRestrict), ForeignKeyDeleteRule.RESTRICT),

            Arguments.of(valueOf<ForeignKeyUpdateRule>(DatabaseMetaData.importedKeyNoAction), ForeignKeyUpdateRule.NO_ACTION),
            Arguments.of(valueOf<ForeignKeyUpdateRule>(DatabaseMetaData.importedKeyCascade), ForeignKeyUpdateRule.CASCADE),
            Arguments.of(valueOf<ForeignKeyUpdateRule>(DatabaseMetaData.importedKeySetNull), ForeignKeyUpdateRule.SET_NULL),
            Arguments.of(valueOf<ForeignKeyUpdateRule>(DatabaseMetaData.importedKeySetDefault), ForeignKeyUpdateRule.SET_DEFAULT),
            Arguments.of(valueOf<ForeignKeyUpdateRule>(DatabaseMetaData.importedKeyRestrict), ForeignKeyUpdateRule.RESTRICT),

            Arguments.of(valueOf<ForeignKeyInitialDeferrability>(DatabaseMetaData.importedKeyInitiallyDeferred),
                ForeignKeyInitialDeferrability.DEFERRED),
            Arguments.of(valueOf<ForeignKeyInitialDeferrability>(DatabaseMetaData.importedKeyInitiallyImmediate),
                ForeignKeyInitialDeferrability.IMMEDIATE),
            Arguments.of(valueOf<ForeignKeyInitialDeferrability>(DatabaseMetaData.importedKeyNotDeferrable),
                ForeignKeyInitialDeferrability.NOT_DEFERRABLE),

            Arguments.of(valueOf<FunctionColumnNullable>(DatabaseMetaData.functionNoNulls), FunctionColumnNullable.NO),
            Arguments.of(valueOf<FunctionColumnNullable>(DatabaseMetaData.functionNullable), FunctionColumnNullable.YES),
            Arguments.of(valueOf<FunctionColumnNullable>(DatabaseMetaData.functionNullableUnknown),
                FunctionColumnNullable.UNKNOWN),

            Arguments.of(valueOf<FunctionColumnType>(DatabaseMetaData.functionColumnIn), FunctionColumnType.IN),
            Arguments.of(valueOf<FunctionColumnType>(DatabaseMetaData.functionColumnInOut), FunctionColumnType.IN_OUT),
            Arguments.of(valueOf<FunctionColumnType>(DatabaseMetaData.functionColumnOut), FunctionColumnType.OUT),
            Arguments.of(valueOf<FunctionColumnType>(DatabaseMetaData.functionReturn), FunctionColumnType.RETURN),
            Arguments.of(valueOf<FunctionColumnType>(DatabaseMetaData.functionColumnResult), FunctionColumnType.RESULT),
            Arguments.of(valueOf<FunctionColumnType>(DatabaseMetaData.functionColumnUnknown), FunctionColumnType.UNKNOWN),

            Arguments.of(valueOf<FunctionReturnType>(DatabaseMetaData.functionNoTable), FunctionReturnType.NO_TABLE),
            Arguments.of(valueOf<FunctionReturnType>(DatabaseMetaData.functionReturnsTable), FunctionReturnType.TABLE),
            Arguments.of(valueOf<FunctionReturnType>(DatabaseMetaData.functionResultUnknown), FunctionReturnType.UNKNOWN),

            Arguments.of(valueOf<IndexType>(DatabaseMetaData.tableIndexStatistic.toInt()), IndexType.STATISTIC),
            Arguments.of(valueOf<IndexType>(DatabaseMetaData.tableIndexClustered.toInt()), IndexType.CLUSTERED),
            Arguments.of(valueOf<IndexType>(DatabaseMetaData.tableIndexHashed.toInt()), IndexType.HASHED),
            Arguments.of(valueOf<IndexType>(DatabaseMetaData.tableIndexOther.toInt()), IndexType.OTHER),

            Arguments.of(valueOf<ProcedureColumnNullable>(DatabaseMetaData.procedureNoNulls), ProcedureColumnNullable.NO),
            Arguments.of(valueOf<ProcedureColumnNullable>(DatabaseMetaData.procedureNullable), ProcedureColumnNullable.YES),
            Arguments.of(valueOf<ProcedureColumnNullable>(DatabaseMetaData.procedureNullableUnknown), ProcedureColumnNullable.UNKNOWN),

            Arguments.of(valueOf<ProcedureColumnType>(DatabaseMetaData.procedureColumnIn), ProcedureColumnType.IN),
            Arguments.of(valueOf<ProcedureColumnType>(DatabaseMetaData.procedureColumnInOut), ProcedureColumnType.IN_OUT),
            Arguments.of(valueOf<ProcedureColumnType>(DatabaseMetaData.procedureColumnOut), ProcedureColumnType.OUT),
            Arguments.of(valueOf<ProcedureColumnType>(DatabaseMetaData.procedureColumnReturn), ProcedureColumnType.RETURN),
            Arguments.of(valueOf<ProcedureColumnType>(DatabaseMetaData.procedureColumnResult), ProcedureColumnType.RESULT),
            Arguments.of(valueOf<ProcedureColumnType>(DatabaseMetaData.procedureColumnUnknown), ProcedureColumnType.UNKNOWN),

            Arguments.of(valueOf<ProcedureReturnType>(DatabaseMetaData.procedureNoResult), ProcedureReturnType.NO_RESULT),
            Arguments.of(valueOf<ProcedureReturnType>(DatabaseMetaData.procedureReturnsResult), ProcedureReturnType.RETURNS_RESULT),
            Arguments.of(valueOf<ProcedureReturnType>(DatabaseMetaData.procedureResultUnknown), ProcedureReturnType.UNKNOWN),

            Arguments.of(valueOf<VersionColumnType>(DatabaseMetaData.versionColumnNotPseudo), VersionColumnType.NOT_PSEUDO_COLUMN),
            Arguments.of(valueOf<VersionColumnType>(DatabaseMetaData.versionColumnPseudo), VersionColumnType.IS_PSEUDO_COLUMN),
            Arguments.of(valueOf<VersionColumnType>(DatabaseMetaData.versionColumnUnknown), VersionColumnType.UNKNOWN),

            Arguments.of(valueOf<ResultSetType>(ResultSet.TYPE_FORWARD_ONLY), ResultSetType.FORWARD_ONLY),
            Arguments.of(valueOf<ResultSetType>(ResultSet.TYPE_SCROLL_INSENSITIVE), ResultSetType.SCROLL_INSENSITIVE),
            Arguments.of(valueOf<ResultSetType>(ResultSet.TYPE_SCROLL_SENSITIVE), ResultSetType.SCROLL_SENSITIVE),

            Arguments.of(valueOf<ResultSetConcurrency>(ResultSet.CONCUR_READ_ONLY), ResultSetConcurrency.READ_ONLY),
            Arguments.of(valueOf<ResultSetConcurrency>(ResultSet.CONCUR_UPDATABLE), ResultSetConcurrency.UPDATABLE),

            Arguments.of(valueOf<TypeNullable>(DatabaseMetaData.typeNoNulls), TypeNullable.NO),
            Arguments.of(valueOf<TypeNullable>(DatabaseMetaData.typeNullable), TypeNullable.YES),
            Arguments.of(valueOf<TypeNullable>(DatabaseMetaData.typeNullableUnknown), TypeNullable.UNKNOWN),

            Arguments.of(valueOf<TypeSearchable>(DatabaseMetaData.typePredBasic), TypeSearchable.BASIC),
            Arguments.of(valueOf<TypeSearchable>(DatabaseMetaData.typePredChar), TypeSearchable.CHARACTER),
            Arguments.of(valueOf<TypeSearchable>(DatabaseMetaData.typePredNone), TypeSearchable.NONE),
            Arguments.of(valueOf<TypeSearchable>(DatabaseMetaData.typeSearchable), TypeSearchable.SEARCHABLE),

            Arguments.of(valueOf<BestRowColumnType>(DatabaseMetaData.bestRowNotPseudo), BestRowColumnType.NOT_PSEUDO_COLUMN),
            Arguments.of(valueOf<BestRowColumnType>(DatabaseMetaData.bestRowPseudo), BestRowColumnType.IS_PSEUDO_COLUMN),
            Arguments.of(valueOf<BestRowColumnType>(DatabaseMetaData.bestRowUnknown), BestRowColumnType.UNKNOWN),

            Arguments.of(valueOf<BestRowIdentifierScope>(DatabaseMetaData.bestRowSession), BestRowIdentifierScope.SESSION),
            Arguments.of(valueOf<BestRowIdentifierScope>(DatabaseMetaData.bestRowTemporary), BestRowIdentifierScope.TEMPORARY),
            Arguments.of(valueOf<BestRowIdentifierScope>(DatabaseMetaData.bestRowTransaction), BestRowIdentifierScope.TRANSACTION),

            Arguments.of(valueOf<AttributeNullable>(DatabaseMetaData.typeNoNulls), AttributeNullable.NO),
            Arguments.of(valueOf<AttributeNullable>(DatabaseMetaData.typeNullable), AttributeNullable.YES),
            Arguments.of(valueOf<AttributeNullable>(DatabaseMetaData.typeNullableUnknown), AttributeNullable.UNKNOWN),
        )
    }

    @TestFactory
    fun jdbcTypeSanityCheck(): List<DynamicTest>  {

        val testList: MutableList<DynamicTest> = mutableListOf()
        for (jdbcType in enumValues<JDBCType>()) {
            val sqlTypeValue = Types::class.staticProperties.filter { it.returnType == typeOf<Int>() }
                .first { it.name == jdbcType.name }.get() as Int
            testList.add(dynamicTest(jdbcType.name) { assertEquals(jdbcType.vendorTypeNumber, sqlTypeValue) })
        }
        return testList
    }
}