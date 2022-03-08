package com.ambrella.message.domain.usecase.user.createuser

import com.ambrella.message.domain.entity.User
import com.ambrella.message.domain.repository.UserRepository
import javax.inject.Inject

class CreateUserUseCaseImpl @Inject constructor(var repository: UserRepository): CreateUserUseCase {

    override suspend fun exec(id:Int,username:String,pass: String) {
        repository.createUser(User(id = id, username = username, password = pass))
    }
}