package dev.warrengates.bettermetadata

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.TestInstance
import java.sql.DatabaseMetaData
import kotlin.reflect.full.functions
import kotlin.reflect.full.withNullability

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DynamicDatabaseTest : TestBase() {

    @TestFactory
    fun testBooleanFunctions(): List<DynamicTest> {
        return testParameterlessFunctions<Boolean>()
    }

    @TestFactory
    fun testIntFunctions(): List<DynamicTest> {
        val excludes = listOf(
            "getDefaultTransactionIsolation",
            "getResultSetHoldability",
            "getSQLStateType",
            "hashCode"
        )
        return testParameterlessFunctions<Int>(excludes)
    }

    @TestFactory
    fun testLongFunctions(): List<DynamicTest> {
        return testParameterlessFunctions<Long>()
    }

    @TestFactory
    fun testStringFunctions(): List<DynamicTest> {
        val excludes = listOf(
            "getNumericFunctions",
            "getSQLKeywords",
            "getStringFunctions",
            "getSystemFunctions",
            "getTimeDateFunctions",
            "toString"
        )

        return testParameterlessFunctions<String>(excludes)
    }

    private inline fun <reified T> testParameterlessFunctions(excludes: List<String> = listOf()): List<DynamicTest> {
        val testList: MutableList<DynamicTest> = mutableListOf()

        for (metaFunction in DatabaseMetaData::class.functions.filter {
            // withNullability(false) needed to deal with kotlin.String! types
            it.returnType.withNullability(false) == kotlin.reflect.typeOf<T>() &&
                    it.parameters.size == 1
        }.sortedBy { it.name }) {
            if (excludes.contains(metaFunction.name)) {
                continue
            }
//            println(metaFunction.name + " " + metaFunction.returnType)
            val wrapperFunction = Database::class.functions.first {
                it.name == metaFunction.name &&
                        it.returnType == kotlin.reflect.typeOf<T>() &&
                        it.parameters.size == 1
            }
            testList.add(dynamicTest(metaFunction.name) {
                assertEquals(
                    metaFunction.call(metadata), wrapperFunction.call(wrapper)
                )
            })
        }
        return testList
    }
}