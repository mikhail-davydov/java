plugins {
    `kotlin-dsl`

    alias(libs.plugins.kotlin.jvm)
}

repositories {
    mavenCentral()
}

dependencies {

}

gradlePlugin {
    // Define the plugin
    val greeting by plugins.creating {
        id = "org.example.userInfo"
        implementationClass = "org.example.UserInfoPlugin"
    }
}