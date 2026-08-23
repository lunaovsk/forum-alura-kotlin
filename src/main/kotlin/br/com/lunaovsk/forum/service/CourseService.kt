package br.com.lunaovsk.forum.service

import br.com.lunaovsk.forum.dto.request.CourseRequest
import br.com.lunaovsk.forum.dto.view.CourseView
import br.com.lunaovsk.forum.infra.repository.CourseRepository
import br.com.lunaovsk.forum.mapper.request.RequestMapper
import br.com.lunaovsk.forum.mapper.view.Mapper
import br.com.lunaovsk.forum.model.course.Course
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class CourseService (
    private val courseRepository: CourseRepository,
    private val requestMapper: RequestMapper<CourseRequest, Course>,
    private val viewMapper: Mapper<Course, CourseView>
) {
    fun getAllCourses(): List<CourseView> {
        val list = courseRepository.findAll();
        return list.map(viewMapper::map);
    }

    @Transactional
    fun create(courseDTO: CourseRequest): CourseView {
        val course = requestMapper.map(courseDTO);
        val createdCourse = courseRepository.save(course);
        return viewMapper.map(createdCourse);
    }
}
