package com.ambrella.message.domain.usecase.user

import androidx.lifecycle.LiveData
import com.ambrella.message.domain.entity.User
import com.ambrella.message.domain.repository.UserRepository

class GetUserUseCase(val userRepository: UserRepository):UserUseCase.GetUserUseCase {
     override suspend fun exec(id:Int):User{
        return userRepository.getUser(id)
    }
}