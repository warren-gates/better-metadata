plugins {
    kotlin("jvm") version "1.6.10"
    java
}

group = "dev.warrengates"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
    testImplementation("org.jetbrains.kotlin:kotlin-reflect:1.6.20")
    testImplementation("com.h2database:h2:2.1.212")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    // https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-params
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.8.2")

}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}