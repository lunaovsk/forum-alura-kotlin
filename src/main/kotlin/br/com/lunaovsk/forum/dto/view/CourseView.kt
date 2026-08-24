package br.com.lunaovsk.forum.dto.view

import java.io.Serializable

data class CourseView(
    val id: Long?,
    val name: String,
    val category: String
)  : Serializable
