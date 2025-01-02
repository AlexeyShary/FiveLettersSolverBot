package com.github.alexeyshary.fiveletterssolver.controller

import com.github.alexeyshary.fiveletterssolver.service.LogService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/logs")
class LogController(private val logService: LogService) {
    @GetMapping
    fun getLastLogs(): String {
        val logs = logService.getLastLogs()
        return logs.joinToString(separator = "<br>") { log ->
            "ID: ${log.id}, Timestamp: ${log.timestamp}, Query: ${log.query}"
        }
    }
}