package br.com.lunaovsk.forum.mapper.request

import br.com.lunaovsk.forum.dto.request.UserRequest
import br.com.lunaovsk.forum.model.user.UserData
import org.springframework.stereotype.Component

@Component
class UserRequestMapper: RequestMapper<UserRequest, UserData> {
    override fun map(model: UserRequest): UserData {
        return UserData(
            name = model.name,
            username = model.username
        )
    }
}