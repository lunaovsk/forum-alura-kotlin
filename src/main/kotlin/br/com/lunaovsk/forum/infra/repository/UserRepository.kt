package br.com.lunaovsk.forum.infra.repository

import br.com.lunaovsk.forum.model.user.UserData
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<UserData, Long> {

}