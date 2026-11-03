plugins {
    id("buildlogic.java-application-conventions")
    id("org.example.userInfo")
}

dependencies {
    implementation("org.apache.commons:commons-text")
    implementation(project(":utilities"))

    implementation("org.example:lib:1.0.0-SNAPSHOT")
}

application {
    mainClass = "org.example.app.App"
}

// custom

class GreetingPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.tasks.register("greet") {
            description = "Greeting"
            doLast {
                println("Hello world!")
            }
        }
    }
}

apply<GreetingPlugin>()


class ChangeBuildDirectoryPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        val myBuildDirectory = "myBuild"
        target.layout.buildDirectory = target.file(myBuildDirectory)
    }
}

//apply<ChangeBuildDirectoryPlugin>()

userInfo {
    userName = "John Smith"
    userAge = 146
}