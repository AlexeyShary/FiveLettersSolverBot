package com.github.alexeyshary.fiveletterssolver.service

import com.github.alexeyshary.fiveletterssolver.model.Word
import com.github.alexeyshary.fiveletterssolver.model.WordDto
import com.github.alexeyshary.fiveletterssolver.repository.WordRepository
import org.springframework.stereotype.Service

@Service
class WordService(private val wordRepository: WordRepository, private val logService: LogService) {
    fun findWordsByMask(mask: String, positive: String?, negative: String?): List<WordDto> {
        logService.saveLog(mask, positive, negative)

        val maskChars = mask.uppercase().map { if (it == '*') null else it }

        val positiveMask = positive?.uppercase()?.toSet() ?: emptySet()
        val negativeMask = negative?.uppercase()?.toSet() ?: emptySet()

        val words = wordRepository.searchByLetters(
            maskChars.getOrNull(0),
            maskChars.getOrNull(1),
            maskChars.getOrNull(2),
            maskChars.getOrNull(3),
            maskChars.getOrNull(4)
        )

        return words.filter { word ->
            val wordLetters = listOf(word.letter0, word.letter1, word.letter2, word.letter3, word.letter4)

            val matchesMask = maskChars.withIndex().all { (index, char) ->
                char == null || wordLetters[index] == char
            }
            val containsPositive = positiveMask.all { it in wordLetters }
            val excludesNegative = negativeMask.none { it in wordLetters }

            matchesMask && containsPositive && excludesNegative
        }.map { it.toDto() }
    }

    fun Word.toDto(): WordDto {
        val wordAsString = listOf(letter0, letter1, letter2, letter3, letter4).joinToString("")
        return WordDto(word = wordAsString)
    }
}