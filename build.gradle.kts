group = "app"
version = "1.0"

repositories {
    mavenCentral()
}

plugins {
    kotlin("jvm") version "1.6.20"
    application
}

application {
    mainClass.set("MainKt")
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
