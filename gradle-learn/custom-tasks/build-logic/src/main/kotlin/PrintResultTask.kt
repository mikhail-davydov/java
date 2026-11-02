import org.gradle.api.DefaultTask
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.TaskAction

abstract class PrintResultTask : DefaultTask() {

    @get:InputFile
    abstract val inputFile: RegularFileProperty

    init {
        logger.lifecycle("Init: $this")
    }

    @TaskAction
    fun printResult() {
        logger.lifecycle("Action: $this")
        println("Result: ${inputFile.get().asFile.readText()}")
    }

}