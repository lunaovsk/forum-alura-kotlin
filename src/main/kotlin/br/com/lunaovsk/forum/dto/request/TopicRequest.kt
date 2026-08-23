package br.com.lunaovsk.forum.dto.request

import jakarta.validation.constraints.NotBlank
import org.jetbrains.annotations.NotNull

data class TopicRequest(
    @NotBlank
    val title: String,
    @NotBlank
    val message: String,
    @NotNull
    val userId: Long,
    @NotNull
    val courseId: Long,
)