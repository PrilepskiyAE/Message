package com.ambrella.message.domain.usecase.user

import androidx.lifecycle.LiveData
import com.ambrella.message.domain.entity.User
import com.ambrella.message.domain.repository.UserRepository

class GetListUsersUseCase(val userRepository: UserRepository) {
    fun exec():LiveData<List<User>>{
        return userRepository.getListUser()
    }
}