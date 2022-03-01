package com.ambrella.message.presentation.login

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.*
import com.ambrella.message.R
import com.ambrella.message.domain.entity.User
import com.ambrella.message.domain.usecase.user.createuser.CreateUserUseCase
import com.ambrella.message.domain.usecase.user.getuser.GetUserUseCase
import com.ambrella.message.domain.usecase.user.searchuseres.SearchUsersUseCase
import com.ambrella.message.domain.usecase.user.updateuser.UpdateUserUseCase
import com.ambrella.message.presentation.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {
   @Inject lateinit var  createUserUseCase : CreateUserUseCase
   // private val getListUsersUseCase = GetListUsersUseCase(repository)
    @Inject lateinit var  searchUsersUseCase : SearchUsersUseCase
    @Inject lateinit var updateUserUseCase: UpdateUserUseCase




   private val _currentuser = MutableLiveData<User>()
    val currenuser: LiveData<User>
       get() = _currentuser
private val _stest = SingleLiveEvent<Boolean>()
    val stest: LiveData<Boolean>
        get() = _stest


    private val _searchedUsersList = SingleLiveEvent<List<User>>()
    val searchedUsersList: LiveData<List<User>>
        get() = _searchedUsersList

    fun createUser(username: String, password: String) {
        viewModelScope.launch(IO) {
            createUserUseCase.exec(
                     username,
                     password
            )
        }

    }
    fun updateUser(id:Int,login:String,password: String){
        viewModelScope.launch(IO) {
            updateUserUseCase.exec(User(
                id=id,
               username =  login,
               password =  password
            )

            )
        }
    }

    @SuppressLint("NullSafeMutableLiveData")
    fun searchUsers(username: String) {
        viewModelScope.launch {
            _searchedUsersList.value =
                withContext(Dispatchers.Default) {
                    searchUsersUseCase.exec(username)
                }
        }
    }
    fun checkUser(
        users: List<User>,
        login: String,
        password: String, context: Context,
    ) {
      //  Toast.makeText(context, "1", Toast.LENGTH_SHORT).show()
        //Log.d(TAG, "onViewCreated3: $users")
        if (users.isEmpty()) {
            createUser(login, password)
         //   Log.d(TAG, "onViewCreated5: $users")
            Toast.makeText(context, context.getString(R.string.create_user), Toast.LENGTH_SHORT).show()
            _stest.value=true
            //_currentuser.value= users.

            
        } else {
        //    Log.d(TAG, "onViewCreated6: $users")
            if (users[0].username == login && users[0].password == password) {
          //      Log.d(TAG, "onViewCreated: Авторизация прошла успешно")
               Toast.makeText(context, context.getString(R.string.user_check), Toast.LENGTH_SHORT).show()
                _stest.value=true
                _currentuser.value=users[0]


            } else {
                Toast.makeText(context, context.getString(R.string.password_error), Toast.LENGTH_SHORT).show()
            //   Log.d(TAG, "onViewCreated: Неверный пароль")
                _currentuser.value= _searchedUsersList.value?.get(0)
                _stest.value=false
            }

        }

    }
}

