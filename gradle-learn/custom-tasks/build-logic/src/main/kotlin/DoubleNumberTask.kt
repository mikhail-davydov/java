import org.gradle.api.DefaultTask
import org.gradle.api.provider.Property
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction
import java.io.File

abstract class DoubleNumberTask : DefaultTask() {

    @get:InputFile
    abstract val inputFile: Property<File>

    @get:OutputFile
    abstract val outputFile: Property<File>

    init {
        logger.lifecycle("Init: $this")
        inputFile.convention(project.file("build/squared.txt"))
        outputFile.convention(project.file("build/doubled.txt"))
    }

    @TaskAction
    fun doubleNumber() {
        logger.lifecycle("Action: $this")
        val current: Int = inputFile.get().readText().toIntOrNull() ?: 0
        outputFile.get().writeText("${current * 2}")
    }

}