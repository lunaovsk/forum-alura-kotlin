package br.com.lunaovsk.forum.mapper.request

import br.com.lunaovsk.forum.dto.request.AnswerRequest
import br.com.lunaovsk.forum.infra.repository.TopicsRepository
import br.com.lunaovsk.forum.infra.repository.UserRepository
import br.com.lunaovsk.forum.model.answer.Answer
import org.springframework.stereotype.Component

@Component
class AnswerRequestMapper(
    private val userRepository: UserRepository,
    private val topicsRepository: TopicsRepository
) : RequestMapper<AnswerRequest, Answer> {
    override fun map(model: AnswerRequest): Answer {
        val userRef = userRepository.getReferenceById(model.userId)
        val topicRef = topicsRepository.getReferenceById(model.topicId)
        return Answer(
            message = model.message,
            user = userRef,
            topic = topicRef,
            solution = model.solution
        )
    }
}
