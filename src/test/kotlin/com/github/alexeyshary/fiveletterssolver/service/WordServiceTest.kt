package com.github.alexeyshary.fiveletterssolver.service

import com.github.alexeyshary.fiveletterssolver.model.Word
import com.github.alexeyshary.fiveletterssolver.repository.WordRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*

class WordServiceTest {

    private val wordRepository = mock(WordRepository::class.java)
    private val logService = mock(LogService::class.java)
    private val wordService = WordService(wordRepository, logService)

    @Test
    fun `findWordsByMask should filter words correctly`() {
        val mockWords = listOf(
            Word(letter0 = 'Б', letter1 = 'У', letter2 = 'К', letter3 = 'В', letter4 = 'А'),
            Word(letter0 = 'Б', letter1 = 'У', letter2 = 'К', letter3 = 'В', letter4 = 'О')
        )
        `when`(wordRepository.searchByLetters('Б', 'У', null, null, null)).thenReturn(mockWords)
        doNothing().`when`(logService).saveLog(anyString(), anyString(), anyString())

        val mask = "бу***"
        val positive = "ва"
        val negative = "о"
        val result = wordService.findWordsByMask(mask, positive, negative)

        val expected = listOf("БУКВА")
        assertEquals(expected, result.map { it.word })

        verify(wordRepository).searchByLetters('Б', 'У', null, null, null)
        verifyNoMoreInteractions(wordRepository)

        verify(logService).saveLog(anyString(), anyString(), anyString())
        verifyNoMoreInteractions(logService)
    }
}