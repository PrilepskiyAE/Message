package com.ambrella.message.presentation.user

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ambrella.message.domain.entity.User
import com.ambrella.message.domain.repository.UserRepository
import com.ambrella.message.domain.usecase.user.GetListUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class UserListViewModel@Inject constructor(repository: UserRepository):ViewModel() {
        private val _usersList = MutableLiveData<List<User>>()
        val usersList: LiveData<List<User>>
        get() = _usersList
        private val getListUsersUseCase = GetListUsersUseCase(repository)
        fun getUsers() {
        viewModelScope.launch {
            _usersList.value=getListUsersUseCase.exec()
        }
    }

}







