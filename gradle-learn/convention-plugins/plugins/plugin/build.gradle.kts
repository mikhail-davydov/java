plugins {
    `kotlin-dsl`
    alias(libs.plugins.kotlin.jvm)
}

repositories {
    mavenCentral()
}

gradlePlugin {
    val commonConventionPlugin by plugins.creating {
        id = "org.example.common-convention"
        implementationClass = "org.example.CommonConventionPlugin"
    }
    val applicationConventionPlugin by plugins.creating {
        id = "org.example.application-convention"
        implementationClass = "org.example.ApplicationConventionPlugin"
    }
}
