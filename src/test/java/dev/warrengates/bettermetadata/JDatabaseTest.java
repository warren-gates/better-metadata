package dev.warrengates.bettermetadata;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class JDatabaseTest extends JDatabaseTestBase {

    @ParameterizedTest
    @MethodSource
    public void testKeywordsToObject(String wordString, List<?> objectList) {
        assertAll(
                () -> assertEquals(wordString.split(",").length, objectList.size()),
                () -> assertTrue(Arrays.stream(wordString.split(",")).allMatch(word -> objectList.stream().filter(o -> o.toString().equals(word)).count() == 1))
        );
    }

    private Stream<Arguments> testKeywordsToObject() throws SQLException {
        return Stream.of(
                Arguments.of(metadata.getSQLKeywords(), wrapper.getSQLKeywords()),
                Arguments.of(metadata.getNumericFunctions(), wrapper.getNumericFunctions()),
                Arguments.of(metadata.getStringFunctions(), wrapper.getStringFunctions()),
                Arguments.of(metadata.getSystemFunctions(), wrapper.getSystemFunctions()),
                Arguments.of(metadata.getTimeDateFunctions(), wrapper.getTimeDateFunctions())
        );
    }

    @Test
    public void testTableCount() throws SQLException {
        var wrapperTableCount = wrapper.getTables(null, null, null, null).size();
        var metadataTableCount = 0;
        var rs = metadata.getTables(null, null, null, null);
        while (rs.next()) {
            metadataTableCount++;
        }
        assertEquals(metadataTableCount, wrapperTableCount);
    }

    @Test
    public void testEnumReturnFunctions() throws SQLException {
        assertAll(
                () -> assertEquals(valueOf(TransactionIsolation.class, metadata.getDefaultTransactionIsolation()), wrapper.getDefaultTransactionIsolation()),
                () -> assertEquals(valueOf(ResultSetHoldability.class, metadata.getDefaultTransactionIsolation()), wrapper.getResultSetHoldability()),
                () -> assertEquals(valueOf(SQLStateType.class, metadata.getDefaultTransactionIsolation()), wrapper.getSQLStateType())
        );
    }

    private static <T extends Enum<T> & IntegerEnum> T valueOf(Class<T> enumType, int value) {
        for (T en : enumType.getEnumConstants()) {
            if (en.getType() == value) {
                return en;
            }
        }
        throw new IllegalArgumentException("No enum constant has type = " + value);
    }
}
