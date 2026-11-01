plugins {
    `java-platform`
}

group = "org.example"
version = "platform"

dependencies {
    constraints {
        api("org.example:greeter:1.0-SNAPSHOT")
    }
}