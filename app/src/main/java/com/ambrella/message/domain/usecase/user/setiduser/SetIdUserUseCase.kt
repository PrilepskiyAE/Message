package com.ambrella.message.domain.usecase.user.setiduser

import android.content.Context

interface SetIdUserUseCase {
    fun exec(id:Int,context: Context)
}