package com.ambrella.message.domain.usecase.user

import android.util.Log
import com.ambrella.message.domain.entity.User
import com.ambrella.message.domain.repository.UserRepository
import com.ambrella.message.presentation.login.TAG

class SearchUsersUseCase(val userRepository: UserRepository) {
    suspend fun exec(username:String): List<User> = userRepository.searchUsers(username)
}