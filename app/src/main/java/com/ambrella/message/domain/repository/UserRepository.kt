package com.ambrella.message.domain.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.ambrella.message.domain.entity.Messages
import com.ambrella.message.domain.entity.User


interface UserRepository {
    suspend fun createUser(user: User)
    suspend  fun deleteUser(user: User)
    suspend fun getListUser():List<User>
    suspend fun getUser(id:Int):User
    suspend fun updateUser(user: User)
    suspend fun searchUsers(username: String):List<User>

    suspend fun createMessage(message: Messages)
    suspend fun deleteMessage(message: Messages)
    suspend fun getMessage(user: User,user2: User):List<Messages>
    suspend fun updateMessage(message: Messages)

    fun getId(context: Context):Int
    fun putId(context: Context,id:Int)
    fun getUserName(context: Context):String
    fun putUserName(context: Context,username: String)

}