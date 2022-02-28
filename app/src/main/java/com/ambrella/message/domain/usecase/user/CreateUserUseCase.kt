package com.ambrella.message.domain.usecase.user

import com.ambrella.message.domain.entity.User
import com.ambrella.message.domain.repository.UserRepository
import javax.inject.Inject

class CreateUserUseCase @Inject constructor(var repository: UserRepository):UserUseCase.CreateUserUseCase {

    override suspend fun exec(username:String,pass: String) {
        repository.createUser(User(username = username, password = pass))
    }
}