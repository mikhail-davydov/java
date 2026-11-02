import org.gradle.api.DefaultTask
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction
import kotlin.io.readText

abstract class UnionFilesTask : DefaultTask() {

    @get:InputFile
    abstract val squareInputFile: RegularFileProperty

    @get:InputFile
    abstract val doubledInputFile: RegularFileProperty

    @get:OutputFile
    abstract val unionOutputFile: RegularFileProperty

    init {
        unionOutputFile.convention(project.layout.buildDirectory.file("union.txt"))
    }

    @TaskAction
    fun run() {
        logger.lifecycle("Union files: $unionOutputFile")
        val squared: String = squareInputFile.get().asFile.readText()
        val doubled: String = doubledInputFile.get().asFile.readText()

        unionOutputFile.get().asFile.writeText("$squared $doubled")
    }

}