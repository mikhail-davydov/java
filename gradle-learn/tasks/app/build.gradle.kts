import kotlin.math.pow

plugins {
    application
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(24)
    }
}

version = "1.0.0-SNAPSHOT"

application {
    mainClass = "org.example.App"
}

tasks.register("homework") {
    description = "homework task"
}

tasks.named("homework") {
    println("Configuration: $this")
    doFirst {
        println("Excution: $this")
    }
}

tasks.named("build") {
    dependsOn("homework")
}

tasks.configureEach {
    doFirst {
        println("Start: $this")
    }
}


tasks.register<SquareTask>("square") {
    num = 5

    doFirst {
        println("Start: $this")
    }

    doLast {
        println("End: $this")
    }

}

tasks.named("square") {
    dependsOn("homework")
}

abstract class SquareTask : DefaultTask() {

    @Input
    var num: Int = 10

    @TaskAction
    fun square() {
        val result = num.toDouble().pow(2.0)
        println("Square Task: $result")
    }

}