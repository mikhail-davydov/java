import org.gradle.api.DefaultTask
import org.gradle.api.provider.Property
import org.gradle.api.tasks.CacheableTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction
import java.io.File

@CacheableTask
abstract class SquareTask : DefaultTask() {

    @get:Input
    abstract val number: Property<Int>

    @get:OutputFile
    abstract val outputFile: Property<File>

    init {
        logger.lifecycle("Init: $this")
        number.convention(0)
        outputFile.convention(project.file("build/squared.txt"))
    }

    @TaskAction
    fun square() {
        logger.lifecycle("Action: $this")
        val current: Int = number.get()
        outputFile.get().writeText("${current * current}")
    }
}