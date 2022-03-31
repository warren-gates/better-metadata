package dev.warrengates.databasemetadata

import java.sql.Connection
import java.sql.DatabaseMetaData
import java.sql.JDBCType
import java.sql.RowIdLifetime


@Suppress("unused", "MemberVisibilityCanBePrivate")
class Database(
    private val metaData: DatabaseMetaData,
    val defaultCatalog: String? = null,
    val defaultSchema: String? = null,
) {

    // https://docs.oracle.com/en/java/javase/17/docs/api/java.sql/java/sql/DatabaseMetaData.html
    fun allProceduresAreCallable(): Boolean = metaData.allProceduresAreCallable()

    fun allTablesAreSelectable(): Boolean = metaData.allTablesAreSelectable()

    fun autoCommitFailureClosesAllResultSets(): Boolean = metaData.autoCommitFailureClosesAllResultSets()

    fun dataDefinitionCausesTransactionCommit(): Boolean = metaData.dataDefinitionCausesTransactionCommit()

    fun dataDefinitionIgnoredInTransactions(): Boolean = metaData.dataDefinitionIgnoredInTransactions()

    fun deletesAreDetected(resultSetType: ResultSetType): Boolean = metaData.deletesAreDetected(resultSetType.type)

    fun doesMaxRowSizeIncludeBlobs(): Boolean = metaData.doesMaxRowSizeIncludeBlobs()

    fun generatedKeyAlwaysReturned(): Boolean = metaData.generatedKeyAlwaysReturned()

    fun getCatalogs(): List<Catalog> = getIterableFromRs(metaData.catalogs) { Catalog(it) }

    fun getCatalogSeparator(): String = metaData.catalogSeparator

    fun getCatalogTerm(): String = metaData.catalogTerm

    fun getClientInfoProperties(): List<ClientInfoProperties> =
        getIterableFromRs(metaData.clientInfoProperties) { ClientInfoProperties(it) }

    fun getConnection(): Connection = metaData.connection

    fun getDatabaseMajorVersion(): Int = metaData.databaseMajorVersion

    fun getDatabaseMinorVersion(): Int = metaData.databaseMinorVersion

    fun getDatabaseProductName(): String = metaData.databaseProductName

    fun getDatabaseProductVersion(): String = metaData.databaseProductVersion

    fun getDefaultTransactionIsolation(): TransactionIsolation = valueOf(metaData.defaultTransactionIsolation)

    fun getDriverName(): String = metaData.driverName

    fun getDriverVersion(): String = metaData.driverVersion

    fun getDriverMajorVersion(): Int = metaData.driverMajorVersion

    fun getDriverMinorVersion(): Int = metaData.driverMinorVersion

    fun getExtraNameCharacters(): String = metaData.extraNameCharacters

    /**
     * Get functions using the [defaultCatalog] and [defaultSchema] specified in
     * the constructor and no filter for function name
     *
     * @return List<[Function]>
     */
    fun getFunctions(): List<Function> {
        return getFunctions(defaultCatalog, defaultSchema, null)
    }

    /**
     * Get functions using the [defaultCatalog] and [defaultSchema] specified in
     * the constructor and [namePattern] as a filter for function name
     *
     * @param namePattern the pattern used to filter returned Functions
     * @return List<[Function]>
     */
    fun getFunctions(namePattern: String): List<Function> {
        return getFunctions(defaultCatalog, defaultSchema, namePattern)
    }

    /**
     * Gets functions using the [catalog], [schemaPattern], and [namePattern]
     * to filter results
     *
     * @param catalog
     * @param schemaPattern
     * @param namePattern
     * @return List<[Function]>
     */
    fun getFunctions(catalog: String?, schemaPattern: String?, namePattern: String?): List<Function> {
        return getIterableFromRs(
            metaData, metaData.getFunctions(catalog, schemaPattern, namePattern)
        ) { md, r -> Function(md, r) }
    }

    fun getIdentifierQuoteString(): String = metaData.identifierQuoteString

    fun getJDBCMajorVersion(): Int = metaData.jdbcMajorVersion

    fun getJDBCMinorVersion(): Int = metaData.jdbcMinorVersion

    fun getMaxBinaryLiteralLength(): Int = metaData.maxBinaryLiteralLength

    fun getMaxCharLiteralLength(): Int = metaData.maxCharLiteralLength

    fun getMaxColumnNameLength(): Int = metaData.maxColumnNameLength

    fun getMaxColumnsInGroupBy(): Int = metaData.maxColumnsInGroupBy

    fun getMaxColumnsInIndex(): Int = metaData.maxColumnsInIndex

    fun getMaxColumnsInOrderBy(): Int = metaData.maxColumnsInOrderBy

    fun getMaxColumnsInSelect(): Int = metaData.maxColumnsInSelect

    fun getMaxColumnsInTable(): Int = metaData.maxColumnsInTable

    fun getMaxConnections(): Int = metaData.maxConnections

    fun getMaxCursorNameLength(): Int = metaData.maxCursorNameLength

    fun getMaxIndexLength(): Int = metaData.maxIndexLength

    fun getMaxSchemaNameLength(): Int = metaData.maxSchemaNameLength

    fun getMaxProcedureNameLength(): Int = metaData.maxProcedureNameLength

    fun getMaxCatalogNameLength(): Int = metaData.maxCatalogNameLength

    fun getMaxRowSize(): Int = metaData.maxRowSize

    fun getMaxStatementLength(): Int = metaData.maxStatementLength

    fun getMaxStatements(): Int = metaData.maxStatements

    fun getMaxTableNameLength(): Int = metaData.maxTableNameLength

    fun getMaxTablesInSelect(): Int = metaData.maxTablesInSelect

    fun getMaxUserNameLength(): Int = metaData.maxUserNameLength

    fun getMaxLogicalLobSize(): Long = metaData.maxLogicalLobSize

    fun getNumericFunctions(): List<NumericFunction> = metaData.numericFunctions.split(",").map { NumericFunction(it) }

    fun getProcedures(): List<Procedure> {
        return getProcedures(defaultCatalog, defaultSchema, null)
    }

    fun getProcedures(namePattern: String?): List<Procedure> {
        return getProcedures(defaultCatalog, defaultSchema, namePattern)
    }

    fun getProcedures(catalog: String?, schemaPattern: String?, namePattern: String?): List<Procedure> {
        return getIterableFromRs(
            metaData, metaData.getProcedures(catalog, schemaPattern, namePattern)
        ) { m, rs -> Procedure(m, rs) }
    }

    fun getProcedureTerm(): String = metaData.procedureTerm

    fun getResultSetHoldability(): ResultSetHoldability = valueOf(metaData.resultSetHoldability)

    fun getRowIdLifetime(): RowIdLifetime = metaData.rowIdLifetime

    fun getSchemas(): List<Schema> = getIterableFromRs(metaData.schemas) { Schema(it) }

    fun getSchemaTerm(): String = metaData.schemaTerm

    fun getSearchStringEscape(): String = metaData.searchStringEscape

    fun getSQLKeywords(): List<SQLKeyword> = metaData.sqlKeywords.split(",").map { SQLKeyword(it) }

    fun getSQLStateType(): SQLStateType = valueOf(metaData.sqlStateType)

    fun getStringFunctions(): List<StringFunction> = metaData.stringFunctions.split(",").map { StringFunction(it) }

    fun getSuperTables(): List<Table> {
        return getSuperTables(defaultCatalog, defaultSchema, null)
    }

    fun getSuperTables(namePattern: String?): List<Table> {
        return getSuperTables(defaultCatalog, defaultSchema, namePattern)
    }

    fun getSuperTables(catalog: String?, schemaPattern: String?, tableNamePattern: String?): List<Table> {
        return getIterableFromRs(
            metaData, metaData.getSuperTables(catalog, schemaPattern, tableNamePattern)
        ) { m, rs -> Table(m, rs) }
    }

    fun getSuperTypes(): List<SuperType> {
        return getSuperTypes(defaultCatalog, defaultSchema, null)
    }

    fun getSuperTypes(namePattern: String?): List<SuperType> {
        return getSuperTypes(defaultCatalog, defaultSchema, namePattern)
    }

    fun getSuperTypes(catalog: String?, schemaPattern: String?, typeNamePattern: String?): List<SuperType> {
        return getIterableFromRs(
            metaData.getSuperTypes(catalog, schemaPattern, typeNamePattern)
        ) { SuperType(it) }
    }

    fun getSystemFunctions(): List<SystemFunction> = metaData.systemFunctions.split(",").map { SystemFunction(it) }

    fun getTables(): List<Table> {
        return getTables(defaultCatalog, defaultSchema, null, null)
    }

    fun getTables(namePattern: String?): List<Table> {
        return getTables(defaultCatalog, defaultSchema, namePattern, null)
    }

    fun getTables(namePattern: String?, tableTypes: Array<TableType>): List<Table> {
        return getTables(defaultCatalog, defaultSchema, namePattern, tableTypes.map { it.name }.toTypedArray())
    }

    fun getTables(
        catalog: String?, schemaPattern: String?, tableNamePattern: String?, types: Array<String>?,
    ): List<Table> {
        return getIterableFromRs(
            metaData, metaData.getTables(catalog, schemaPattern, tableNamePattern, types)
        ) { md, r -> Table(md, r) }
    }

    fun getTableTypes(): List<TableType> {
        return getIterableFromRs(
            metaData.tableTypes
        ) { TableType(it) }
    }

    fun getTimeDateFunctions(): List<TimeDateFunction> =
        metaData.timeDateFunctions.split(",").map { TimeDateFunction(it) }

    fun getURL(): String = metaData.url

    fun getUserDefinedTypes(): List<UserDefinedType> {
        return getUserDefinedTypes(defaultCatalog, defaultSchema, null, null)
    }

    fun getUserDefinedTypes(namePattern: String?): List<UserDefinedType> {
        return getUserDefinedTypes(defaultCatalog, defaultSchema, namePattern, null)
    }

    fun getUserDefinedTypes(namePattern: String?, types: Array<JDBCType>): List<UserDefinedType> {
        return getUserDefinedTypes(defaultCatalog,
            defaultSchema,
            namePattern,
            types.map { it.vendorTypeNumber }.toIntArray())
    }

    fun getUserDefinedTypes(namePattern: String?, types: IntArray): List<UserDefinedType> {
        return getUserDefinedTypes(defaultCatalog, defaultSchema, namePattern, types)
    }

    fun getUserDefinedTypes(
        catalog: String?, schemaPattern: String?, namePattern: String?, types: IntArray?,
    ): List<UserDefinedType> {
        return getIterableFromRs(
            metaData, metaData.getUDTs(catalog, schemaPattern, namePattern, types)
        ) { m, x -> UserDefinedType(m, x) }
    }

    fun getUserName(): String = metaData.userName

    fun insertsAreDetected(resultSetType: ResultSetType): Boolean = metaData.insertsAreDetected(resultSetType.type)

    fun isCatalogAtStart(): Boolean = metaData.isCatalogAtStart

    fun isReadOnly(): Boolean = metaData.isReadOnly

    fun locatorsUpdateCopy(): Boolean = metaData.locatorsUpdateCopy()

    fun nullsAreSortedAtEnd(): Boolean = metaData.nullsAreSortedAtEnd()

    fun nullsAreSortedAtStart(): Boolean = metaData.nullsAreSortedAtStart()

    fun nullsAreSortedHigh(): Boolean = metaData.nullsAreSortedHigh()

    fun nullsAreSortedLow(): Boolean = metaData.nullsAreSortedLow()

    fun nullPlusNonNullIsNull(): Boolean = metaData.nullPlusNonNullIsNull()

    fun othersUpdatesAreVisible(resultSetType: ResultSetType): Boolean =
        metaData.othersUpdatesAreVisible(resultSetType.type)

    fun othersDeletesAreVisible(resultSetType: ResultSetType): Boolean =
        metaData.othersDeletesAreVisible(resultSetType.type)

    fun othersInsertsAreVisible(resultSetType: ResultSetType): Boolean =
        metaData.othersInsertsAreVisible(resultSetType.type)

    fun ownUpdatesAreVisible(resultSetType: ResultSetType): Boolean = metaData.ownUpdatesAreVisible(resultSetType.type)

    fun ownDeletesAreVisible(resultSetType: ResultSetType): Boolean = metaData.ownDeletesAreVisible(resultSetType.type)

    fun ownInsertsAreVisible(resultSetType: ResultSetType): Boolean = metaData.ownInsertsAreVisible(resultSetType.type)

    fun storesUpperCaseIdentifiers(): Boolean = metaData.storesUpperCaseIdentifiers()

    fun storesLowerCaseIdentifiers(): Boolean = metaData.storesLowerCaseIdentifiers()

    fun storesMixedCaseIdentifiers(): Boolean = metaData.storesMixedCaseIdentifiers()

    fun storesUpperCaseQuotedIdentifiers(): Boolean = metaData.storesUpperCaseQuotedIdentifiers()

    fun storesLowerCaseQuotedIdentifiers(): Boolean = metaData.storesLowerCaseQuotedIdentifiers()

    fun storesMixedCaseQuotedIdentifiers(): Boolean = metaData.storesMixedCaseQuotedIdentifiers()

    fun supportsAlterTableWithAddColumn(): Boolean = metaData.supportsAlterTableWithAddColumn()

    fun supportsAlterTableWithDropColumn(): Boolean = metaData.supportsAlterTableWithDropColumn()

    fun supportsANSI92EntryLevelSQL(): Boolean = metaData.supportsANSI92EntryLevelSQL()

    fun supportsANSI92IntermediateSQL(): Boolean = metaData.supportsANSI92IntermediateSQL()

    fun supportsANSI92FullSQL(): Boolean = metaData.supportsANSI92FullSQL()

    fun supportsBatchUpdates(): Boolean = metaData.supportsBatchUpdates()

    fun supportsCatalogsInDataManipulation(): Boolean = metaData.supportsCatalogsInDataManipulation()

    fun supportsCatalogsInProcedureCalls(): Boolean = metaData.supportsCatalogsInProcedureCalls()

    fun supportsCatalogsInTableDefinitions(): Boolean = metaData.supportsCatalogsInTableDefinitions()

    fun supportsCatalogsInIndexDefinitions(): Boolean = metaData.supportsCatalogsInIndexDefinitions()

    fun supportsCatalogsInPrivilegeDefinitions(): Boolean = metaData.supportsCatalogsInPrivilegeDefinitions()

    fun supportsColumnAliasing(): Boolean = metaData.supportsColumnAliasing()

    fun supportsConvert(): Boolean = metaData.supportsConvert()

    fun supportsConvert(fromType: JDBCType, toType: JDBCType): Boolean =
        metaData.supportsConvert(fromType.vendorTypeNumber, toType.vendorTypeNumber)

    fun supportsCorrelatedSubqueries(): Boolean = metaData.supportsCorrelatedSubqueries()

    fun supportsCoreSQLGrammar(): Boolean = metaData.supportsCoreSQLGrammar()

    fun supportsDataDefinitionAndDataManipulationTransactions(): Boolean =
        metaData.supportsDataDefinitionAndDataManipulationTransactions()

    fun supportsDataManipulationTransactionsOnly(): Boolean = metaData.supportsDataManipulationTransactionsOnly()

    fun supportsDifferentTableCorrelationNames(): Boolean = metaData.supportsDifferentTableCorrelationNames()

    fun supportsExtendedSQLGrammar(): Boolean = metaData.supportsExtendedSQLGrammar()

    fun supportsExpressionsInOrderBy(): Boolean = metaData.supportsExpressionsInOrderBy()

    fun supportsFullOuterJoins(): Boolean = metaData.supportsFullOuterJoins()

    fun supportsGetGeneratedKeys(): Boolean = metaData.supportsGetGeneratedKeys()

    fun supportsGroupBy(): Boolean = metaData.supportsGroupBy()

    fun supportsGroupByUnrelated(): Boolean = metaData.supportsGroupByUnrelated()

    fun supportsGroupByBeyondSelect(): Boolean = metaData.supportsGroupByBeyondSelect()

    fun supportsIntegrityEnhancementFacility(): Boolean = metaData.supportsIntegrityEnhancementFacility()

    fun supportsLikeEscapeClause(): Boolean = metaData.supportsLikeEscapeClause()

    fun supportsLimitedOuterJoins(): Boolean = metaData.supportsLimitedOuterJoins()

    fun supportsMinimumSQLGrammar(): Boolean = metaData.supportsMinimumSQLGrammar()

    fun supportsMixedCaseIdentifiers(): Boolean = metaData.supportsMixedCaseIdentifiers()

    fun supportsMixedCaseQuotedIdentifiers(): Boolean = metaData.supportsMixedCaseQuotedIdentifiers()

    fun supportsMultipleResultSets(): Boolean = metaData.supportsMultipleResultSets()

    fun supportsMultipleTransactions(): Boolean = metaData.supportsMultipleTransactions()

    fun supportsMultipleOpenResults(): Boolean = metaData.supportsMultipleOpenResults()

    fun supportsNamedParameters(): Boolean = metaData.supportsNamedParameters()

    fun supportsNonNullableColumns(): Boolean = metaData.supportsNonNullableColumns()

    fun supportsOpenCursorsAcrossCommit(): Boolean = metaData.supportsOpenCursorsAcrossCommit()

    fun supportsOpenCursorsAcrossRollback(): Boolean = metaData.supportsOpenCursorsAcrossRollback()

    fun supportsOpenStatementsAcrossCommit(): Boolean = metaData.supportsOpenStatementsAcrossCommit()

    fun supportsOpenStatementsAcrossRollback(): Boolean = metaData.supportsOpenStatementsAcrossRollback()

    fun supportsOrderByUnrelated(): Boolean = metaData.supportsOrderByUnrelated()

    fun supportsOuterJoins(): Boolean = metaData.supportsOuterJoins()

    fun supportsPositionedDelete(): Boolean = metaData.supportsPositionedDelete()

    fun supportsPositionedUpdate(): Boolean = metaData.supportsPositionedUpdate()

    fun supportsRefCursors(): Boolean = metaData.supportsRefCursors()

    fun supportsResultSetConcurrency(
        resultSetType: ResultSetType, resultSetConcurrency: ResultSetConcurrency,
    ): Boolean = metaData.supportsResultSetConcurrency(resultSetType.type, resultSetConcurrency.type)

    fun supportsResultSetHoldability(resultSetHoldability: ResultSetHoldability): Boolean =
        metaData.supportsResultSetHoldability(resultSetHoldability.type)

    fun supportsResultSetType(resultSetType: ResultSetType): Boolean =
        metaData.supportsResultSetType(resultSetType.type)

    fun supportsSavepoints(): Boolean = metaData.supportsSavepoints()

    fun supportsSharding(): Boolean = metaData.supportsSharding()

    fun supportsStatementPooling(): Boolean = metaData.supportsStatementPooling()

    fun supportsStoredFunctionsUsingCallSyntax(): Boolean = metaData.supportsStoredFunctionsUsingCallSyntax()

    fun supportsSchemasInDataManipulation(): Boolean = metaData.supportsSchemasInDataManipulation()

    fun supportsSchemasInProcedureCalls(): Boolean = metaData.supportsSchemasInProcedureCalls()

    fun supportsSchemasInTableDefinitions(): Boolean = metaData.supportsSchemasInTableDefinitions()

    fun supportsSchemasInIndexDefinitions(): Boolean = metaData.supportsSchemasInIndexDefinitions()

    fun supportsSchemasInPrivilegeDefinitions(): Boolean = metaData.supportsSchemasInPrivilegeDefinitions()

    fun supportsSelectForUpdate(): Boolean = metaData.supportsSelectForUpdate()

    fun supportsStoredProcedures(): Boolean = metaData.supportsStoredProcedures()

    fun supportsSubqueriesInComparisons(): Boolean = metaData.supportsSubqueriesInComparisons()

    fun supportsSubqueriesInExists(): Boolean = metaData.supportsSubqueriesInExists()

    fun supportsSubqueriesInIns(): Boolean = metaData.supportsSubqueriesInIns()

    fun supportsSubqueriesInQuantifieds(): Boolean = metaData.supportsSubqueriesInQuantifieds()

    fun supportsTableCorrelationNames(): Boolean = metaData.supportsTableCorrelationNames()

    fun supportsTransactions(): Boolean = metaData.supportsTransactions()

    fun supportsTransactionIsolationLevel(transactionIsolation: TransactionIsolation): Boolean =
        metaData.supportsTransactionIsolationLevel(transactionIsolation.type)

    fun supportsUnion(): Boolean = metaData.supportsUnion()

    fun supportsUnionAll(): Boolean = metaData.supportsUnionAll()

    fun updatesAreDetected(resultSetType: ResultSetType): Boolean = metaData.updatesAreDetected(resultSetType.type)

    fun usesLocalFilePerTable(): Boolean = metaData.usesLocalFilePerTable()

    fun usesLocalFiles(): Boolean = metaData.usesLocalFiles()
}