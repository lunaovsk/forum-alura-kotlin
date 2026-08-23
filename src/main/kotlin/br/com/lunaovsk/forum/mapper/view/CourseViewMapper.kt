package br.com.lunaovsk.forum.mapper.view

import br.com.lunaovsk.forum.dto.view.CourseView
import br.com.lunaovsk.forum.model.course.Course
import org.springframework.stereotype.Component

@Component
class CourseViewMapper : Mapper<Course, CourseView> {
    override fun map(model: Course): CourseView {
        return CourseView(
            id = model.id,
            name = model.name,
            category = model.category
        )
    }
}
