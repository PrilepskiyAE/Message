package com.ambrella.message.domain.usecase.user.searchuseres

import com.ambrella.message.domain.entity.User

interface SearchUsersUseCase{
    suspend fun exec(username:String): List<User>
}