package com.ambrella.message.domain.usecase.user

import com.ambrella.message.domain.entity.User
import com.ambrella.message.domain.repository.UserRepository
import javax.inject.Inject

class DeleteUserUserCase @Inject constructor(var repository: UserRepository):UserUseCase.DeleteUserUseCase {
//   suspend fun exec(user: User){
//        userRepository.deleteUser(user)
//    }

    override suspend fun exec(username: String, pass: String) {
        repository.deleteUser(User(username = username, password = pass))
    }
}