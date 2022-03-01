package com.ambrella.message.domain.usecase.user.searchuseres

import com.ambrella.message.domain.entity.User
import com.ambrella.message.domain.repository.UserRepository

import javax.inject.Inject


class SearchUsersUseCaseImpl @Inject constructor(var repository: UserRepository): SearchUsersUseCase {
    override suspend fun exec(username:String): List<User> = repository.searchUsers(username)
}