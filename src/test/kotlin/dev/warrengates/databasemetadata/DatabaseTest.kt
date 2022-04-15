package dev.warrengates.databasemetadata

import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DatabaseTest : TestBase() {

    @ParameterizedTest
    @MethodSource
    fun testKeywordsToObject(wordString: String, objectList: List<Any>) {
        assertAll(
            { assertEquals(wordString.split(",").size, objectList.size) },
            { wordString.split(",").all { word -> objectList.count { it.toString() == word } == 1 } }
        )
    }

    @Suppress("unused")
    private fun testKeywordsToObject(): Stream<out Arguments> {
        return Stream.of(
            Arguments.of(metadata.sqlKeywords, wrapper.getSQLKeywords()),
            Arguments.of(metadata.numericFunctions, wrapper.getNumericFunctions()),
            Arguments.of(metadata.stringFunctions, wrapper.getStringFunctions()),
            Arguments.of(metadata.systemFunctions, wrapper.getSystemFunctions()),
            Arguments.of(metadata.timeDateFunctions, wrapper.getTimeDateFunctions())
        )
    }


    @Test
    fun testEnumReturnFunctions() {
        assertAll(
            { assertEquals(valueOf<TransactionIsolation>(metadata.defaultTransactionIsolation), wrapper.getDefaultTransactionIsolation()) },
            { assertEquals(valueOf<ResultSetHoldability>(metadata.defaultTransactionIsolation), wrapper.getResultSetHoldability()) },
            { assertEquals(valueOf<SQLStateType>(metadata.defaultTransactionIsolation), wrapper.getSQLStateType()) }
        )
    }
}