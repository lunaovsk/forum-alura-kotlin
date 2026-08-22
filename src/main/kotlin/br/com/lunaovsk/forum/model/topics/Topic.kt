package br.com.lunaovsk.forum.model.topics

import br.com.lunaovsk.forum.model.answer.Answer
import br.com.lunaovsk.forum.model.course.Course
import br.com.lunaovsk.forum.model.user.UserData
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import java.time.LocalDateTime


@Entity(name = "tb_topics")
class Topic(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var title: String,
    var message: String,
    var createdAt: LocalDateTime = LocalDateTime.now(),
    @ManyToOne
    var course: Course,
    @ManyToOne
    var user: UserData,
    @Enumerated(EnumType.STRING)
    var status: StatusTopic = StatusTopic.NOT_ANSWERED,
    @OneToMany(mappedBy = "topic")
    var answer: MutableList<Answer> = ArrayList()


    )