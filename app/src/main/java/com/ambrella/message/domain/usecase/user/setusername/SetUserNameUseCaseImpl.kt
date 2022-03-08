package com.ambrella.message.domain.usecase.user.setusername

import android.content.Context
import com.ambrella.message.domain.repository.UserRepository
import javax.inject.Inject

class SetUserNameUseCaseImpl@Inject constructor(var repository: UserRepository) : SetUserNameUseCase{
    override fun exec(name: String, context: Context) {
     repository.putUserName(context,name)
    }
}