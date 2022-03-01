package com.ambrella.message.presentation.registration

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ambrella.message.domain.entity.User
import com.ambrella.message.domain.usecase.user.updateuser.UpdateUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel@Inject constructor(): ViewModel() {
  @Inject  lateinit var updateUserUseCase: UpdateUserUseCase

    fun update(id:Int,username: String,password:String,resId:String)
    {
        viewModelScope.launch(IO) {
            updateUserUseCase.exec(User(id,username,password,resId))
        }
    }

}