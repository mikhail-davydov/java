package org.example

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.internal.Actions.with
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.named
import org.gradle.kotlin.dsl.repositories

class CommonConventionPlugin : Plugin<Project> {
    override fun apply(project: Project) {

        with(project) {

            pluginManager.apply("java")

            group = "org.example"
            version = "1.0.0-SNAPSHOT"

            repositories {
                mavenCentral()
            }

            dependencies {
                add("testImplementation", "org.junit:junit-bom:6.0.0")
                add("testImplementation", "org.junit.jupiter:junit-jupiter")
                add("testImplementation", "org.junit.platform:junit-platform-launcher")
            }

            tasks.named<org.gradle.api.tasks.testing.Test>("test") {
                useJUnitPlatform()
            }

        }

    }
}
