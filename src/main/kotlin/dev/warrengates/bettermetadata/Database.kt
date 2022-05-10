/*
 * Copyright (c) 2022 Warren Gates
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.warrengates.bettermetadata

import java.sql.Connection
import java.sql.DatabaseMetaData
import java.sql.JDBCType
import java.sql.RowIdLifetime


/**
 * Provides a wrapper around [DatabaseMetaData](https://docs.oracle.com/en/java/javase/17/docs/api/java.sql/java/sql/DatabaseMetaData.html).
 *
 * @property metadata the wrapped [DatabaseMetaData]
 * @property defaultCatalog a default catalog filter used in methods where a catalog can be specified
 * @property defaultSchema a default schema filter used in methods where a schema can be specified
 * @constructor Create empty Database
 */
@Suppress("unused", "MemberVisibilityCanBePrivate")
class Database @JvmOverloads constructor(
    private val metadata: DatabaseMetaData,
    val defaultCatalog: String? = null,
    val defaultSchema: String? = null,
) {

    private val separator: String = ","

    /**
     * All procedures are callable
     *
     * @return
     */
    fun allProceduresAreCallable(): Boolean = metadata.allProceduresAreCallable()

    /**
     * All tables are selectable
     *
     * @return
     */
    fun allTablesAreSelectable(): Boolean = metadata.allTablesAreSelectable()

    /**
     * Auto commit failure closes all result sets
     *
     * @return
     */
    fun autoCommitFailureClosesAllResultSets(): Boolean = metadata.autoCommitFailureClosesAllResultSets()

    /**
     * Data definition causes transaction commit
     *
     * @return
     */
    fun dataDefinitionCausesTransactionCommit(): Boolean = metadata.dataDefinitionCausesTransactionCommit()

    /**
     * Data definition ignored in transactions
     *
     * @return
     */
    fun dataDefinitionIgnoredInTransactions(): Boolean = metadata.dataDefinitionIgnoredInTransactions()

    /**
     * Deletes are detected
     *
     * @param resultSetType
     * @return
     */
    fun deletesAreDetected(resultSetType: ResultSetType): Boolean = metadata.deletesAreDetected(resultSetType.value)

    /**
     * Does max row size include blobs
     *
     * @return
     */
    fun doesMaxRowSizeIncludeBlobs(): Boolean = metadata.doesMaxRowSizeIncludeBlobs()

    /**
     * Generated key always returned
     *
     * @return
     */
    fun generatedKeyAlwaysReturned(): Boolean = metadata.generatedKeyAlwaysReturned()

    /**
     * Get list of catalogs
     *
     * @return
     */
    fun getCatalogs(): List<String> = getIterableFromRs(metadata.catalogs) { it.getString("TABLE_CAT") }

    /**
     * Get catalog separator
     *
     * @return
     */
    fun getCatalogSeparator(): String = metadata.catalogSeparator

    /**
     * Get catalog term
     *
     * @return
     */
    fun getCatalogTerm(): String = metadata.catalogTerm

    /**
     * Get client info properties, converted to [ClientInfoProperties]
     *
     * @return
     */
    fun getClientInfoProperties(): List<ClientInfoProperties> =
        getIterableFromRs(metadata.clientInfoProperties) { ClientInfoProperties(it) }

    /**
     * Get connection
     *
     * @return
     */
    fun getConnection(): Connection = metadata.connection


    /**
     * Get cross reference, converted to [Key]
     *
     * if not specified, [parentCatalog] and [foreignCatalog] default to [defaultCatalog],
     * and [parentSchema] and [foreignSchema] default to [defaultSchema]
     *
     * @param parentCatalog
     * @param parentSchema
     * @param parentTable
     * @param foreignCatalog
     * @param foreignSchema
     * @param foreignTable
     * @return
     */
    @JvmOverloads
    fun getCrossReference(parentCatalog: String? = defaultCatalog,
                          parentSchema: String? = defaultSchema,
                          parentTable: String,
                          foreignCatalog: String? = defaultCatalog,
                          foreignSchema: String? = defaultSchema,
                          foreignTable: String): List<Key> {
        return getKeys(
            metadata,
            metadata.getCrossReference(parentCatalog, parentSchema, parentTable, foreignCatalog, foreignSchema, foreignTable),
            KeyDiscriminatorColumns("FKTABLE_CAT", "FKTABLE_SCHEM", "FKTABLE_NAME")
        )
    }

    /**
     * Get database major version
     *
     * @return
     */
    fun getDatabaseMajorVersion(): Int = metadata.databaseMajorVersion

    /**
     * Get database minor version
     *
     * @return
     */
    fun getDatabaseMinorVersion(): Int = metadata.databaseMinorVersion

    /**
     * Get database product name
     *
     * @return
     */
    fun getDatabaseProductName(): String = metadata.databaseProductName

    /**
     * Get database product version
     *
     * @return
     */
    fun getDatabaseProductVersion(): String = metadata.databaseProductVersion

    /**
     * Get default transaction isolation, converted to [TransactionIsolation]
     *
     * @return
     */
    fun getDefaultTransactionIsolation(): TransactionIsolation = valueOf(metadata.defaultTransactionIsolation)

    /**
     * Get driver name
     *
     * @return
     */
    fun getDriverName(): String = metadata.driverName

    /**
     * Get driver version
     *
     * @return
     */
    fun getDriverVersion(): String = metadata.driverVersion

    /**
     * Get driver major version
     *
     * @return
     */
    fun getDriverMajorVersion(): Int = metadata.driverMajorVersion

    /**
     * Get driver minor version
     *
     * @return
     */
    fun getDriverMinorVersion(): Int = metadata.driverMinorVersion

    /**
     * Get extra name characters
     *
     * @return
     */
    fun getExtraNameCharacters(): String = metadata.extraNameCharacters

    /**
     * Gets functions using specified [namePattern] along with [defaultCatalog] and [defaultCatalog]
     * to filter results.
     *
     * @param namePattern
     * @return
     */
    @JvmOverloads
    fun getFunctions(namePattern: String? = null): List<dev.warrengates.bettermetadata.Function> =
        getIterableFromRs(
            metadata, metadata.getFunctions(defaultCatalog, defaultSchema, namePattern)
        ) { md, r -> Function(md, r) }

    /**
     * Gets functions using the [catalog], [schemaPattern], and [namePattern]
     * to filter results. If not specified, [catalog] defaults to [defaultCatalog]
     * and [schemaPattern] defaults to [defaultSchema]
     *
     * @param catalog
     * @param schemaPattern
     * @param namePattern
     * @return List<[Function]>
     */
    fun getFunctions(catalog: String? = defaultCatalog,
                     schemaPattern: String? = defaultSchema,
                     namePattern: String? = null): List<Function> {
        return getIterableFromRs(
            metadata, metadata.getFunctions(catalog, schemaPattern, namePattern)
        ) { md, r -> Function(md, r) }
    }

    /**
     * Get identifier quote string
     *
     * @return
     */
    fun getIdentifierQuoteString(): String = metadata.identifierQuoteString

    /**
     * Get JDBC major version
     *
     * @return
     */
    fun getJDBCMajorVersion(): Int = metadata.jdbcMajorVersion

    /**
     * Get JDBC minor version
     *
     * @return
     */
    fun getJDBCMinorVersion(): Int = metadata.jdbcMinorVersion

    /**
     * Get max binary literal length
     *
     * @return
     */
    fun getMaxBinaryLiteralLength(): Int = metadata.maxBinaryLiteralLength

    /**
     * Get max char literal length
     *
     * @return
     */
    fun getMaxCharLiteralLength(): Int = metadata.maxCharLiteralLength

    /**
     * Get max column name length
     *
     * @return
     */
    fun getMaxColumnNameLength(): Int = metadata.maxColumnNameLength

    /**
     * Get max columns in group by
     *
     * @return
     */
    fun getMaxColumnsInGroupBy(): Int = metadata.maxColumnsInGroupBy

    /**
     * Get max columns in index
     *
     * @return
     */
    fun getMaxColumnsInIndex(): Int = metadata.maxColumnsInIndex

    /**
     * Get max columns in order by
     *
     * @return
     */
    fun getMaxColumnsInOrderBy(): Int = metadata.maxColumnsInOrderBy

    /**
     * Get max columns in select
     *
     * @return
     */
    fun getMaxColumnsInSelect(): Int = metadata.maxColumnsInSelect

    /**
     * Get max columns in table
     *
     * @return
     */
    fun getMaxColumnsInTable(): Int = metadata.maxColumnsInTable

    /**
     * Get max connections
     *
     * @return
     */
    fun getMaxConnections(): Int = metadata.maxConnections

    /**
     * Get max cursor name length
     *
     * @return
     */
    fun getMaxCursorNameLength(): Int = metadata.maxCursorNameLength

    /**
     * Get max index length
     *
     * @return
     */
    fun getMaxIndexLength(): Int = metadata.maxIndexLength

    /**
     * Get max schema name length
     *
     * @return
     */
    fun getMaxSchemaNameLength(): Int = metadata.maxSchemaNameLength

    /**
     * Get max procedure name length
     *
     * @return
     */
    fun getMaxProcedureNameLength(): Int = metadata.maxProcedureNameLength

    /**
     * Get max catalog name length
     *
     * @return
     */
    fun getMaxCatalogNameLength(): Int = metadata.maxCatalogNameLength

    /**
     * Get max row size
     *
     * @return
     */
    fun getMaxRowSize(): Int = metadata.maxRowSize

    /**
     * Get max statement length
     *
     * @return
     */
    fun getMaxStatementLength(): Int = metadata.maxStatementLength

    /**
     * Get max statements
     *
     * @return
     */
    fun getMaxStatements(): Int = metadata.maxStatements

    /**
     * Get max table name length
     *
     * @return
     */
    fun getMaxTableNameLength(): Int = metadata.maxTableNameLength

    /**
     * Get max tables in select
     *
     * @return
     */
    fun getMaxTablesInSelect(): Int = metadata.maxTablesInSelect

    /**
     * Get max username length
     *
     * @return
     */
    fun getMaxUserNameLength(): Int = metadata.maxUserNameLength

    /**
     * Get max logical lob size
     *
     * @return
     */
    fun getMaxLogicalLobSize(): Long = metadata.maxLogicalLobSize

    /**
     * Get numeric function names
     *
     * @return
     */
    fun getNumericFunctions(): List<String> = metadata.numericFunctions.split(separator)

    /**
     * Get procedures based on specified [namePattern] as well as [defaultCatalog] and [defaultSchema]
     *
     * @param namePattern
     * @return
     */
    @JvmOverloads
    fun getProcedures(namePattern: String? = null): List<Procedure> =
        getIterableFromRs(
            metadata, metadata.getProcedures(defaultCatalog, defaultSchema, namePattern)
        ) { m, rs -> Procedure(m, rs) }

    /**
     * Get procedures. If not specified, [catalog] defaults to [defaultCatalog]
     * and [schemaPattern] defaults to [defaultSchema]
     *
     * @param catalog
     * @param schemaPattern
     * @param namePattern
     * @return
     */
    fun getProcedures(catalog: String? = defaultCatalog,
                      schemaPattern: String? = defaultSchema,
                      namePattern: String? = null): List<Procedure> = getIterableFromRs(
                          metadata, metadata.getProcedures(catalog, schemaPattern, namePattern)
                      ) { m, rs -> Procedure(m, rs) }

    /**
     * Get procedure term
     *
     * @return
     */
    fun getProcedureTerm(): String = metadata.procedureTerm

    /**
     * Get result set holdability
     *
     * @return
     */
    fun getResultSetHoldability(): ResultSetHoldability = valueOf(metadata.resultSetHoldability)

    /**
     * Get row id lifetime
     *
     * @return
     */
    fun getRowIdLifetime(): RowIdLifetime = metadata.rowIdLifetime

    /**
     * Get schemas
     *
     * @return
     */
    fun getSchemas(): List<Schema> = getIterableFromRs(metadata.schemas) { Schema(it) }

    /**
     * Get schema term
     *
     * @return
     */
    fun getSchemaTerm(): String = metadata.schemaTerm

    /**
     * Get search string escape
     *
     * @return
     */
    fun getSearchStringEscape(): String = metadata.searchStringEscape

    /**
     * Get SQL keywords
     *
     * @return
     */
    fun getSQLKeywords(): List<String> = metadata.sqlKeywords.split(separator)

    /**
     * Get SQL state type
     *
     * @return
     */
    fun getSQLStateType(): SQLStateType = valueOf(metadata.sqlStateType)

    /**
     * Get string function names
     *
     * @return
     */
    fun getStringFunctions(): List<String> = metadata.stringFunctions.split(separator)

    /**
     * Get system function names
     *
     * @return
     */
    fun getSystemFunctions(): List<String> = metadata.systemFunctions.split(separator)

    /**
     * Get tables with specified [tableNamePattern] and [types], as well as
     * [defaultCatalog] and [defaultSchema]
     *
     * @param tableNamePattern
     * @param types
     */
    @JvmOverloads
    fun getTables(tableNamePattern: String? = null, types: Array<String>? = null): List<Table> =
        getIterableFromRs(
            metadata, metadata.getTables(defaultCatalog, defaultSchema, tableNamePattern, types)
        ) { md, r -> Table(md, r) }

    /**
     * Get tables. If not specified, [catalog] defaults to [defaultCatalog]
     * and [schemaPattern] defaults to [defaultSchema]
     *
     * @param catalog
     * @param schemaPattern
     * @param tableNamePattern
     * @param types
     * @return
     */
    fun getTables(
        catalog: String? = defaultCatalog,
        schemaPattern: String? = defaultSchema,
        tableNamePattern: String? = null,
        types: Array<String>? = null,
    ): List<Table> = getIterableFromRs(
        metadata, metadata.getTables(catalog, schemaPattern, tableNamePattern, types)
    ) { md, r -> Table(md, r) }

    /**
     * Get table types
     *
     * @return
     */
    fun getTableTypes(): List<String> {
        return getIterableFromRs(
            metadata.tableTypes
        ) { it.getString("TABLE_TYPE") }
    }

    /**
     * Get time date function names
     *
     * @return
     */
    fun getTimeDateFunctions(): List<String> = metadata.timeDateFunctions.split(separator)


    /**
     * Get type info
     *
     * @return
     */
    fun getTypeInfo(): List<TypeInfo> {
        return getIterableFromRs(metadata.typeInfo) { TypeInfo(it) }
    }

    /**
     * Get URL for database connection
     *
     * @return
     */
    fun getURL(): String = metadata.url

    /**
     * Get user defined types based on specified [namePattern] and [types]
     * as well as [defaultCatalog] and [defaultSchema]
     *
     * @param namePattern
     * @param types
     * @return
     */
    @JvmOverloads
    fun getUserDefinedTypes(namePattern: String? = null,
                            types: Array<JDBCType>? = null): List<UserDefinedType> {
        return getIterableFromRs(
            metadata, metadata.getUDTs(defaultCatalog, defaultSchema, namePattern, types?.map { it.vendorTypeNumber }?.toIntArray())
        ) { m, x -> UserDefinedType(m, x) }
    }

    /**
     * Get user defined types. If not specified, [catalog] defaults to [defaultCatalog]
     * and [schemaPattern] defaults to [defaultSchema]
     *
     * @param catalog
     * @param schemaPattern
     * @param namePattern
     * @param types
     * @return
     */
    fun getUserDefinedTypes(
        catalog: String? = defaultCatalog,
        schemaPattern: String? = defaultSchema,
        namePattern: String? = null,
        types: Array<JDBCType>? = null,
    ): List<UserDefinedType> {
        return getIterableFromRs(
            metadata, metadata.getUDTs(catalog, schemaPattern, namePattern, types?.map { it.vendorTypeNumber }?.toIntArray())
        ) { m, x -> UserDefinedType(m, x) }
    }

    /**
     * Get username
     *
     * @return
     */
    fun getUserName(): String = metadata.userName

    /**
     * Inserts are detected
     *
     * @param resultSetType
     * @return
     */
    fun insertsAreDetected(resultSetType: ResultSetType): Boolean = metadata.insertsAreDetected(resultSetType.value)

    /**
     * Is catalog at start
     *
     * @return
     */
    fun isCatalogAtStart(): Boolean = metadata.isCatalogAtStart

    /**
     * Is read only
     *
     * @return
     */
    fun isReadOnly(): Boolean = metadata.isReadOnly

    /**
     * Locators update copy
     *
     * @return
     */
    fun locatorsUpdateCopy(): Boolean = metadata.locatorsUpdateCopy()

    /**
     * Nulls are sorted at end
     *
     * @return
     */
    fun nullsAreSortedAtEnd(): Boolean = metadata.nullsAreSortedAtEnd()

    /**
     * Nulls are sorted at start
     *
     * @return
     */
    fun nullsAreSortedAtStart(): Boolean = metadata.nullsAreSortedAtStart()

    /**
     * Nulls are sorted high
     *
     * @return
     */
    fun nullsAreSortedHigh(): Boolean = metadata.nullsAreSortedHigh()

    /**
     * Nulls are sorted low
     *
     * @return
     */
    fun nullsAreSortedLow(): Boolean = metadata.nullsAreSortedLow()

    /**
     * Null plus non null is null
     *
     * @return
     */
    fun nullPlusNonNullIsNull(): Boolean = metadata.nullPlusNonNullIsNull()

    /**
     * Others updates are visible
     *
     * @param resultSetType
     * @return
     */
    fun othersUpdatesAreVisible(resultSetType: ResultSetType): Boolean =
        metadata.othersUpdatesAreVisible(resultSetType.value)

    /**
     * Others deletes are visible
     *
     * @param resultSetType
     * @return
     */
    fun othersDeletesAreVisible(resultSetType: ResultSetType): Boolean =
        metadata.othersDeletesAreVisible(resultSetType.value)

    /**
     * Others inserts are visible
     *
     * @param resultSetType
     * @return
     */
    fun othersInsertsAreVisible(resultSetType: ResultSetType): Boolean =
        metadata.othersInsertsAreVisible(resultSetType.value)

    /**
     * Own updates are visible
     *
     * @param resultSetType
     * @return
     */
    fun ownUpdatesAreVisible(resultSetType: ResultSetType): Boolean = metadata.ownUpdatesAreVisible(resultSetType.value)

    /**
     * Own deletes are visible
     *
     * @param resultSetType
     * @return
     */
    fun ownDeletesAreVisible(resultSetType: ResultSetType): Boolean = metadata.ownDeletesAreVisible(resultSetType.value)

    /**
     * Own inserts are visible
     *
     * @param resultSetType
     * @return
     */
    fun ownInsertsAreVisible(resultSetType: ResultSetType): Boolean = metadata.ownInsertsAreVisible(resultSetType.value)

    /**
     * Stores upper case identifiers
     *
     * @return
     */
    fun storesUpperCaseIdentifiers(): Boolean = metadata.storesUpperCaseIdentifiers()

    /**
     * Stores lower case identifiers
     *
     * @return
     */
    fun storesLowerCaseIdentifiers(): Boolean = metadata.storesLowerCaseIdentifiers()

    /**
     * Stores mixed case identifiers
     *
     * @return
     */
    fun storesMixedCaseIdentifiers(): Boolean = metadata.storesMixedCaseIdentifiers()

    /**
     * Stores upper case quoted identifiers
     *
     * @return
     */
    fun storesUpperCaseQuotedIdentifiers(): Boolean = metadata.storesUpperCaseQuotedIdentifiers()

    /**
     * Stores lower case quoted identifiers
     *
     * @return
     */
    fun storesLowerCaseQuotedIdentifiers(): Boolean = metadata.storesLowerCaseQuotedIdentifiers()

    /**
     * Stores mixed case quoted identifiers
     *
     * @return
     */
    fun storesMixedCaseQuotedIdentifiers(): Boolean = metadata.storesMixedCaseQuotedIdentifiers()

    /**
     * Supports alter table with add column
     *
     * @return
     */
    fun supportsAlterTableWithAddColumn(): Boolean = metadata.supportsAlterTableWithAddColumn()

    /**
     * Supports alter table with drop column
     *
     * @return
     */
    fun supportsAlterTableWithDropColumn(): Boolean = metadata.supportsAlterTableWithDropColumn()

    /**
     * Supports a n s i92entry level s q l
     *
     * @return
     */
    fun supportsANSI92EntryLevelSQL(): Boolean = metadata.supportsANSI92EntryLevelSQL()

    /**
     * Supports a n s i92intermediate s q l
     *
     * @return
     */
    fun supportsANSI92IntermediateSQL(): Boolean = metadata.supportsANSI92IntermediateSQL()

    /**
     * Supports a n s i92full s q l
     *
     * @return
     */
    fun supportsANSI92FullSQL(): Boolean = metadata.supportsANSI92FullSQL()

    /**
     * Supports batch updates
     *
     * @return
     */
    fun supportsBatchUpdates(): Boolean = metadata.supportsBatchUpdates()

    /**
     * Supports catalogs in data manipulation
     *
     * @return
     */
    fun supportsCatalogsInDataManipulation(): Boolean = metadata.supportsCatalogsInDataManipulation()

    /**
     * Supports catalogs in procedure calls
     *
     * @return
     */
    fun supportsCatalogsInProcedureCalls(): Boolean = metadata.supportsCatalogsInProcedureCalls()

    /**
     * Supports catalogs in table definitions
     *
     * @return
     */
    fun supportsCatalogsInTableDefinitions(): Boolean = metadata.supportsCatalogsInTableDefinitions()

    /**
     * Supports catalogs in index definitions
     *
     * @return
     */
    fun supportsCatalogsInIndexDefinitions(): Boolean = metadata.supportsCatalogsInIndexDefinitions()

    /**
     * Supports catalogs in privilege definitions
     *
     * @return
     */
    fun supportsCatalogsInPrivilegeDefinitions(): Boolean = metadata.supportsCatalogsInPrivilegeDefinitions()

    /**
     * Supports column aliasing
     *
     * @return
     */
    fun supportsColumnAliasing(): Boolean = metadata.supportsColumnAliasing()

    /**
     * Supports convert
     *
     * @return
     */
    fun supportsConvert(): Boolean = metadata.supportsConvert()

    /**
     * Supports convert
     *
     * @param fromType
     * @param toType
     * @return
     */
    fun supportsConvert(fromType: JDBCType, toType: JDBCType): Boolean =
        metadata.supportsConvert(fromType.vendorTypeNumber, toType.vendorTypeNumber)

    /**
     * Supports correlated subqueries
     *
     * @return
     */
    fun supportsCorrelatedSubqueries(): Boolean = metadata.supportsCorrelatedSubqueries()

    /**
     * Supports core s q l grammar
     *
     * @return
     */
    fun supportsCoreSQLGrammar(): Boolean = metadata.supportsCoreSQLGrammar()

    /**
     * Supports data definition and data manipulation transactions
     *
     * @return
     */
    fun supportsDataDefinitionAndDataManipulationTransactions(): Boolean =
        metadata.supportsDataDefinitionAndDataManipulationTransactions()

    /**
     * Supports data manipulation transactions only
     *
     * @return
     */
    fun supportsDataManipulationTransactionsOnly(): Boolean = metadata.supportsDataManipulationTransactionsOnly()

    /**
     * Supports different table correlation names
     *
     * @return
     */
    fun supportsDifferentTableCorrelationNames(): Boolean = metadata.supportsDifferentTableCorrelationNames()

    /**
     * Supports extended s q l grammar
     *
     * @return
     */
    fun supportsExtendedSQLGrammar(): Boolean = metadata.supportsExtendedSQLGrammar()

    /**
     * Supports expressions in order by
     *
     * @return
     */
    fun supportsExpressionsInOrderBy(): Boolean = metadata.supportsExpressionsInOrderBy()

    /**
     * Supports full outer joins
     *
     * @return
     */
    fun supportsFullOuterJoins(): Boolean = metadata.supportsFullOuterJoins()

    /**
     * Supports get generated keys
     *
     * @return
     */
    fun supportsGetGeneratedKeys(): Boolean = metadata.supportsGetGeneratedKeys()

    /**
     * Supports group by
     *
     * @return
     */
    fun supportsGroupBy(): Boolean = metadata.supportsGroupBy()

    /**
     * Supports group by unrelated
     *
     * @return
     */
    fun supportsGroupByUnrelated(): Boolean = metadata.supportsGroupByUnrelated()

    /**
     * Supports group by beyond select
     *
     * @return
     */
    fun supportsGroupByBeyondSelect(): Boolean = metadata.supportsGroupByBeyondSelect()

    /**
     * Supports integrity enhancement facility
     *
     * @return
     */
    fun supportsIntegrityEnhancementFacility(): Boolean = metadata.supportsIntegrityEnhancementFacility()

    /**
     * Supports like escape clause
     *
     * @return
     */
    fun supportsLikeEscapeClause(): Boolean = metadata.supportsLikeEscapeClause()

    /**
     * Supports limited outer joins
     *
     * @return
     */
    fun supportsLimitedOuterJoins(): Boolean = metadata.supportsLimitedOuterJoins()

    /**
     * Supports minimum s q l grammar
     *
     * @return
     */
    fun supportsMinimumSQLGrammar(): Boolean = metadata.supportsMinimumSQLGrammar()

    /**
     * Supports mixed case identifiers
     *
     * @return
     */
    fun supportsMixedCaseIdentifiers(): Boolean = metadata.supportsMixedCaseIdentifiers()

    /**
     * Supports mixed case quoted identifiers
     *
     * @return
     */
    fun supportsMixedCaseQuotedIdentifiers(): Boolean = metadata.supportsMixedCaseQuotedIdentifiers()

    /**
     * Supports multiple result sets
     *
     * @return
     */
    fun supportsMultipleResultSets(): Boolean = metadata.supportsMultipleResultSets()

    /**
     * Supports multiple transactions
     *
     * @return
     */
    fun supportsMultipleTransactions(): Boolean = metadata.supportsMultipleTransactions()

    /**
     * Supports multiple open results
     *
     * @return
     */
    fun supportsMultipleOpenResults(): Boolean = metadata.supportsMultipleOpenResults()

    /**
     * Supports named parameters
     *
     * @return
     */
    fun supportsNamedParameters(): Boolean = metadata.supportsNamedParameters()

    /**
     * Supports non nullable columns
     *
     * @return
     */
    fun supportsNonNullableColumns(): Boolean = metadata.supportsNonNullableColumns()

    /**
     * Supports open cursors across commit
     *
     * @return
     */
    fun supportsOpenCursorsAcrossCommit(): Boolean = metadata.supportsOpenCursorsAcrossCommit()

    /**
     * Supports open cursors across rollback
     *
     * @return
     */
    fun supportsOpenCursorsAcrossRollback(): Boolean = metadata.supportsOpenCursorsAcrossRollback()

    /**
     * Supports open statements across commit
     *
     * @return
     */
    fun supportsOpenStatementsAcrossCommit(): Boolean = metadata.supportsOpenStatementsAcrossCommit()

    /**
     * Supports open statements across rollback
     *
     * @return
     */
    fun supportsOpenStatementsAcrossRollback(): Boolean = metadata.supportsOpenStatementsAcrossRollback()

    /**
     * Supports order by unrelated
     *
     * @return
     */
    fun supportsOrderByUnrelated(): Boolean = metadata.supportsOrderByUnrelated()

    /**
     * Supports outer joins
     *
     * @return
     */
    fun supportsOuterJoins(): Boolean = metadata.supportsOuterJoins()

    /**
     * Supports positioned delete
     *
     * @return
     */
    fun supportsPositionedDelete(): Boolean = metadata.supportsPositionedDelete()

    /**
     * Supports positioned update
     *
     * @return
     */
    fun supportsPositionedUpdate(): Boolean = metadata.supportsPositionedUpdate()

    /**
     * Supports ref cursors
     *
     * @return
     */
    fun supportsRefCursors(): Boolean = metadata.supportsRefCursors()

    /**
     * Supports result set concurrency
     *
     * @param resultSetType
     * @param resultSetConcurrency
     * @return
     */
    fun supportsResultSetConcurrency(
        resultSetType: ResultSetType, resultSetConcurrency: ResultSetConcurrency,
    ): Boolean = metadata.supportsResultSetConcurrency(resultSetType.value, resultSetConcurrency.value)

    /**
     * Supports result set holdability
     *
     * @param resultSetHoldability
     * @return
     */
    fun supportsResultSetHoldability(resultSetHoldability: ResultSetHoldability): Boolean =
        metadata.supportsResultSetHoldability(resultSetHoldability.value)

    /**
     * Supports result set type
     *
     * @param resultSetType
     * @return
     */
    fun supportsResultSetType(resultSetType: ResultSetType): Boolean =
        metadata.supportsResultSetType(resultSetType.value)

    /**
     * Supports savepoints
     *
     * @return
     */
    fun supportsSavepoints(): Boolean = metadata.supportsSavepoints()

    /**
     * Supports sharding
     *
     * @return
     */
    fun supportsSharding(): Boolean = metadata.supportsSharding()

    /**
     * Supports statement pooling
     *
     * @return
     */
    fun supportsStatementPooling(): Boolean = metadata.supportsStatementPooling()

    /**
     * Supports stored functions using call syntax
     *
     * @return
     */
    fun supportsStoredFunctionsUsingCallSyntax(): Boolean = metadata.supportsStoredFunctionsUsingCallSyntax()

    /**
     * Supports schemas in data manipulation
     *
     * @return
     */
    fun supportsSchemasInDataManipulation(): Boolean = metadata.supportsSchemasInDataManipulation()

    /**
     * Supports schemas in procedure calls
     *
     * @return
     */
    fun supportsSchemasInProcedureCalls(): Boolean = metadata.supportsSchemasInProcedureCalls()

    /**
     * Supports schemas in table definitions
     *
     * @return
     */
    fun supportsSchemasInTableDefinitions(): Boolean = metadata.supportsSchemasInTableDefinitions()

    /**
     * Supports schemas in index definitions
     *
     * @return
     */
    fun supportsSchemasInIndexDefinitions(): Boolean = metadata.supportsSchemasInIndexDefinitions()

    /**
     * Supports schemas in privilege definitions
     *
     * @return
     */
    fun supportsSchemasInPrivilegeDefinitions(): Boolean = metadata.supportsSchemasInPrivilegeDefinitions()

    /**
     * Supports select for update
     *
     * @return
     */
    fun supportsSelectForUpdate(): Boolean = metadata.supportsSelectForUpdate()

    /**
     * Supports stored procedures
     *
     * @return
     */
    fun supportsStoredProcedures(): Boolean = metadata.supportsStoredProcedures()

    /**
     * Supports subqueries in comparisons
     *
     * @return
     */
    fun supportsSubqueriesInComparisons(): Boolean = metadata.supportsSubqueriesInComparisons()

    /**
     * Supports subqueries in exists
     *
     * @return
     */
    fun supportsSubqueriesInExists(): Boolean = metadata.supportsSubqueriesInExists()

    /**
     * Supports subqueries in ins
     *
     * @return
     */
    fun supportsSubqueriesInIns(): Boolean = metadata.supportsSubqueriesInIns()

    /**
     * Supports subqueries in quantifieds
     *
     * @return
     */
    fun supportsSubqueriesInQuantifieds(): Boolean = metadata.supportsSubqueriesInQuantifieds()

    /**
     * Supports table correlation names
     *
     * @return
     */
    fun supportsTableCorrelationNames(): Boolean = metadata.supportsTableCorrelationNames()

    /**
     * Supports transactions
     *
     * @return
     */
    fun supportsTransactions(): Boolean = metadata.supportsTransactions()

    /**
     * Supports transaction isolation level
     *
     * @param transactionIsolation
     * @return
     */
    fun supportsTransactionIsolationLevel(transactionIsolation: TransactionIsolation): Boolean =
        metadata.supportsTransactionIsolationLevel(transactionIsolation.value)

    /**
     * Supports union
     *
     * @return
     */
    fun supportsUnion(): Boolean = metadata.supportsUnion()

    /**
     * Supports union all
     *
     * @return
     */
    fun supportsUnionAll(): Boolean = metadata.supportsUnionAll()

    /**
     * Updates are detected
     *
     * @param resultSetType
     * @return
     */
    fun updatesAreDetected(resultSetType: ResultSetType): Boolean = metadata.updatesAreDetected(resultSetType.value)

    /**
     * Uses local file per table
     *
     * @return
     */
    fun usesLocalFilePerTable(): Boolean = metadata.usesLocalFilePerTable()

    /**
     * Uses local files
     *
     * @return
     */
    fun usesLocalFiles(): Boolean = metadata.usesLocalFiles()
}