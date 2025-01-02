package com.github.alexeyshary.fiveletterssolver.model

import jakarta.persistence.*

@Entity
@Table(name = "words")
data class Word(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(name = "letter_0", nullable = false)
    val letter0: Char = ' ',

    @Column(name = "letter_1", nullable = false)
    val letter1: Char = ' ',

    @Column(name = "letter_2", nullable = false)
    val letter2: Char = ' ',

    @Column(name = "letter_3", nullable = false)
    val letter3: Char = ' ',

    @Column(name = "letter_4", nullable = false)
    val letter4: Char = ' ',
)