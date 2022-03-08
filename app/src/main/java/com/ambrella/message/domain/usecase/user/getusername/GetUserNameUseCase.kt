package com.ambrella.message.domain.usecase.user.getusername

import android.content.Context

interface GetUserNameUseCase {
    fun exec(context: Context):String
}