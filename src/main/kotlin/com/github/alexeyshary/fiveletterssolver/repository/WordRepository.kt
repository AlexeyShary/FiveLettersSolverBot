package com.github.alexeyshary.fiveletterssolver.repository

import com.github.alexeyshary.fiveletterssolver.model.Word
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface WordRepository : JpaRepository<Word, Long> {
    @Query(
        value = """
        SELECT * FROM words 
        WHERE (:letter0 IS NULL OR letter_0 = :letter0)
          AND (:letter1 IS NULL OR letter_1 = :letter1)
          AND (:letter2 IS NULL OR letter_2 = :letter2)
          AND (:letter3 IS NULL OR letter_3 = :letter3)
          AND (:letter4 IS NULL OR letter_4 = :letter4)
        """,
        nativeQuery = true
    )
    fun searchByLetters(
        @Param("letter0") letter0: Char?,
        @Param("letter1") letter1: Char?,
        @Param("letter2") letter2: Char?,
        @Param("letter3") letter3: Char?,
        @Param("letter4") letter4: Char?
    ): List<Word>
}