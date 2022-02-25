package com.ambrella.message.domain.usecase.user

import com.ambrella.message.domain.entity.User

interface UserUseCase {
    interface CreateUserUseCase{
       suspend fun exec(username:String,pass: String)
    }
    interface DeleteUserUseCase {
            suspend fun exec(username:String,pass: String)
    }

    interface GetListUsersUseCase{
        suspend fun exec(): List<User>
    }
    interface GetUserUseCase{
        suspend fun exec(id:Int):User
    }
    interface SearchUsersUseCase{
        suspend fun exec(username:String): List<User>
    }
    interface UpdateUserUseCase{
        suspend fun exec(user:User)
    }
}