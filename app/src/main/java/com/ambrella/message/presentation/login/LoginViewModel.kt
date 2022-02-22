package com.ambrella.message.presentation.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ambrella.message.domain.entity.User
import com.ambrella.message.domain.repository.UserRepository
import com.ambrella.message.domain.usecase.user.CreateUserUseCase
import com.ambrella.message.domain.usecase.user.GetListUsersUseCase
import com.ambrella.message.domain.usecase.user.SearchUsersUseCase
import com.ambrella.message.presentation.SingleLiveEvent
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class LoginViewModel(private val repository: UserRepository) : ViewModel() {
    private val createUserUseCase = CreateUserUseCase(repository)
    private val getListUsersUseCase = GetListUsersUseCase(repository)
    private val searchUsersUseCase = SearchUsersUseCase(repository)


    private val _usersList = MutableLiveData<List<User>>()
    val usersList: LiveData<List<User>>
        get() = _usersList

    private val _searchedUsersList = SingleLiveEvent<List<User>>()
    val searchedUsersList: LiveData<List<User>>
        get() = _searchedUsersList

    fun createUser(username: String, password: String) {
        viewModelScope.launch(IO) {
            createUserUseCase.exec(
                User(
                    username = username,
                    password = password
                )
            )
        }
    }

    fun searchUsers(username: String) {
        viewModelScope.launch {
            _searchedUsersList.value = async { searchUsersUseCase.exec(username) }.await()
        }
    }
}

