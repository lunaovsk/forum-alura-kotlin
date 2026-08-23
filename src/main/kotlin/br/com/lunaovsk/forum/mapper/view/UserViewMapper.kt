package br.com.lunaovsk.forum.mapper.view

import br.com.lunaovsk.forum.dto.view.UserView
import br.com.lunaovsk.forum.model.user.UserData
import org.springframework.stereotype.Component

@Component
class UserViewMapper: Mapper<UserData, UserView> {
    override fun map(model: UserData): UserView {
        return UserView(
            id = model.id,
            name = model.name,
            username = model.username
        )
    }

}