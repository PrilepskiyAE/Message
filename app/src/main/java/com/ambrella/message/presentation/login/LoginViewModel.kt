package com.ambrella.message.presentation.login

import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ambrella.message.domain.entity.User
import com.ambrella.message.domain.repository.UserRepository
import com.ambrella.message.domain.usecase.user.CreateUserUseCase
import com.ambrella.message.domain.usecase.user.GetListUsersUseCase
import com.ambrella.message.domain.usecase.user.SearchUsersUseCase
import kotlinx.coroutines.launch

class LoginViewModel(private val repository: UserRepository):ViewModel() {
    private val createUserUseCase=CreateUserUseCase(repository)
    private val getListUsersUseCase=GetListUsersUseCase(repository)
    val searchUsersUseCase=SearchUsersUseCase(repository)
    val userList=getListUsersUseCase.exec()

    fun loginByUser(username:String,password:String)
    {

        viewModelScope.launch {
            var check:Boolean=false
               val users = searchUsersUseCase.exec(username).value
            if (users != null) {
                for (user in users) {
                    check = user.username == username && user.password==password
                    Log.e("TAG", "loginByUser: str= $username db = ${user.username}  ")
                }
            }else
            {
                createUserUseCase.exec(User(username = username, password = password))
                Log.e("TAG", "loginByUser: str= $username  nok,${searchUsersUseCase.exec(username)}")
            }


        }


    }

}