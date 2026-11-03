package org.example

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.JavaApplication
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.jvm.toolchain.JavaLanguageVersion
import org.gradle.kotlin.dsl.assign
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class ApplicationConventionPlugin : Plugin<Project> {
    override fun apply(project: Project) {

        with(project) {

//            pluginManager.apply(CommonConventionPlugin::class.java)
            pluginManager.apply("org.example.common-convention")
            pluginManager.apply("application")

            dependencies {
                add("implementation", project(":utils"))
            }

            project.extensions.configure<JavaApplication>("application") {
                mainClass = "org.example.App"
            }

            project.extensions.configure<JavaPluginExtension> {
                toolchain {
                    languageVersion = JavaLanguageVersion.of(24)
                }
            }

        }

    }
}