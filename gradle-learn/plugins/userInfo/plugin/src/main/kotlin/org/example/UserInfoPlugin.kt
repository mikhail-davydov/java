package org.example

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.assign
import org.gradle.kotlin.dsl.create
import org.gradle.kotlin.dsl.register

class UserInfoPlugin : Plugin<Project> {
    override fun apply(project: Project) {

        val userInfoExtension = project.extensions.create<UserInfoExtension>("userInfo")
        userInfoExtension.userName.convention("Unknown")
        userInfoExtension.userAge.convention(0)

        // Register a task
        project.tasks.register<PrintUserInfoTask>("printUserInfo") {
            userName = userInfoExtension.userName
            userAge = userInfoExtension.userAge
        }
    }
}
