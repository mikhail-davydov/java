import org.gradle.api.DefaultTask
import org.gradle.api.GradleException
import org.gradle.api.file.ConfigurableFileTree
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.InputFiles
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction

abstract class CountCodeLinesTask : DefaultTask() {

    @get:Input
    abstract val limit: Property<Int>

    @get:InputFiles
    abstract val sourceFiles: ConfigurableFileTree

    @get:OutputFile
    abstract val outputFile: RegularFileProperty

    init {
        limit.convention(10)
        outputFile.convention(project.layout.buildDirectory.file("code_lines.txt"))
    }

    @TaskAction
    fun countCodeLines() {
        var total = 0

        val maxLimit = limit.get()
        val violations = mutableListOf<String>()

        val content = sourceFiles.joinToString("\n") {
            val codeLines = it.readLines().count()

            total += codeLines
            val result = "Name: ${it.name}, lines count: $codeLines"

            if (codeLines > limit.get()) {
                violations.add(result)
            }

            result
        }

        if (violations.isNotEmpty()) {
            throw GradleException("Limit $maxLimit exceeded for files:\n${violations.joinToString("\n")}")
        }

        outputFile.get().asFile.writeText("$content\n\nTotal: $total")
    }

}