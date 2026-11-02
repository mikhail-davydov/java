plugins {
    id("buildlogic.java-application-conventions")
}

dependencies {
    implementation(project(":utilities"))
}

application {
    mainClass = "org.example.app.App"
    version = "1.0.0-SNAPSHOT"
}

layout.buildDirectory = project.file("build") // default

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

tasks.register("show-logs") {
    description = "Print show logs setting."

    val showLogs = providers.gradleProperty("show.logs")
        .map { it.toBoolean() }
        .orElse(false)

    doLast {
        if (showLogs.get()) {
            logger.lifecycle("Show logs.")
        }
    }
}

tasks.register<CountCodeLinesTask>("countCodeLines") {
    description = "Runs the count code lines task."

    sourceFiles.from(rootProject.layout.projectDirectory)
    sourceFiles.include(listOf("**/*.java", "**/*.kt", "**/*.kts"))
    sourceFiles.exclude(
        "**/build/**",
        "**/build-logic/**"
    )
}

tasks.named("check") {
    dependsOn("countCodeLines")
}