package com.ambrella.message.domain.usecase.user

import com.ambrella.message.domain.entity.User
import com.ambrella.message.domain.repository.UserRepository

class CreateUserUseCase(val userRepository: UserRepository) {
    fun exec(user: User){
        userRepository.createUser(user)
    }
}