package com.ambrella.message.domain.usecase.user.createuser

interface CreateUserUseCase {
    suspend fun exec(username:String,pass: String)
}