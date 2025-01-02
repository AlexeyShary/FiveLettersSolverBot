package com.github.alexeyshary.fiveletterssolver.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "logs")
data class Log(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(name = "timestamp", nullable = false)
    val timestamp: LocalDateTime = LocalDateTime.now(),

    @Column(name = "query", nullable = false)
    val query: String = "query",
)