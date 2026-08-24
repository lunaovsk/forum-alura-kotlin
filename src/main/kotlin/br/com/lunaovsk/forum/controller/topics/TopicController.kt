package br.com.lunaovsk.forum.controller.topics

import br.com.lunaovsk.forum.dto.request.TopicRequest
import br.com.lunaovsk.forum.dto.view.TopicView
import br.com.lunaovsk.forum.service.TopicService
import org.hibernate.annotations.Parameter
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/topic")
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
    fun getAllTopics(@PageableDefault(size = 10, sort = ["createdAt"]) paginacao: Pageable): ResponseEntity<List<TopicView>> {
        val page = service.getTopics();
        return ResponseEntity.ok().body(page);
    }

    @GetMapping("/{id}")
    fun getTopicById (@PathVariable id: Long): ResponseEntity<TopicView> {
        val topic = service.getTopic(id);
        return ResponseEntity.ok(topic);
    }



    @PostMapping
    fun creatTopic(@RequestBody topic: TopicRequest): ResponseEntity<TopicView> {
        val create = service.createdTopic(topic);
        return ResponseEntity.status(HttpStatus.CREATED).body(create);
    }

}