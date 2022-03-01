package com.ambrella.message.domain.usecase.user.updateuser

import com.ambrella.message.domain.entity.User

interface UpdateUserUseCase {
    suspend fun exec(user: User)
}