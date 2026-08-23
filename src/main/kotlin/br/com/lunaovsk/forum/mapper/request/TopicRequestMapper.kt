package br.com.lunaovsk.forum.mapper.request

import br.com.lunaovsk.forum.dto.request.TopicRequest
import br.com.lunaovsk.forum.infra.repository.CourseRepository
import br.com.lunaovsk.forum.infra.repository.UserRepository
import br.com.lunaovsk.forum.model.topics.Topic
import org.springframework.stereotype.Component

@Component
class TopicRequestMapper(
    private val userRepository: UserRepository,
    private val courseRepository: CourseRepository
) : RequestMapper<TopicRequest, Topic> {
    override fun map(model: TopicRequest): Topic {
        val userRef = userRepository.getReferenceById(model.userId);
        val courseRef = courseRepository.getReferenceById(model.courseId);
        return Topic(
            title = model.title,
            message = model.message,
            user = userRef,
            course = courseRef

        )
    }

}