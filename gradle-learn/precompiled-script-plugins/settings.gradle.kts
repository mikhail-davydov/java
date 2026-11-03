plugins {
    // Apply the foojay-resolver plugin to allow automatic download of JDKs
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

rootProject.name = "precompiled-script-plugins"

include("app")
include("core")
include("utils")

includeBuild("build-logic")