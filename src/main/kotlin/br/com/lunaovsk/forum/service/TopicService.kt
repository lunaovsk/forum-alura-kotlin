package br.com.lunaovsk.forum.service

import br.com.lunaovsk.forum.dto.request.TopicRequest
import br.com.lunaovsk.forum.dto.view.TopicView
import br.com.lunaovsk.forum.infra.repository.TopicsRepository
import br.com.lunaovsk.forum.mapper.request.TopicRequestMapper
import br.com.lunaovsk.forum.mapper.view.Mapper
import br.com.lunaovsk.forum.model.topics.Topic
import br.com.lunaovsk.forum.validation.Validator
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

@Service
class TopicService(

    private val topicsRepository: TopicsRepository,
    private val mapperView: Mapper<Topic, TopicView>,
    private val validator: Validator<TopicRequest>,
    private val requestMapper: TopicRequestMapper

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
        val list = topicsRepository.findAll();
        return list.map(mapperView::map);
    }

    @Cacheable(value = ["topic"], key = "#id")
    fun getTopic(id: Long): TopicView {
        val topic = topicsRepository.findById(id).get();
        return mapperView.map(topic);
    }

    fun createdTopic(topic: TopicRequest) : TopicView {
        validator.validate(topic);
        val topicEntity = requestMapper.map(topic);
        val createTopic = topicsRepository.save(topicEntity);
        return mapperView.map(createTopic);
    }

}