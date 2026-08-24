package br.com.lunaovsk.forum.dto.view

import java.io.Serializable
import java.time.LocalDateTime

data class AnswerView(
    val id: Long?,
    val message: String,
    val createdAt: LocalDateTime,
    val user: UserView,
    var solution: Boolean
) : Serializable