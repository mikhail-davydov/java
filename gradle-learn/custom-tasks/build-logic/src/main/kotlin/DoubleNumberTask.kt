import org.gradle.api.DefaultTask
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction

abstract class DoubleNumberTask : DefaultTask() {

    @get:InputFile
    abstract val inputFile: RegularFileProperty

    @get:OutputFile
    abstract val outputFile: RegularFileProperty

    init {
        logger.lifecycle("Init: $this")
        outputFile.convention(project.layout.buildDirectory.file("doubled.txt"))
    }

    @TaskAction
    fun doubleNumber() {
        logger.lifecycle("Action: $this")
        val current: Int = inputFile.get().asFile.readText().toIntOrNull() ?: 0
        outputFile.get().asFile.writeText("${current * 2}")
    }

}