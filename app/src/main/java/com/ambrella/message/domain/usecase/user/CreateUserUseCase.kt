package com.ambrella.message.domain.usecase.user

import com.ambrella.message.domain.entity.User
import com.ambrella.message.domain.repository.UserRepository

class CreateUserUseCase(val userRepository: UserRepository):UserUseCase.CreateUserUseCase {

    override suspend fun exec(username:String,pass: String) {
        userRepository.createUser(User(username = username, password = pass))
    }
}