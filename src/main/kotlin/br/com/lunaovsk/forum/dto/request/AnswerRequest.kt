package br.com.lunaovsk.forum.dto.request

import jakarta.validation.constraints.NotBlank
import org.jetbrains.annotations.NotNull

data class AnswerRequest(
    @NotBlank
    val message: String,
    @NotNull
    val userId: Long,
    @NotNull
    val topicId: Long,
    val solution: Boolean = false
)
