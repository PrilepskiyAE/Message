package com.ambrella.message.domain.usecase.user.getiduser

import android.content.Context

interface GetIdUserUseCase {
    fun exec(context: Context):Int
}