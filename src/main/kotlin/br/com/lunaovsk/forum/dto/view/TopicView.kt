package br.com.lunaovsk.forum.dto.view

import br.com.lunaovsk.forum.model.topics.StatusTopic
import java.time.LocalDateTime

data class TopicView (
    var id: Long? = null,
    var title: String,
    var message: String,
    var createdAt: LocalDateTime,
    var status: StatusTopic,
    var answer: List<AnswerView>

)