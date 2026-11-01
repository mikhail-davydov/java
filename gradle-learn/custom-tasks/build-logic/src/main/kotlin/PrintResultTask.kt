import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction

abstract class PrintResultTask: DefaultTask() {

    @Input
    var content: String = ""

    @TaskAction
    fun printResult() {
        println(content)
    }

}