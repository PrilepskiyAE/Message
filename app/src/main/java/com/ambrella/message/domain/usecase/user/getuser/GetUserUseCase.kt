package com.ambrella.message.domain.usecase.user.getuser

import com.ambrella.message.domain.entity.User

interface GetUserUseCase{
    suspend fun exec(id:Int): User
}