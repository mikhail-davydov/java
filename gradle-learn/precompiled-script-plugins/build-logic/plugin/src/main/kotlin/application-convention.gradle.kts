plugins {
    id("common-convention")
    application
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(24)
    }
}

application {
    mainClass = "org.example.App"
}