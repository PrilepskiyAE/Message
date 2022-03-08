package com.ambrella.message.domain.usecase.user.createuser

interface CreateUserUseCase {
    suspend fun exec(id:Int=0,username:String,pass: String)
}