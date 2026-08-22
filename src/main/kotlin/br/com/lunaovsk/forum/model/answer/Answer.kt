package br.com.lunaovsk.forum.model.answer

import br.com.lunaovsk.forum.model.topics.Topic
import br.com.lunaovsk.forum.model.user.UserData
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import java.time.LocalDateTime

@Entity(name = "tb_answer")
class Answer (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var message: String,
    var createdAt: LocalDateTime = LocalDateTime.now(),
    @ManyToOne
    var user: UserData,
    @ManyToOne()
    var topic: Topic,
    var solution: Boolean
)