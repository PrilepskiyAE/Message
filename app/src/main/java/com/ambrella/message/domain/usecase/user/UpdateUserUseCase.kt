package com.ambrella.message.domain.usecase.user

import com.ambrella.message.domain.entity.User
import com.ambrella.message.domain.repository.UserRepository

class UpdateUserUseCase(val userRepository: UserRepository):UserUseCase.UpdateUserUseCase {

    override suspend fun exec(user:User) = userRepository.updateUser(user)

}