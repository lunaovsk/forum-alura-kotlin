package br.com.lunaovsk.forum.mapper.view

import br.com.lunaovsk.forum.dto.view.AnswerView
import br.com.lunaovsk.forum.dto.view.UserView
import br.com.lunaovsk.forum.model.answer.Answer
import br.com.lunaovsk.forum.model.user.UserData
import org.springframework.stereotype.Component

@Component
class AnswerViewMapper(

    private val userMapper: Mapper<UserData, UserView>
    ) : Mapper<Answer, AnswerView> {

    override fun map(model: Answer): AnswerView {
        return AnswerView(
            id = model.id,
            message = model.message,
            createdAt = model.createdAt,
            user = userMapper.map(model.user),
            solution = model.solution
        )
    }


}