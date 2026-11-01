@file:Suppress("UnstableApiUsage")

println("Initialization: settings.gradle.kts")

rootProject.name = "gradle-app"

dependencyResolutionManagement {
    repositories {
        mavenLocal()
        mavenCentral()
    }
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
}

include("app")
include("greeter")
include("repository")
include("platform")