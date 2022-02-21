package com.ambrella.message.data.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.ambrella.message.data.db.DaoUser
import com.ambrella.message.data.db.MapperUser
import com.ambrella.message.data.db.RoomDatabaseMessage
import com.ambrella.message.domain.entity.User
import com.ambrella.message.domain.repository.UserRepository

class UserRepositoryImp(context:Context):UserRepository {
    private val mapper=MapperUser()

    private val daoUser: DaoUser
    init {
        val database = RoomDatabaseMessage.getInstance(context)
        daoUser = database.daoUser()
    }

    override suspend fun createUser(user: User) {
        daoUser.insertUser(mapper.mapEntityToDbModel(user))
    }

    override suspend fun deleteUser(user: User) {
        daoUser.deleteUser(mapper.mapEntityToDbModel(user))
    }

    override  fun getListUser(): LiveData<List<User>> = Transformations.map(daoUser.getUserList()){
        mapper.mapListDbModelToListEntity(it)
    }

    override fun getUser(id:Int): User {
        val el=daoUser.getUser(id)
        return mapper.mapDbModelToEntity(el)
    }

    override suspend fun updateUser(user: User) {
        daoUser.updateUser(mapper.mapEntityToDbModel(user))
    }
}