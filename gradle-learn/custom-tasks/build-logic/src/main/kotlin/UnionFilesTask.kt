import org.gradle.api.DefaultTask
import org.gradle.api.provider.Property
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction
import java.io.File
import kotlin.io.readText

abstract class UnionFilesTask : DefaultTask() {

    @get:InputFile
    abstract val squareInputFile: Property<File>

    @get:InputFile
    abstract val doubledInputFile: Property<File>

    @get:OutputFile
    abstract val unionOutputFile: Property<File>

    init {
        unionOutputFile.convention(project.file("build/union.txt"))
    }

    @TaskAction
    fun run() {
        logger.lifecycle("Union files: $unionOutputFile")
        val squared: String = squareInputFile.get().readText()
        val doubled: String = doubledInputFile.get().readText()

        unionOutputFile.get().writeText("$squared $doubled")
    }

}