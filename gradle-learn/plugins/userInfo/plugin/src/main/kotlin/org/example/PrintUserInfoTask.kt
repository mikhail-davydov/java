package org.example

import org.gradle.api.DefaultTask
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction

abstract class PrintUserInfoTask : DefaultTask() {

    @get:Input
    abstract val userName: Property<String>

    @get:Input
    abstract val userAge: Property<Int>

    @TaskAction
    fun printUserInfo() {
        logger.lifecycle(
            "Name: ${userName.get()}\nAge: ${userAge.get()}"
        )
    }
}