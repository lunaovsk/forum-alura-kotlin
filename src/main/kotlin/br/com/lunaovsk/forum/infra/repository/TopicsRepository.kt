package br.com.lunaovsk.forum.infra.repository

import br.com.lunaovsk.forum.model.topics.Topic
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TopicsRepository: JpaRepository<Topic, Long>{

}