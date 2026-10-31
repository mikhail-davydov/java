println("Configuration: app")

plugins {
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:6.0.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    implementation(project(":greeter"))
}

tasks.test {
    useJUnitPlatform()
}

application {
    mainClass = "org.example.app.Main"
}

tasks.register("homework") {
    dependsOn(":greeter:homework")
    doFirst {
        println("app")
    }
}

tasks.register("configurations") {
    doLast {
        configurations.forEach {
            println("configuration: ${it.name}\n")
            val attributes = it.attributes
            attributes.keySet().forEach {
                println("$it : ${attributes.getAttribute(it)}")
            }
            println()
        }
    }
}