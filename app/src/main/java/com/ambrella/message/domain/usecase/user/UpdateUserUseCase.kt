package com.ambrella.message.domain.usecase.user

import com.ambrella.message.domain.entity.User
import com.ambrella.message.domain.repository.UserRepository
import javax.inject.Inject

class UpdateUserUseCase @Inject constructor(var repository: UserRepository):UserUseCase.UpdateUserUseCase {

    override suspend fun exec(user:User) = repository.updateUser(user)

}