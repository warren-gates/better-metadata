package dev.warrengates.bettermetadata

import java.sql.DatabaseMetaData

/**
 * Procedure column type
 *
 * @property type
 * @constructor Create empty Procedure column type
 */
enum class ProcedureColumnType(override val type: Int): IntegerEnum {
    /**
     * In
     *
     * @constructor Create empty In
     */
    IN(DatabaseMetaData.procedureColumnIn),

    /**
     * In Out
     *
     * @constructor Create empty In Out
     */
    IN_OUT(DatabaseMetaData.procedureColumnInOut),

    /**
     * Out
     *
     * @constructor Create empty Out
     */
    OUT(DatabaseMetaData.procedureColumnOut),

    /**
     * Return
     *
     * @constructor Create empty Return
     */
    RETURN(DatabaseMetaData.procedureColumnReturn),

    /**
     * Result
     *
     * @constructor Create empty Result
     */
    RESULT(DatabaseMetaData.procedureColumnResult),

    /**
     * Unknown
     *
     * @constructor Create empty Unknown
     */
    UNKNOWN(DatabaseMetaData.procedureColumnUnknown);
}