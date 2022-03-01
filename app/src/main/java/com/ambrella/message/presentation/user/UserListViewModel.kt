package com.ambrella.message.presentation.user

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ambrella.message.domain.entity.User
import com.ambrella.message.domain.usecase.user.getlistusers.GetListUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserListViewModel@Inject constructor():ViewModel() {
        private val _usersList = MutableLiveData<List<User>>()
        val usersList: LiveData<List<User>>
        get() = _usersList
      @Inject  lateinit var  getListUsersUseCase : GetListUsersUseCase
        fun getUsers() {
        viewModelScope.launch {
            _usersList.value=getListUsersUseCase.exec()
        }
    }

}







