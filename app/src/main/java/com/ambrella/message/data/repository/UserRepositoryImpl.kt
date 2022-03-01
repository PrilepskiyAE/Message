package com.ambrella.message.data.repository

import android.content.Context
import android.content.SharedPreferences
import com.ambrella.message.data.db.DaoUser
import com.ambrella.message.data.db.MapperUser
import com.ambrella.message.data.db.RoomDatabaseMessage
import com.ambrella.message.data.entity.Sharedpref
import com.ambrella.message.domain.entity.User
import com.ambrella.message.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(db:RoomDatabaseMessage):UserRepository {
    private val mapper=MapperUser()

    private val daoUser: DaoUser=db.daoUser()

    override suspend fun createUser(user: User) {
        daoUser.insertUser(mapper.mapEntityToDbModel(user))
    }

    override suspend fun deleteUser(user: User) {
        daoUser.deleteUser(mapper.mapEntityToDbModel(user))
    }

    override suspend fun getListUser(): List<User> = mapper.mapListDbModelToListEntity(daoUser.getUserList())

    override suspend fun getUser(id:Int): User {
        val el=daoUser.getUser(id)
        return mapper.mapDbModelToEntity(el)
    }

    override suspend fun updateUser(user: User) {
        daoUser.updateUser(mapper.mapEntityToDbModel(user))
    }

    override suspend fun searchUsers(username: String)= mapper.mapListDbModelToListEntity(daoUser.searchUser(username))

    override fun getId(context: Context):Int {
       return Sharedpref.getId(context)
    }

    override fun putId(context: Context, id:Int){
        Sharedpref.setId(context,id)
    }

    override fun getUserName(context: Context):String {
        return Sharedpref.getName(context)?:""
    }

    override fun putUserName(context: Context, username: String){
        Sharedpref.setName(context,username)
    }
}