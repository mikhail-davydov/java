println("Confgiration: greeter")

plugins {
    id("java-library")
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

    api(project(":repository"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.register("homework") {
    dependsOn(":repository:homework")
    doFirst {
        println("greeter")
    }
}