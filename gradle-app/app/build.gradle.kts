println("Configuration: app")

plugins {
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    implementation(platform(project(":platform")))

    implementation("org.example:greeter")
//    implementation(project(":greeter"))

    testImplementation(platform("org.junit:junit-bom:6.0.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
}

application {
    mainClass = "org.example.app.Main"
}

tasks.register("homework") {
    description = "homework task"
    dependsOn(":greeter:homework")
    doFirst {
        println("app")
    }
}

tasks.register("configurations") {
    description = "Check configurations"
    doLast {
        configurations.forEach { configuration ->
            println("configuration: ${configuration.name}\n")
            val attributes = configuration.attributes
            attributes.keySet().forEach {
                println("$it : ${attributes.getAttribute(it)}")
            }
            println()
        }
    }
}