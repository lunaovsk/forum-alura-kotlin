package br.com.lunaovsk.forum.mapper

import br.com.lunaovsk.forum.dto.view.AnswerView
import br.com.lunaovsk.forum.model.topics.Topic
import br.com.lunaovsk.forum.dto.view.TopicView
import br.com.lunaovsk.forum.model.answer.Answer
import org.springframework.stereotype.Component

/**
 * Componente responsável por mapear a entidade de domínio [Topic] para o DTO de saída [TopicView].
 * 
 * O uso deste Mapper é fundamental para o padrão DTO, isolando o modelo de dados real (banco) 
 * das informações que serão efetivamente trafegadas via JSON na API REST.
 */
@Component
class TopicsViewMapper(
    private val answerMapper: Mapper<Answer, AnswerView>

) : Mapper<Topic, TopicView> {
    /**
     * Executa a conversão dos dados do Tópico.
     * 
     * Além de mapear os campos básicos (id, título, mensagem), este método itera sobre a 
     * lista de respostas (`answer`) do tópico e delega a conversão de cada resposta 
     * individualmente para o [answerMapper], mantendo o padrão DTO em toda a árvore de objetos.
     *
     * @param model A entidade [Topic] originada do banco de dados.
     * @return O objeto [TopicView] montado e pronto para a camada de visualização/Controller.
     */
    override fun map(model: Topic): TopicView {
        return TopicView(
            id = model.id,
            title = model.title,
            message = model.message,
            createdAt = model.createdAt,
            status = model.status,
            answer = model.answer.map(answerMapper::map)
        )
    }

}