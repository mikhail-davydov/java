plugins {
    id("buildlogic.java-application-conventions")
}

dependencies {
    implementation("org.apache.commons:commons-text")
    implementation(project(":utilities"))
}

application {
    // Define the main class for the application.
    mainClass = "org.example.app.App"
}


val squareTaskProvider = tasks.register<SquareTask>("square") {
    description = "Runs the square task."
    number = 5
}

tasks.register<PrintResultTask>("printResult") {
    description = "Print square results."
    dependsOn("square")
    content = squareTaskProvider.get().outputFile.readText()
}

