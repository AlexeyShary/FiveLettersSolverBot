package com.github.alexeyshary.fiveletterssolver.service

import com.github.alexeyshary.fiveletterssolver.model.Log
import com.github.alexeyshary.fiveletterssolver.model.LogDto
import com.github.alexeyshary.fiveletterssolver.repository.LogRepository
import org.springframework.stereotype.Service

@Service
class LogService(private val logRepository: LogRepository) {
    fun saveLog(mask: String, positive: String?, negative: String?) {
        val log = Log(query = "$mask p=$positive n=$negative")
        logRepository.save(log)
    }

    fun getLastLogs() : List<LogDto> {
        return logRepository.findLastLogs().map { log ->
            LogDto(
                id = log.id,
                timestamp = log.timestamp,
                query = log.query
            )
        }
    }
}