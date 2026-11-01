import org.gradle.api.DefaultTask
import org.gradle.api.provider.Property
import org.gradle.api.tasks.CacheableTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction
import java.io.File

@CacheableTask
abstract class SquareTask: DefaultTask() {

    @get:Input
    abstract val number: Property<Int>

    @OutputFile
    val outputFile: File = project.file("build/square.txt")

    init {
        number.set(0)
    }

    @TaskAction
    fun square() {
        val current: Int = number.get()
        outputFile.writeText("${current * current}")
    }
}