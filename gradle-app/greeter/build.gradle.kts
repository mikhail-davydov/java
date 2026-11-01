println("Configuration: greeter")

plugins {
    `java-library`
    `maven-publish`
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

publishing {
    publications.create<MavenPublication>("maven") {
        groupId = project.group.toString()
        artifactId = project.name
        version = project.version.toString()

        from(components["java"])
    }
}

val politeSourceSet = sourceSets.create("polite")
val politeAttribute = Attribute.of("greeter.polite.setting", String::class.java)
configurations.named("apiElements") {
    attributes {
        attribute(politeAttribute, "polite")
    }
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