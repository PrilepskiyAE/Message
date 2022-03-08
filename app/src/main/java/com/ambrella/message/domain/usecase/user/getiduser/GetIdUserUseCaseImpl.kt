package com.ambrella.message.domain.usecase.user.getiduser

import android.content.Context
import com.ambrella.message.domain.repository.UserRepository
import javax.inject.Inject

class GetIdUserUseCaseImpl@Inject constructor(var repository: UserRepository):GetIdUserUseCase {
    override fun exec(context: Context): Int {
        return repository.getId(context)
    }
}