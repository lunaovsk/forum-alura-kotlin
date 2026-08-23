package br.com.lunaovsk.forum.validation

import br.com.lunaovsk.forum.dto.request.AnswerRequest
import br.com.lunaovsk.forum.infra.repository.TopicsRepository
import br.com.lunaovsk.forum.infra.repository.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.server.ResponseStatusException

@Component
class AnswerCreationValidator(
    private val topicsRepository: TopicsRepository,
    private val userRepository: UserRepository
) : Validator<AnswerRequest> {

    override fun validate(model: AnswerRequest) {
        if (!userRepository.existsById(model.userId)) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Autor não encontrado!")
        }
        if (!topicsRepository.existsById(model.topicId)) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Tópico não encontrado!")
        }
    }
}
