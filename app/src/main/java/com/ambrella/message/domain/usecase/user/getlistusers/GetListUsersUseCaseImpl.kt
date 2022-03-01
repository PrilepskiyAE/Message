package com.ambrella.message.domain.usecase.user.getlistusers

import com.ambrella.message.domain.entity.User
import com.ambrella.message.domain.repository.UserRepository

import javax.inject.Inject

class GetListUsersUseCaseImpl @Inject constructor(var repository: UserRepository): GetListUsersUseCase {
    override suspend fun exec(): List<User> = repository.getListUser()
}