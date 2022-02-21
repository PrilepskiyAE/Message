package com.ambrella.message.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.ambrella.message.data.entity.UserDB

@Dao
interface DaoUser {

    @Insert
    suspend fun insertUser(userDB: UserDB)

    @Delete
    suspend fun deleteUser(userDB: UserDB)

    @Update
    suspend fun updateUser(userDB: UserDB)

    @Query("SELECT * FROM tuser")
    fun getUserList():LiveData<List<UserDB>>

    @Query("SELECT * FROM tuser WHERE id IN (:itemIds)")
    fun getUser(itemIds: Int):UserDB
}