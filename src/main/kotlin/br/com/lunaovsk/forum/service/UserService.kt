package br.com.lunaovsk.forum.service

import br.com.lunaovsk.forum.dto.request.UserRequest
import br.com.lunaovsk.forum.dto.view.UserView
import br.com.lunaovsk.forum.infra.repository.UserRepository
import br.com.lunaovsk.forum.mapper.request.RequestMapper
import br.com.lunaovsk.forum.mapper.view.Mapper
import br.com.lunaovsk.forum.model.user.UserData
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class UserService (
    private val userRepository: UserRepository,
    private val requestMapper: RequestMapper<UserRequest, UserData>,
    private val viewMapper: Mapper<UserData, UserView>


) {


    @Transactional
    fun create(userDTO: UserRequest): UserView {
        val user = requestMapper.map(userDTO);
        val createdUser = userRepository.save(user);
        return viewMapper.map(createdUser);
    }
}
