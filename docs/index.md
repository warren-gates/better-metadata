# better-metadata
Provides wrapper classes and enums for Java's DatabaseMetadata class. Currently feature complete,
though not fully tested, and therefore not ready for production use.

## Usage
Java
```java
// configure your url, username, password...
Connection conn = DriverManager.getConnection(url, user, password);
DatabaseMetaData metadata = conn.getMetaData();

// to use without default catalog and schema filters
Database wrapper = new Database(metadata);

// or set defaults to work with a specific catalog/schema,
// replacing "catalogName" and "schemaName" with values appropriate to your database
Database wrapper = new Database(metadata,"catalogName", "schemaName");

// use wrapper as needed

// Database does no connection management, so you'll need to close it
// when finished
conn.close();
```
Kotlin
```kotlin
// configure your url, username, password...
val conn = DriverManager.getConnection(url, username, password)
val metadata = conn.metaData
// to use without default catalog and schema filters
val wrapper = new Database(metadata)

// or set defaults to work with a specific catalog/schema,
// replacing "catalogName" and "schemaName" with values appropriate to your database
val wrapper = new Database(metadata,"catalogName", "schemaName")
        
// use wrapper as needed

// Database does no connection management, so you'll need to close it
// when finished
conn.close()
```

### Options
There is a type alias that allow nullable ints for columns such as DECIMAL_DIGITS where the
DatabaseMetaData documentation indicates that nulls are returned. See the
[TypeDefinitions](src/main/kotlin/dev/warrengates/bettermetadata/TypeDefinitions.kt) file for
details.

# Documentation
[Java style](https://warren-gates.github.io/better-metadata/javadoc/index.html)

[Kotlin style](https://warren-gates.github.io/better-metadata/kdoc/index.html)