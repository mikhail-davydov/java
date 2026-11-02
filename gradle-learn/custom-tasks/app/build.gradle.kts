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
    logger.lifecycle("Configuration: $this")
    description = "Runs the square task."
    number = 5
}

val doubleNumberTaskProvider = tasks.register<DoubleNumberTask>("doubleNumber") {
    logger.lifecycle("Configuration: $this")
    description = "Runs the double number task."

    inputFile = squareTaskProvider.flatMap {
        logger.lifecycle("Map: $it")
        it.outputFile
    }
}

val unionTaskProvider = tasks.register<UnionFilesTask>("unionFiles") {
    logger.lifecycle("Configuration: $this")
    description = "Runs the union files task."

    squareInputFile = squareTaskProvider.flatMap { it.outputFile }
    doubledInputFile = doubleNumberTaskProvider.flatMap { it.outputFile }
}

tasks.register<PrintResultTask>("printResult") {
    logger.lifecycle("Configuration: $this")
    description = "Print square results."

    inputFile = unionTaskProvider.flatMap {
        it.unionOutputFile
    }
}

