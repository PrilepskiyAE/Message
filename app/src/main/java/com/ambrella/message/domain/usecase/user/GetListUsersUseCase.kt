package com.ambrella.message.domain.usecase.user

import com.ambrella.message.domain.entity.User
import com.ambrella.message.domain.repository.UserRepository

class GetListUsersUseCase(val userRepository: UserRepository) {
    suspend fun exec(): List<User> = userRepository.getListUser()
}