package com.github.alexeyshary.fiveletterssolver.repository

import com.github.alexeyshary.fiveletterssolver.model.Log
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface LogRepository : JpaRepository<Log, Long> {
    @Query(
        value = "SELECT * FROM logs ORDER BY id DESC LIMIT 20",
        nativeQuery = true
    )
    fun findLastLogs(): List<Log>
}