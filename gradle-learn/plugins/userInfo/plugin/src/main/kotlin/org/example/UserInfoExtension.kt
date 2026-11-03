package org.example

import org.gradle.api.provider.Property

interface UserInfoExtension {

    val userName: Property<String>
    val userAge: Property<Int>
}