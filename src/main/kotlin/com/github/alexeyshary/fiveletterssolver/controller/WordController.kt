package com.github.alexeyshary.fiveletterssolver.controller

import com.github.alexeyshary.fiveletterssolver.model.WordDto
import com.github.alexeyshary.fiveletterssolver.service.WordService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import org.springframework.ui.Model

@Controller
@RequestMapping("/words")
class WordController(private val wordService: WordService) {
    @GetMapping
    fun showSearchForm(model: Model): String {
        model.addAttribute("maskChars", listOf("*", "*", "*", "*", "*"))
        model.addAttribute("mask", "*****")
        model.addAttribute("positive", "")
        model.addAttribute("negative", "")
        model.addAttribute("results", emptyList<WordDto>())
        return "words-search"
    }

    @PostMapping
    fun searchWords(
        @RequestParam mask: String,
        @RequestParam positive: String?,
        @RequestParam negative: String?,
        model: Model
    ): String {
        val results = wordService.findWordsByMask(mask, positive, negative)
        val maskChars = mask.padEnd(5, '*').take(5).toList().map { it.toString() }

        model.addAttribute("maskChars", maskChars)
        model.addAttribute("mask", mask)
        model.addAttribute("positive", positive)
        model.addAttribute("negative", negative)
        model.addAttribute("results", results.ifEmpty { listOf(WordDto("Таких слов не найдено")) })

        return "words-search"
    }
}