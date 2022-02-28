package com.ambrella.message.domain.usecase.user

import com.ambrella.message.domain.entity.User
import com.ambrella.message.domain.repository.UserRepository
import javax.inject.Inject

class GetListUsersUseCase @Inject constructor(var repository: UserRepository):UserUseCase.GetListUsersUseCase {
    override suspend fun exec(): List<User> = repository.getListUser()
}