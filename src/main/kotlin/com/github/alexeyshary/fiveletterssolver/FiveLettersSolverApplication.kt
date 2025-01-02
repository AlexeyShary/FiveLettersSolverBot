package com.github.alexeyshary.fiveletterssolver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FiveLettersSolverApplication

fun main(args: Array<String>) {
	runApplication<FiveLettersSolverApplication>(*args)
}
