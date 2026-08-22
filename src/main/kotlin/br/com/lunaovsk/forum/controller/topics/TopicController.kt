package br.com.lunaovsk.forum.controller.topics

import br.com.lunaovsk.forum.dto.request.TopicRequest
import br.com.lunaovsk.forum.dto.view.TopicView
import br.com.lunaovsk.forum.model.topics.Topic
import br.com.lunaovsk.forum.service.TopicService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/topics")
class TopicController (
    private val service: TopicService,
) {

    /**
     * Busca e lista todos os tópicos disponíveis no fórum.
     * 
     * Este endpoint recupera as entidades de domínio através do [TopicService] e as converte 
     * para o DTO [TopicView] utilizando o [TopicsViewMapper]. Essa conversão garante que 
     * a estrutura interna do banco de dados (Entidade) não seja exposta diretamente na API.
     *
     * @return [ResponseEntity] contendo a lista de tópicos formatada para visualização (Status 200 OK).
     */
    @GetMapping
    fun getAllTopics(): ResponseEntity<List<TopicView>> {
        val list = service.getTopics();
        return ResponseEntity.ok().body(list);
    }
//
//    @PostMapping
//    fun creatTopic(@RequestBody topic: TopicRequest): ResponseEntity<Topic> {
//        var create = service.createdTopic();
//    }

}