package br.com.lunaovsk.forum.controller.course

import br.com.lunaovsk.forum.dto.request.CourseRequest
import br.com.lunaovsk.forum.dto.view.CourseView
import br.com.lunaovsk.forum.service.CourseService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/courses")
class CourseController (
    private val service: CourseService
) {
    @GetMapping
    fun getAllCourses(): ResponseEntity<List<CourseView>> {
        val list = service.getAllCourses();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    fun createCourse(@RequestBody course: CourseRequest): ResponseEntity<CourseView> {
        val courseCreated = service.create(course);
        return ResponseEntity.status(HttpStatus.CREATED).body(courseCreated);
    }
}
