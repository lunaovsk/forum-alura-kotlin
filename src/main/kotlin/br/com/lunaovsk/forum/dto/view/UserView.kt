package br.com.lunaovsk.forum.dto.view

import java.io.Serializable

data class UserView(
    val id: Long?,
    val name: String,
    val username: String
)  : Serializable