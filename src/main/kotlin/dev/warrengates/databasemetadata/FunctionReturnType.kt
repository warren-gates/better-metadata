package dev.warrengates.databasemetadata

import java.sql.DatabaseMetaData

/**
 * Function return type
 *
 * @property type
 * @constructor Create empty Function return type
 */
enum class FunctionReturnType(override val type: Int): IntegerEnum {
    /**
     * No Table
     *
     * @constructor Create empty No Table
     */
    NO_TABLE(DatabaseMetaData.functionNoTable),

    /**
     * Table
     *
     * @constructor Create empty Table
     */
    TABLE(DatabaseMetaData.functionReturnsTable),

    /**
     * Unknown
     *
     * @constructor Create empty Unknown
     */
    UNKNOWN(DatabaseMetaData.functionResultUnknown);
}