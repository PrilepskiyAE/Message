package com.ambrella.message.domain.usecase.user.getlistusers

import com.ambrella.message.domain.entity.User

interface GetListUsersUseCase{
    suspend fun exec(): List<User>
}