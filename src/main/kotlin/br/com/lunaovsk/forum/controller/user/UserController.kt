package br.com.lunaovsk.forum.controller.user

import br.com.lunaovsk.forum.dto.request.UserRequest
import br.com.lunaovsk.forum.dto.view.UserView
import br.com.lunaovsk.forum.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/user")
class UserController (
    private val service: UserService
) {


    @PostMapping("/create-account")
    fun createAccount(@RequestBody user: UserRequest): ResponseEntity<UserView> {
        val userCreated = service.create(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);
    }



}