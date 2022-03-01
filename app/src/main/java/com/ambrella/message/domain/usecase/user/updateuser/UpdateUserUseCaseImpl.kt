package com.ambrella.message.domain.usecase.user.updateuser

import com.ambrella.message.domain.entity.User
import com.ambrella.message.domain.repository.UserRepository
import javax.inject.Inject

class UpdateUserUseCaseImpl @Inject constructor(var repository: UserRepository): UpdateUserUseCase {

    override suspend fun exec(user:User) = repository.updateUser(user)

}