package br.com.lunaovsk.forum.infra.exception

import jakarta.persistence.EntityNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ProblemDetail
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandlerGlobal {

    @ExceptionHandler(EntityNotFoundException::class)
    fun handleNotFound(exception: EntityNotFoundException): ProblemDetail {
        // Cria o ProblemDetail nativo do Spring Boot 3
        val problemDetail = ProblemDetail.forStatusAndDetail(
            HttpStatus.NOT_FOUND,
            exception.message ?: "Recurso não encontrado"
        )
        problemDetail.setProperty("dica", "Verifique se o ID passado no JSON está correto.")
        return problemDetail
    }
}