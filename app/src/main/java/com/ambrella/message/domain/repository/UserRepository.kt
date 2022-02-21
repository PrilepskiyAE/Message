package com.ambrella.message.domain.repository

import androidx.lifecycle.LiveData
import com.ambrella.message.domain.entity.User


interface UserRepository {
    suspend fun createUser(user: User)
    suspend  fun deleteUser(user: User)
     fun getListUser():LiveData<List<User>>
     fun getUser(id:Int):User
    suspend fun updateUser(user: User)
    fun searchUsers(username: String):LiveData<List<User>>
}