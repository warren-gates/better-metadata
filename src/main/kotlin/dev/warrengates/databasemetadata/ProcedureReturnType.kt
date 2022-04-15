package dev.warrengates.databasemetadata

import java.sql.DatabaseMetaData

/**
 * Procedure return type
 *
 * @property type
 * @constructor Create empty Procedure return type
 */
enum class ProcedureReturnType(override val type: Int): IntegerEnum {
    /**
     * No Result
     *
     * @constructor Create empty No Result
     */
    NO_RESULT(DatabaseMetaData.procedureNoResult),

    /**
     * Returns Result
     *
     * @constructor Create empty Returns Result
     */
    RETURNS_RESULT(DatabaseMetaData.procedureReturnsResult),

    /**
     * Unknown
     *
     * @constructor Create empty Unknown
     */
    UNKNOWN(DatabaseMetaData.procedureResultUnknown);
}