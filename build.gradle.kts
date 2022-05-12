import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.21"
    id("org.jetbrains.dokka") version "1.6.21"
    signing
    java
    `maven-publish`
}

group = "dev.warrengates"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    api(kotlin("stdlib"))
    dokkaGfmPlugin("org.jetbrains.dokka:kotlin-as-java-plugin:1.6.21")

    testImplementation("org.jetbrains.kotlin:kotlin-reflect:1.6.21")
    testImplementation("com.h2database:h2:2.1.212")

    // https://mvnrepository.com/artifact/commons-dbutils/commons-dbutils
    testImplementation("commons-dbutils:commons-dbutils:1.7")

    val junitVersion = "5.8.2"
    testImplementation("org.junit.jupiter:junit-jupiter-api:$junitVersion")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-params:$junitVersion")

    val tcVersion = "1.17.1"
    testImplementation("org.testcontainers:testcontainers:$tcVersion")
    testImplementation("org.testcontainers:junit-jupiter:$tcVersion")

    testImplementation("org.testcontainers:mysql:$tcVersion")
    @Suppress("VulnerableLibrariesLocal") testImplementation("mysql:mysql-connector-java:8.0.28")

    testImplementation("org.testcontainers:postgresql:$tcVersion")
    testImplementation("org.postgresql:postgresql:42.3.4")

    testImplementation("org.testcontainers:mariadb:$tcVersion")
    testImplementation("org.mariadb.jdbc:mariadb-java-client:3.0.4")
}

tasks.dokkaHtml.configure {
    outputDirectory.set(file("docs/kdoc"))
}

val javadocOutputDir = "docs/javadoc"
tasks.dokkaJavadoc.configure {
    outputDirectory.set(file(javadocOutputDir))
}

val deleteJavadocOutputDir by tasks.register<Delete>("deleteJavadocOutputDir") {
    delete(javadocOutputDir)
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

tasks.withType<JavaCompile>() {
    options.release.set(11)
}
tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
}

val uberJar = tasks.register<Jar>("uberJar") {
    archiveClassifier.set("uber")

    from(sourceSets.main.get().output)

    dependsOn(configurations.runtimeClasspath)
    from({
        configurations.runtimeClasspath.get().filter { it.name.endsWith("jar") }.map { zipTree(it) }
    })
}

val javadocJar = tasks.register("javadocJar", Jar::class.java) {
    dependsOn(deleteJavadocOutputDir, tasks.dokkaJavadoc)
    archiveClassifier.set("javadoc")
    from(javadocOutputDir)
}

val sourcesJar = tasks.register("sourcesJar", Jar::class.java) {
    archiveClassifier.set("sources")
    from(sourceSets.main.get().allSource)
}

publishing {
    publications {
        create<MavenPublication>("better-metadata") {
            artifactId = "better-metadata"

            from(project.components["kotlin"])
            artifact(javadocJar)
            artifact(sourcesJar)
            repositories {
                maven {
                    name = "ossrh"
                    setUrl {
                        "https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/"
                    }
                    credentials {
                        username = project.property("sonatype.username").toString()
                        password = project.property("sonatype.password").toString()
                    }
                }
                maven {
                    name = "snapshot"
                    setUrl {
                        "https://s01.oss.sonatype.org/content/repositories/snapshots/"
                    }
                    credentials {
                        username = project.property("sonatype.username").toString()
                        password = project.property("sonatype.password").toString()
                    }
                }
            }
            pom {
                name.set("Better Metadata")
                description.set("A object oriented wrapper around java.sql.DatabaseMetaData")
                url.set("https://github.com/warren-gates/better-metadata")
                licenses {
                    license {
                        name.set("The Apache License, Version 2.0")
                        url.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }
                issueManagement {
                    system.set("Github")
                    url.set("https://github.com/warren-gates/better-metadata/issues")
                }
                developers {
                    developer {
                        id.set("warren-gates")
                        name.set("Warren Gates")
                        email.set("warren@warrengates.dev")
                    }
                }
                scm {
                    connection.set("scm:git:https://github.com/warren-gates/better-metadata.git")
                    developerConnection.set("scm:git:ssh://github.com/warren-gates/better-metadata.git")
                    url.set("https://github.com/warren-gates/better-metadata")
                }
            }
        }
    }
}

signing {
    sign(publishing.publications)
}

//
//artifacts {
//    archives("javadocJar, sourcesJar")
//}
//
//signing {
//    sign(configurations.archives.get())
//}