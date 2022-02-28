package com.ambrella.message.domain.usecase.user

import android.util.Log
import com.ambrella.message.domain.entity.User
import com.ambrella.message.domain.repository.UserRepository
import javax.inject.Inject


class SearchUsersUseCase @Inject constructor(var repository: UserRepository):UserUseCase.SearchUsersUseCase {
    override suspend fun exec(username:String): List<User> = repository.searchUsers(username)
}