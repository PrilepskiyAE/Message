package com.ambrella.message.domain.usecase.user.setiduser

import android.content.Context
import com.ambrella.message.domain.repository.UserRepository
import javax.inject.Inject

class SetIdUserUseCaseImpl@Inject constructor(var repository: UserRepository):SetIdUserUseCase  {
    override fun exec(id: Int,context: Context) {
        repository.putId(context,id)
    }
}