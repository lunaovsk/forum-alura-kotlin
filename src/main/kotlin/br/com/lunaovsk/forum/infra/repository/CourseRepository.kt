package br.com.lunaovsk.forum.infra.repository

import br.com.lunaovsk.forum.model.course.Course
import org.springframework.data.jpa.repository.JpaRepository

interface CourseRepository : JpaRepository<Course, Long> {
}