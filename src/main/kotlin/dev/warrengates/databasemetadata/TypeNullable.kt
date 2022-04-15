package dev.warrengates.databasemetadata

import java.sql.DatabaseMetaData

/**
 * Type nullable
 *
 * @property type
 * @constructor Create empty Type nullable
 */
enum class TypeNullable(override val type: Int): IntegerEnum {
    /**
     * No
     *
     * @constructor Create empty No
     */
    NO(DatabaseMetaData.typeNoNulls),

    /**
     * Yes
     *
     * @constructor Create empty Yes
     */
    YES(DatabaseMetaData.typeNullable),

    /**
     * Unknown
     *
     * @constructor Create empty Unknown
     */
    UNKNOWN(DatabaseMetaData.typeNullableUnknown);
}