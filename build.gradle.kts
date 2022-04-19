plugins {
    kotlin("jvm") version "1.6.20"
    id("org.jetbrains.dokka") version "1.6.20"
    java
}

group = "dev.warrengates"
version = "0.9.1"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    dokkaGfmPlugin("org.jetbrains.dokka:kotlin-as-java-plugin:1.6.20")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
    testImplementation("org.jetbrains.kotlin:kotlin-reflect:1.6.20")
    testImplementation("com.h2database:h2:2.1.212")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    // https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-params
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.8.2")

}

tasks.dokkaHtml.configure {
    outputDirectory.set(file("docs/kdoc"))
}

tasks.dokkaGfm.configure {
    outputDirectory.set(file("docs/api"))
}

tasks.dokkaJavadoc.configure {
    outputDirectory.set(file("docs/javadoc"))
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}