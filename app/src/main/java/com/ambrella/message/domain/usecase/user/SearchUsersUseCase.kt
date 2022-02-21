package com.ambrella.message.domain.usecase.user

import androidx.lifecycle.LiveData
import com.ambrella.message.domain.entity.User
import com.ambrella.message.domain.repository.UserRepository

class SearchUsersUseCase(val userRepository: UserRepository) {
    fun exec(username:String): LiveData<List<User>> {
        return userRepository.searchUsers(username)
    }
}