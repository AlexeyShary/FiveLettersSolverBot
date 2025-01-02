package com.github.alexeyshary.fiveletterssolver.model

import java.time.LocalDateTime

data class LogDto(
    val id: Long,
    val timestamp: LocalDateTime,
    val query: String,
)