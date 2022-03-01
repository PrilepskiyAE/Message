package com.ambrella.message.domain.usecase.user.deleteuser

interface DeleteUserUseCase {
    suspend fun exec(username: String, pass: String)
}