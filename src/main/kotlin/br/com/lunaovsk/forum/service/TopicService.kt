package br.com.lunaovsk.forum.service

import br.com.lunaovsk.forum.dto.view.TopicView
import br.com.lunaovsk.forum.infra.repository.TopicsRepository
import br.com.lunaovsk.forum.mapper.TopicsViewMapper
import br.com.lunaovsk.forum.model.topics.Topic
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TopicService (

    private val topicsRepository: TopicsRepository,
    private val topicsViewMapper: TopicsViewMapper


) {

    /**
     * Recupera todos os tópicos registrados no banco de dados.
     * 
     * A camada de Service atua como intermediária entre o Controller e o Repository.
     * No cenário atual de leitura simples, ela delega a busca para o [TopicsRepository], 
     * mas é o local correto para centralizar regras de negócio (como filtros 
     * de pesquisa, regras de visibilidade ou paginação) antes de devolver os dados.
     *
     * @return Uma lista contendo todas as entidades [TopicView].
     */
    fun getTopics(): List<TopicView> {
        var list = topicsRepository.findAll();
        return list.map { topicsViewMapper.map(it) }
    }

}