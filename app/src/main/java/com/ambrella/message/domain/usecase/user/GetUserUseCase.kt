package com.ambrella.message.domain.usecase.user

import androidx.lifecycle.LiveData
import com.ambrella.message.domain.entity.User
import com.ambrella.message.domain.repository.UserRepository
import javax.inject.Inject

class GetUserUseCase @Inject constructor(var repository: UserRepository):UserUseCase.GetUserUseCase {
     override suspend fun exec(id:Int):User{
        return repository.getUser(id)
    }
}