package br.com.lunaovsk.forum.dto.request

data class TopicRequest(
    var title: String,
    var message: String,
    var course: CourseRequest,
    var user: UserRequest,
    )