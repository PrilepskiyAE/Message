package com.ambrella.message.domain.usecase.user.getusername

import android.content.Context
import com.ambrella.message.domain.repository.UserRepository
import javax.inject.Inject

class GetUserNameUseCaseImpl@Inject constructor(var repository: UserRepository) :GetUserNameUseCase{
    override fun exec(context: Context): String {
        return repository.getUserName(context)
    }
}