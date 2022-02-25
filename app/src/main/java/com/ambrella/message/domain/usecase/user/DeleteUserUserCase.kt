package com.ambrella.message.domain.usecase.user

import com.ambrella.message.domain.entity.User
import com.ambrella.message.domain.repository.UserRepository

class DeleteUserUserCase(val userRepository: UserRepository):UserUseCase.CreateUserUseCase {
//   suspend fun exec(user: User){
//        userRepository.deleteUser(user)
//    }

    override suspend fun exec(username: String, pass: String) {
        userRepository.deleteUser(User(username = username, password = pass))
    }
}