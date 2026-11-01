println("Configuration: respository")

plugins {
    java
    `maven-publish`
}

group = "org.example"
version = "1.0-SNAPSHOT"

dependencies {
    testImplementation(platform("org.junit:junit-bom:6.0.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

publishing {
    publications.create<MavenPublication>("maven") {
        groupId = project.group.toString()
        artifactId = project.name
        version = project.version.toString()

        from(components["java"])
    }
}

tasks.test {
    useJUnitPlatform()
}

tasks.register("homework") {
    doFirst {
        println("repository")
    }
}