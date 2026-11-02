import org.gradle.api.DefaultTask
import org.gradle.api.provider.Property
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.TaskAction
import java.io.File

abstract class PrintResultTask : DefaultTask() {

    @get:InputFile
    abstract val inputFile: Property<File>

    init {
        logger.lifecycle("Init: $this")
        inputFile.convention(project.file("build/doubled.txt"))
    }

    @TaskAction
    fun printResult() {
        logger.lifecycle("Action: $this")
        println("Result: ${inputFile.get().readText()}")
    }

}