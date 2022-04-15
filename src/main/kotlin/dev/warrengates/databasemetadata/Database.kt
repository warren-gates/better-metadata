package dev.warrengates.databasemetadata

import java.sql.Connection
import java.sql.DatabaseMetaData
import java.sql.JDBCType
import java.sql.RowIdLifetime


/**
 * Database provides a wrapper around [DatabaseMetaData]. Where [DatabaseMetaData]
 * returns [java.sql.ResultSet]s this wrapper returns a [List] of appropriate objects
 *
 * @property metaData the wrapped [DatabaseMetaData]
 * @property defaultCatalog a default catalog filter used in methods such as [getTables]
 * @property defaultSchema
 * @constructor Create empty Database
 */
@Suppress("unused", "MemberVisibilityCanBePrivate")
class Database @JvmOverloads constructor(
    private val metaData: DatabaseMetaData,
    val defaultCatalog: String? = null,
    val defaultSchema: String? = null,
) {

    private val separator = ","

    /**
     * All procedures are callable
     *
     * @return
     */// https://docs.oracle.com/en/java/javase/17/docs/api/java.sql/java/sql/DatabaseMetaData.html
    fun allProceduresAreCallable(): Boolean = metaData.allProceduresAreCallable()

    /**
     * All tables are selectable
     *
     * @return
     */
    fun allTablesAreSelectable(): Boolean = metaData.allTablesAreSelectable()

    /**
     * Auto commit failure closes all result sets
     *
     * @return
     */
    fun autoCommitFailureClosesAllResultSets(): Boolean = metaData.autoCommitFailureClosesAllResultSets()

    /**
     * Data definition causes transaction commit
     *
     * @return
     */
    fun dataDefinitionCausesTransactionCommit(): Boolean = metaData.dataDefinitionCausesTransactionCommit()

    /**
     * Data definition ignored in transactions
     *
     * @return
     */
    fun dataDefinitionIgnoredInTransactions(): Boolean = metaData.dataDefinitionIgnoredInTransactions()

    /**
     * Deletes are detected
     *
     * @param resultSetType
     * @return
     */
    fun deletesAreDetected(resultSetType: ResultSetType): Boolean = metaData.deletesAreDetected(resultSetType.type)

    /**
     * Does max row size include blobs
     *
     * @return
     */
    fun doesMaxRowSizeIncludeBlobs(): Boolean = metaData.doesMaxRowSizeIncludeBlobs()

    /**
     * Generated key always returned
     *
     * @return
     */
    fun generatedKeyAlwaysReturned(): Boolean = metaData.generatedKeyAlwaysReturned()

    /**
     * Get catalogs
     *
     * @return
     */
    fun getCatalogs(): List<Catalog> = getIterableFromRs(metaData.catalogs) { Catalog(it) }

    /**
     * Get catalog separator
     *
     * @return
     */
    fun getCatalogSeparator(): String = metaData.catalogSeparator

    /**
     * Get catalog term
     *
     * @return
     */
    fun getCatalogTerm(): String = metaData.catalogTerm

    /**
     * Get client info properties
     *
     * @return
     */
    fun getClientInfoProperties(): List<ClientInfoProperties> =
        getIterableFromRs(metaData.clientInfoProperties) { ClientInfoProperties(it) }

    /**
     * Get connection
     *
     * @return
     */
    fun getConnection(): Connection = metaData.connection

    /**
     * Get database major version
     *
     * @return
     */
    fun getDatabaseMajorVersion(): Int = metaData.databaseMajorVersion

    /**
     * Get database minor version
     *
     * @return
     */
    fun getDatabaseMinorVersion(): Int = metaData.databaseMinorVersion

    /**
     * Get database product name
     *
     * @return
     */
    fun getDatabaseProductName(): String = metaData.databaseProductName

    /**
     * Get database product version
     *
     * @return
     */
    fun getDatabaseProductVersion(): String = metaData.databaseProductVersion

    /**
     * Get default transaction isolation
     *
     * @return
     */
    fun getDefaultTransactionIsolation(): TransactionIsolation = valueOf(metaData.defaultTransactionIsolation)

    /**
     * Get driver name
     *
     * @return
     */
    fun getDriverName(): String = metaData.driverName

    /**
     * Get driver version
     *
     * @return
     */
    fun getDriverVersion(): String = metaData.driverVersion

    /**
     * Get driver major version
     *
     * @return
     */
    fun getDriverMajorVersion(): Int = metaData.driverMajorVersion

    /**
     * Get driver minor version
     *
     * @return
     */
    fun getDriverMinorVersion(): Int = metaData.driverMinorVersion

    /**
     * Get extra name characters
     *
     * @return
     */
    fun getExtraNameCharacters(): String = metaData.extraNameCharacters

    /**
     * Gets functions using the [catalog], [schemaPattern], and [namePattern]
     * to filter results
     *
     * @param catalog
     * @param schemaPattern
     * @param namePattern
     * @return List<[Function]>
     */
    @JvmOverloads
    fun getFunctions(catalog: String? = defaultCatalog,
                     schemaPattern: String? = defaultSchema,
                     namePattern: String? = null): List<Function> {
        return getIterableFromRs(
            metaData, metaData.getFunctions(catalog, schemaPattern, namePattern)
        ) { md, r -> Function(md, r) }
    }

    /**
     * Get functions
     *
     * @param schema
     * @param namePattern
     * @return
     */
    @JvmOverloads
    fun getFunctions(schema: Schema,
                     namePattern: String? = null): List<Function> {
        return getFunctions(schema.catalog, schema.name, namePattern)
    }

    /**
     * Get identifier quote string
     *
     * @return
     */
    fun getIdentifierQuoteString(): String = metaData.identifierQuoteString

    /**
     * Get j d b c major version
     *
     * @return
     */
    fun getJDBCMajorVersion(): Int = metaData.jdbcMajorVersion

    /**
     * Get j d b c minor version
     *
     * @return
     */
    fun getJDBCMinorVersion(): Int = metaData.jdbcMinorVersion

    /**
     * Get max binary literal length
     *
     * @return
     */
    fun getMaxBinaryLiteralLength(): Int = metaData.maxBinaryLiteralLength

    /**
     * Get max char literal length
     *
     * @return
     */
    fun getMaxCharLiteralLength(): Int = metaData.maxCharLiteralLength

    /**
     * Get max column name length
     *
     * @return
     */
    fun getMaxColumnNameLength(): Int = metaData.maxColumnNameLength

    /**
     * Get max columns in group by
     *
     * @return
     */
    fun getMaxColumnsInGroupBy(): Int = metaData.maxColumnsInGroupBy

    /**
     * Get max columns in index
     *
     * @return
     */
    fun getMaxColumnsInIndex(): Int = metaData.maxColumnsInIndex

    /**
     * Get max columns in order by
     *
     * @return
     */
    fun getMaxColumnsInOrderBy(): Int = metaData.maxColumnsInOrderBy

    /**
     * Get max columns in select
     *
     * @return
     */
    fun getMaxColumnsInSelect(): Int = metaData.maxColumnsInSelect

    /**
     * Get max columns in table
     *
     * @return
     */
    fun getMaxColumnsInTable(): Int = metaData.maxColumnsInTable

    /**
     * Get max connections
     *
     * @return
     */
    fun getMaxConnections(): Int = metaData.maxConnections

    /**
     * Get max cursor name length
     *
     * @return
     */
    fun getMaxCursorNameLength(): Int = metaData.maxCursorNameLength

    /**
     * Get max index length
     *
     * @return
     */
    fun getMaxIndexLength(): Int = metaData.maxIndexLength

    /**
     * Get max schema name length
     *
     * @return
     */
    fun getMaxSchemaNameLength(): Int = metaData.maxSchemaNameLength

    /**
     * Get max procedure name length
     *
     * @return
     */
    fun getMaxProcedureNameLength(): Int = metaData.maxProcedureNameLength

    /**
     * Get max catalog name length
     *
     * @return
     */
    fun getMaxCatalogNameLength(): Int = metaData.maxCatalogNameLength

    /**
     * Get max row size
     *
     * @return
     */
    fun getMaxRowSize(): Int = metaData.maxRowSize

    /**
     * Get max statement length
     *
     * @return
     */
    fun getMaxStatementLength(): Int = metaData.maxStatementLength

    /**
     * Get max statements
     *
     * @return
     */
    fun getMaxStatements(): Int = metaData.maxStatements

    /**
     * Get max table name length
     *
     * @return
     */
    fun getMaxTableNameLength(): Int = metaData.maxTableNameLength

    /**
     * Get max tables in select
     *
     * @return
     */
    fun getMaxTablesInSelect(): Int = metaData.maxTablesInSelect

    /**
     * Get max username length
     *
     * @return
     */
    fun getMaxUserNameLength(): Int = metaData.maxUserNameLength

    /**
     * Get max logical lob size
     *
     * @return
     */
    fun getMaxLogicalLobSize(): Long = metaData.maxLogicalLobSize

    /**
     * Get numeric functions
     *
     * @return
     */
    fun getNumericFunctions(): List<NumericFunction> = metaData.numericFunctions.split(separator).map { NumericFunction(it) }

    /**
     * Get procedures
     *
     * @param catalog
     * @param schemaPattern
     * @param namePattern
     * @return
     */
    @JvmOverloads
    fun getProcedures(catalog: String? = defaultCatalog,
                      schemaPattern: String? = defaultSchema,
                      namePattern: String? = null): List<Procedure> {
        return getIterableFromRs(
            metaData, metaData.getProcedures(catalog, schemaPattern, namePattern)
        ) { m, rs -> Procedure(m, rs) }
    }


    /**
     * Get procedures
     *
     * @param schema
     * @param namePattern
     * @return
     */
    @JvmOverloads
    fun getProcedures(schema: Schema,
                    namePattern: String? = null): List<Procedure> {
        return getProcedures(schema.catalog, schema.name, namePattern)
    }

    /**
     * Get procedure term
     *
     * @return
     */
    fun getProcedureTerm(): String = metaData.procedureTerm

    /**
     * Get result set holdability
     *
     * @return
     */
    fun getResultSetHoldability(): ResultSetHoldability = valueOf(metaData.resultSetHoldability)

    /**
     * Get row id lifetime
     *
     * @return
     */
    fun getRowIdLifetime(): RowIdLifetime = metaData.rowIdLifetime

    /**
     * Get schemas
     *
     * @return
     */
    fun getSchemas(): List<Schema> = getIterableFromRs(metaData.schemas) { Schema(it) }

    /**
     * Get schema term
     *
     * @return
     */
    fun getSchemaTerm(): String = metaData.schemaTerm

    /**
     * Get search string escape
     *
     * @return
     */
    fun getSearchStringEscape(): String = metaData.searchStringEscape

    /**
     * Get s q l keywords
     *
     * @return
     */
    fun getSQLKeywords(): List<SQLKeyword> = metaData.sqlKeywords.split(separator).map { SQLKeyword(it) }

    /**
     * Get s q l state type
     *
     * @return
     */
    fun getSQLStateType(): SQLStateType = valueOf(metaData.sqlStateType)

    /**
     * Get string functions
     *
     * @return
     */
    fun getStringFunctions(): List<StringFunction> = metaData.stringFunctions.split(separator).map { StringFunction(it) }

    /**
     * Get super tables
     *
     * @param catalog
     * @param schemaPattern
     * @param tableNamePattern
     * @return
     */
    @JvmOverloads
    fun getSuperTables(catalog: String? = defaultCatalog,
                       schemaPattern: String? = defaultSchema,
                       tableNamePattern: String? = null): List<Table> {
        return getIterableFromRs(
            metaData, metaData.getSuperTables(catalog, schemaPattern, tableNamePattern)
        ) { m, rs -> Table(m, rs) }
    }


    /**
     * Get super tables
     *
     * @param schema
     * @param tableNamePattern
     * @return
     */
    @JvmOverloads
    fun getSuperTables(schema: Schema, tableNamePattern: String? = null): List<Table> {
        return getSuperTables(schema.catalog, schema.name, tableNamePattern)
    }

    /**
     * Get super types
     *
     * @param catalog
     * @param schemaPattern
     * @param typeNamePattern
     * @return
     */
    @JvmOverloads
    fun getSuperTypes(catalog: String? = defaultCatalog,
                      schemaPattern: String? = defaultSchema,
                      typeNamePattern: String? = null): List<SuperType> {
        return getIterableFromRs(
            metaData.getSuperTypes(catalog, schemaPattern, typeNamePattern)
        ) { SuperType(it) }
    }


    /**
     * Get super types
     *
     * @param schema
     * @param typeNamePattern
     * @return
     */
    @JvmOverloads
    fun getSuperTypes(schema: Schema,
                      typeNamePattern: String? = null): List<SuperType> {
        return getSuperTypes(schema.catalog, schema.name, typeNamePattern)
    }
    /**
     * Get system functions
     *
     * @return
     */
    fun getSystemFunctions(): List<SystemFunction> = metaData.systemFunctions.split(separator).map { SystemFunction(it) }

    /**
     * Get tables
     *
     * @param catalog
     * @param schemaPattern
     * @param tableNamePattern
     * @param types
     * @return
     */
    @JvmOverloads
    fun getTables(
        catalog: String? = defaultCatalog,
        schemaPattern: String? = defaultSchema,
        tableNamePattern: String? = null,
        types: Array<String>? = null,
    ): List<Table> {
        return getIterableFromRs(
            metaData, metaData.getTables(catalog, schemaPattern, tableNamePattern, types)
        ) { md, r -> Table(md, r) }
    }


    /**
     * Get tables
     *
     * @param schema
     * @param tableNamePattern
     * @param types
     * @return
     */
    @JvmOverloads
    fun getTables(
        schema: Schema,
        tableNamePattern: String? = null,
        types: Array<TableType>? = null,
    ): List<Table> {
        return getTables(schema.catalog, schema.name, tableNamePattern, types?.map { it.name }?.toTypedArray())
    }

    /**
     * Get table types
     *
     * @return
     */
    fun getTableTypes(): List<TableType> {
        return getIterableFromRs(
            metaData.tableTypes
        ) { TableType(it) }
    }

    /**
     * Get time date functions
     *
     * @return
     */
    fun getTimeDateFunctions(): List<TimeDateFunction> =
        metaData.timeDateFunctions.split(separator).map { TimeDateFunction(it) }

    /**
     * Get u r l
     *
     * @return
     */
    fun getURL(): String = metaData.url

    /**
     * Get user defined types
     *
     * @param catalog
     * @param schemaPattern
     * @param namePattern
     * @param types
     * @return
     */
    @JvmOverloads
    fun getUserDefinedTypes(
        catalog: String? = defaultCatalog,
        schemaPattern: String? = defaultSchema,
        namePattern: String? = null,
        types: Array<JDBCType>? = null,
    ): List<UserDefinedType> {
        return getIterableFromRs(
            metaData, metaData.getUDTs(catalog, schemaPattern, namePattern, types?.map { it.vendorTypeNumber }?.toIntArray())
        ) { m, x -> UserDefinedType(m, x) }
    }


    /**
     * Get user defined types
     *
     * @param schema
     * @param namePattern
     * @param types
     * @return
     */
    @JvmOverloads
    fun getUserDefinedTypes(
        schema: Schema,
        namePattern: String? = null,
        types: Array<JDBCType>? = null,
    ): List<UserDefinedType> {
        return getUserDefinedTypes(schema.catalog, schema.name, namePattern, types)
    }

    /**
     * Get username
     *
     * @return
     */
    fun getUserName(): String = metaData.userName

    /**
     * Inserts are detected
     *
     * @param resultSetType
     * @return
     */
    fun insertsAreDetected(resultSetType: ResultSetType): Boolean = metaData.insertsAreDetected(resultSetType.type)

    /**
     * Is catalog at start
     *
     * @return
     */
    fun isCatalogAtStart(): Boolean = metaData.isCatalogAtStart

    /**
     * Is read only
     *
     * @return
     */
    fun isReadOnly(): Boolean = metaData.isReadOnly

    /**
     * Locators update copy
     *
     * @return
     */
    fun locatorsUpdateCopy(): Boolean = metaData.locatorsUpdateCopy()

    /**
     * Nulls are sorted at end
     *
     * @return
     */
    fun nullsAreSortedAtEnd(): Boolean = metaData.nullsAreSortedAtEnd()

    /**
     * Nulls are sorted at start
     *
     * @return
     */
    fun nullsAreSortedAtStart(): Boolean = metaData.nullsAreSortedAtStart()

    /**
     * Nulls are sorted high
     *
     * @return
     */
    fun nullsAreSortedHigh(): Boolean = metaData.nullsAreSortedHigh()

    /**
     * Nulls are sorted low
     *
     * @return
     */
    fun nullsAreSortedLow(): Boolean = metaData.nullsAreSortedLow()

    /**
     * Null plus non null is null
     *
     * @return
     */
    fun nullPlusNonNullIsNull(): Boolean = metaData.nullPlusNonNullIsNull()

    /**
     * Others updates are visible
     *
     * @param resultSetType
     * @return
     */
    fun othersUpdatesAreVisible(resultSetType: ResultSetType): Boolean =
        metaData.othersUpdatesAreVisible(resultSetType.type)

    /**
     * Others deletes are visible
     *
     * @param resultSetType
     * @return
     */
    fun othersDeletesAreVisible(resultSetType: ResultSetType): Boolean =
        metaData.othersDeletesAreVisible(resultSetType.type)

    /**
     * Others inserts are visible
     *
     * @param resultSetType
     * @return
     */
    fun othersInsertsAreVisible(resultSetType: ResultSetType): Boolean =
        metaData.othersInsertsAreVisible(resultSetType.type)

    /**
     * Own updates are visible
     *
     * @param resultSetType
     * @return
     */
    fun ownUpdatesAreVisible(resultSetType: ResultSetType): Boolean = metaData.ownUpdatesAreVisible(resultSetType.type)

    /**
     * Own deletes are visible
     *
     * @param resultSetType
     * @return
     */
    fun ownDeletesAreVisible(resultSetType: ResultSetType): Boolean = metaData.ownDeletesAreVisible(resultSetType.type)

    /**
     * Own inserts are visible
     *
     * @param resultSetType
     * @return
     */
    fun ownInsertsAreVisible(resultSetType: ResultSetType): Boolean = metaData.ownInsertsAreVisible(resultSetType.type)

    /**
     * Stores upper case identifiers
     *
     * @return
     */
    fun storesUpperCaseIdentifiers(): Boolean = metaData.storesUpperCaseIdentifiers()

    /**
     * Stores lower case identifiers
     *
     * @return
     */
    fun storesLowerCaseIdentifiers(): Boolean = metaData.storesLowerCaseIdentifiers()

    /**
     * Stores mixed case identifiers
     *
     * @return
     */
    fun storesMixedCaseIdentifiers(): Boolean = metaData.storesMixedCaseIdentifiers()

    /**
     * Stores upper case quoted identifiers
     *
     * @return
     */
    fun storesUpperCaseQuotedIdentifiers(): Boolean = metaData.storesUpperCaseQuotedIdentifiers()

    /**
     * Stores lower case quoted identifiers
     *
     * @return
     */
    fun storesLowerCaseQuotedIdentifiers(): Boolean = metaData.storesLowerCaseQuotedIdentifiers()

    /**
     * Stores mixed case quoted identifiers
     *
     * @return
     */
    fun storesMixedCaseQuotedIdentifiers(): Boolean = metaData.storesMixedCaseQuotedIdentifiers()

    /**
     * Supports alter table with add column
     *
     * @return
     */
    fun supportsAlterTableWithAddColumn(): Boolean = metaData.supportsAlterTableWithAddColumn()

    /**
     * Supports alter table with drop column
     *
     * @return
     */
    fun supportsAlterTableWithDropColumn(): Boolean = metaData.supportsAlterTableWithDropColumn()

    /**
     * Supports a n s i92entry level s q l
     *
     * @return
     */
    fun supportsANSI92EntryLevelSQL(): Boolean = metaData.supportsANSI92EntryLevelSQL()

    /**
     * Supports a n s i92intermediate s q l
     *
     * @return
     */
    fun supportsANSI92IntermediateSQL(): Boolean = metaData.supportsANSI92IntermediateSQL()

    /**
     * Supports a n s i92full s q l
     *
     * @return
     */
    fun supportsANSI92FullSQL(): Boolean = metaData.supportsANSI92FullSQL()

    /**
     * Supports batch updates
     *
     * @return
     */
    fun supportsBatchUpdates(): Boolean = metaData.supportsBatchUpdates()

    /**
     * Supports catalogs in data manipulation
     *
     * @return
     */
    fun supportsCatalogsInDataManipulation(): Boolean = metaData.supportsCatalogsInDataManipulation()

    /**
     * Supports catalogs in procedure calls
     *
     * @return
     */
    fun supportsCatalogsInProcedureCalls(): Boolean = metaData.supportsCatalogsInProcedureCalls()

    /**
     * Supports catalogs in table definitions
     *
     * @return
     */
    fun supportsCatalogsInTableDefinitions(): Boolean = metaData.supportsCatalogsInTableDefinitions()

    /**
     * Supports catalogs in index definitions
     *
     * @return
     */
    fun supportsCatalogsInIndexDefinitions(): Boolean = metaData.supportsCatalogsInIndexDefinitions()

    /**
     * Supports catalogs in privilege definitions
     *
     * @return
     */
    fun supportsCatalogsInPrivilegeDefinitions(): Boolean = metaData.supportsCatalogsInPrivilegeDefinitions()

    /**
     * Supports column aliasing
     *
     * @return
     */
    fun supportsColumnAliasing(): Boolean = metaData.supportsColumnAliasing()

    /**
     * Supports convert
     *
     * @return
     */
    fun supportsConvert(): Boolean = metaData.supportsConvert()

    /**
     * Supports convert
     *
     * @param fromType
     * @param toType
     * @return
     */
    fun supportsConvert(fromType: JDBCType, toType: JDBCType): Boolean =
        metaData.supportsConvert(fromType.vendorTypeNumber, toType.vendorTypeNumber)

    /**
     * Supports correlated subqueries
     *
     * @return
     */
    fun supportsCorrelatedSubqueries(): Boolean = metaData.supportsCorrelatedSubqueries()

    /**
     * Supports core s q l grammar
     *
     * @return
     */
    fun supportsCoreSQLGrammar(): Boolean = metaData.supportsCoreSQLGrammar()

    /**
     * Supports data definition and data manipulation transactions
     *
     * @return
     */
    fun supportsDataDefinitionAndDataManipulationTransactions(): Boolean =
        metaData.supportsDataDefinitionAndDataManipulationTransactions()

    /**
     * Supports data manipulation transactions only
     *
     * @return
     */
    fun supportsDataManipulationTransactionsOnly(): Boolean = metaData.supportsDataManipulationTransactionsOnly()

    /**
     * Supports different table correlation names
     *
     * @return
     */
    fun supportsDifferentTableCorrelationNames(): Boolean = metaData.supportsDifferentTableCorrelationNames()

    /**
     * Supports extended s q l grammar
     *
     * @return
     */
    fun supportsExtendedSQLGrammar(): Boolean = metaData.supportsExtendedSQLGrammar()

    /**
     * Supports expressions in order by
     *
     * @return
     */
    fun supportsExpressionsInOrderBy(): Boolean = metaData.supportsExpressionsInOrderBy()

    /**
     * Supports full outer joins
     *
     * @return
     */
    fun supportsFullOuterJoins(): Boolean = metaData.supportsFullOuterJoins()

    /**
     * Supports get generated keys
     *
     * @return
     */
    fun supportsGetGeneratedKeys(): Boolean = metaData.supportsGetGeneratedKeys()

    /**
     * Supports group by
     *
     * @return
     */
    fun supportsGroupBy(): Boolean = metaData.supportsGroupBy()

    /**
     * Supports group by unrelated
     *
     * @return
     */
    fun supportsGroupByUnrelated(): Boolean = metaData.supportsGroupByUnrelated()

    /**
     * Supports group by beyond select
     *
     * @return
     */
    fun supportsGroupByBeyondSelect(): Boolean = metaData.supportsGroupByBeyondSelect()

    /**
     * Supports integrity enhancement facility
     *
     * @return
     */
    fun supportsIntegrityEnhancementFacility(): Boolean = metaData.supportsIntegrityEnhancementFacility()

    /**
     * Supports like escape clause
     *
     * @return
     */
    fun supportsLikeEscapeClause(): Boolean = metaData.supportsLikeEscapeClause()

    /**
     * Supports limited outer joins
     *
     * @return
     */
    fun supportsLimitedOuterJoins(): Boolean = metaData.supportsLimitedOuterJoins()

    /**
     * Supports minimum s q l grammar
     *
     * @return
     */
    fun supportsMinimumSQLGrammar(): Boolean = metaData.supportsMinimumSQLGrammar()

    /**
     * Supports mixed case identifiers
     *
     * @return
     */
    fun supportsMixedCaseIdentifiers(): Boolean = metaData.supportsMixedCaseIdentifiers()

    /**
     * Supports mixed case quoted identifiers
     *
     * @return
     */
    fun supportsMixedCaseQuotedIdentifiers(): Boolean = metaData.supportsMixedCaseQuotedIdentifiers()

    /**
     * Supports multiple result sets
     *
     * @return
     */
    fun supportsMultipleResultSets(): Boolean = metaData.supportsMultipleResultSets()

    /**
     * Supports multiple transactions
     *
     * @return
     */
    fun supportsMultipleTransactions(): Boolean = metaData.supportsMultipleTransactions()

    /**
     * Supports multiple open results
     *
     * @return
     */
    fun supportsMultipleOpenResults(): Boolean = metaData.supportsMultipleOpenResults()

    /**
     * Supports named parameters
     *
     * @return
     */
    fun supportsNamedParameters(): Boolean = metaData.supportsNamedParameters()

    /**
     * Supports non nullable columns
     *
     * @return
     */
    fun supportsNonNullableColumns(): Boolean = metaData.supportsNonNullableColumns()

    /**
     * Supports open cursors across commit
     *
     * @return
     */
    fun supportsOpenCursorsAcrossCommit(): Boolean = metaData.supportsOpenCursorsAcrossCommit()

    /**
     * Supports open cursors across rollback
     *
     * @return
     */
    fun supportsOpenCursorsAcrossRollback(): Boolean = metaData.supportsOpenCursorsAcrossRollback()

    /**
     * Supports open statements across commit
     *
     * @return
     */
    fun supportsOpenStatementsAcrossCommit(): Boolean = metaData.supportsOpenStatementsAcrossCommit()

    /**
     * Supports open statements across rollback
     *
     * @return
     */
    fun supportsOpenStatementsAcrossRollback(): Boolean = metaData.supportsOpenStatementsAcrossRollback()

    /**
     * Supports order by unrelated
     *
     * @return
     */
    fun supportsOrderByUnrelated(): Boolean = metaData.supportsOrderByUnrelated()

    /**
     * Supports outer joins
     *
     * @return
     */
    fun supportsOuterJoins(): Boolean = metaData.supportsOuterJoins()

    /**
     * Supports positioned delete
     *
     * @return
     */
    fun supportsPositionedDelete(): Boolean = metaData.supportsPositionedDelete()

    /**
     * Supports positioned update
     *
     * @return
     */
    fun supportsPositionedUpdate(): Boolean = metaData.supportsPositionedUpdate()

    /**
     * Supports ref cursors
     *
     * @return
     */
    fun supportsRefCursors(): Boolean = metaData.supportsRefCursors()

    /**
     * Supports result set concurrency
     *
     * @param resultSetType
     * @param resultSetConcurrency
     * @return
     */
    fun supportsResultSetConcurrency(
        resultSetType: ResultSetType, resultSetConcurrency: ResultSetConcurrency,
    ): Boolean = metaData.supportsResultSetConcurrency(resultSetType.type, resultSetConcurrency.type)

    /**
     * Supports result set holdability
     *
     * @param resultSetHoldability
     * @return
     */
    fun supportsResultSetHoldability(resultSetHoldability: ResultSetHoldability): Boolean =
        metaData.supportsResultSetHoldability(resultSetHoldability.type)

    /**
     * Supports result set type
     *
     * @param resultSetType
     * @return
     */
    fun supportsResultSetType(resultSetType: ResultSetType): Boolean =
        metaData.supportsResultSetType(resultSetType.type)

    /**
     * Supports savepoints
     *
     * @return
     */
    fun supportsSavepoints(): Boolean = metaData.supportsSavepoints()

    /**
     * Supports sharding
     *
     * @return
     */
    fun supportsSharding(): Boolean = metaData.supportsSharding()

    /**
     * Supports statement pooling
     *
     * @return
     */
    fun supportsStatementPooling(): Boolean = metaData.supportsStatementPooling()

    /**
     * Supports stored functions using call syntax
     *
     * @return
     */
    fun supportsStoredFunctionsUsingCallSyntax(): Boolean = metaData.supportsStoredFunctionsUsingCallSyntax()

    /**
     * Supports schemas in data manipulation
     *
     * @return
     */
    fun supportsSchemasInDataManipulation(): Boolean = metaData.supportsSchemasInDataManipulation()

    /**
     * Supports schemas in procedure calls
     *
     * @return
     */
    fun supportsSchemasInProcedureCalls(): Boolean = metaData.supportsSchemasInProcedureCalls()

    /**
     * Supports schemas in table definitions
     *
     * @return
     */
    fun supportsSchemasInTableDefinitions(): Boolean = metaData.supportsSchemasInTableDefinitions()

    /**
     * Supports schemas in index definitions
     *
     * @return
     */
    fun supportsSchemasInIndexDefinitions(): Boolean = metaData.supportsSchemasInIndexDefinitions()

    /**
     * Supports schemas in privilege definitions
     *
     * @return
     */
    fun supportsSchemasInPrivilegeDefinitions(): Boolean = metaData.supportsSchemasInPrivilegeDefinitions()

    /**
     * Supports select for update
     *
     * @return
     */
    fun supportsSelectForUpdate(): Boolean = metaData.supportsSelectForUpdate()

    /**
     * Supports stored procedures
     *
     * @return
     */
    fun supportsStoredProcedures(): Boolean = metaData.supportsStoredProcedures()

    /**
     * Supports subqueries in comparisons
     *
     * @return
     */
    fun supportsSubqueriesInComparisons(): Boolean = metaData.supportsSubqueriesInComparisons()

    /**
     * Supports subqueries in exists
     *
     * @return
     */
    fun supportsSubqueriesInExists(): Boolean = metaData.supportsSubqueriesInExists()

    /**
     * Supports subqueries in ins
     *
     * @return
     */
    fun supportsSubqueriesInIns(): Boolean = metaData.supportsSubqueriesInIns()

    /**
     * Supports subqueries in quantifieds
     *
     * @return
     */
    fun supportsSubqueriesInQuantifieds(): Boolean = metaData.supportsSubqueriesInQuantifieds()

    /**
     * Supports table correlation names
     *
     * @return
     */
    fun supportsTableCorrelationNames(): Boolean = metaData.supportsTableCorrelationNames()

    /**
     * Supports transactions
     *
     * @return
     */
    fun supportsTransactions(): Boolean = metaData.supportsTransactions()

    /**
     * Supports transaction isolation level
     *
     * @param transactionIsolation
     * @return
     */
    fun supportsTransactionIsolationLevel(transactionIsolation: TransactionIsolation): Boolean =
        metaData.supportsTransactionIsolationLevel(transactionIsolation.type)

    /**
     * Supports union
     *
     * @return
     */
    fun supportsUnion(): Boolean = metaData.supportsUnion()

    /**
     * Supports union all
     *
     * @return
     */
    fun supportsUnionAll(): Boolean = metaData.supportsUnionAll()

    /**
     * Updates are detected
     *
     * @param resultSetType
     * @return
     */
    fun updatesAreDetected(resultSetType: ResultSetType): Boolean = metaData.updatesAreDetected(resultSetType.type)

    /**
     * Uses local file per table
     *
     * @return
     */
    fun usesLocalFilePerTable(): Boolean = metaData.usesLocalFilePerTable()

    /**
     * Uses local files
     *
     * @return
     */
    fun usesLocalFiles(): Boolean = metaData.usesLocalFiles()
}