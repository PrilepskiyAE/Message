package com.ambrella.message.domain.usecase.user.setusername

import android.content.Context

interface SetUserNameUseCase {
    fun exec(name:String,context: Context)
}