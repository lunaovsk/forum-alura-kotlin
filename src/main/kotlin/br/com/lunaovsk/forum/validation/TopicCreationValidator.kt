package br.com.lunaovsk.forum.validation

import br.com.lunaovsk.forum.dto.request.TopicRequest
import br.com.lunaovsk.forum.infra.repository.CourseRepository
import br.com.lunaovsk.forum.infra.repository.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.server.ResponseStatusException

@Component
class TopicCreationValidator(
    private val courseRepository: CourseRepository,
    private val userRepository: UserRepository
) : Validator<TopicRequest> {

    override fun validate(model: TopicRequest) {

        if (!userRepository.existsById(model.userId)) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Autor não encontrado!")
        }
        if (!courseRepository.existsById(model.courseId)) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Curso não encontrado!")
        }
    }
}