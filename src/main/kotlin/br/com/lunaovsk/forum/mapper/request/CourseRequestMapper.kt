package br.com.lunaovsk.forum.mapper.request

import br.com.lunaovsk.forum.dto.request.CourseRequest
import br.com.lunaovsk.forum.model.course.Course
import org.springframework.stereotype.Component

@Component
class CourseRequestMapper : RequestMapper<CourseRequest, Course> {
    override fun map(model: CourseRequest): Course {
        return Course(
            name = model.name,
            category = model.category
        )
    }
}
