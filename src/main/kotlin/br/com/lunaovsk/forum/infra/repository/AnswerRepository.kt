package br.com.lunaovsk.forum.infra.repository

import br.com.lunaovsk.forum.model.answer.Answer
import org.springframework.data.jpa.repository.JpaRepository

interface AnswerRepository : JpaRepository<Answer, Long>
