plugins {
    kotlin("jvm") version "1.9.21"
    id("org.jetbrains.intellij") version "1.17.4"
}

group = "com.codex"
version = "0.1.0"

repositories {
    mavenCentral()
}

intellij {
    version.set("2023.3")
    type.set("IC")
    plugins.set(listOf("git4idea"))
}

tasks {
    patchPluginXml {
        sinceBuild.set("233")
    }
}
