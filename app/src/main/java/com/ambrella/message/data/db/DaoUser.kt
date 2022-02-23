package com.ambrella.message.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.ambrella.message.data.entity.UserDB

@Dao
interface DaoUser {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(userDB: UserDB)

    @Delete
    suspend fun deleteUser(userDB: UserDB)

    @Update
    suspend fun updateUser(userDB: UserDB)

    @Query("SELECT * FROM tuser")
    suspend fun getUserList(): List<UserDB>

    @Query("SELECT * FROM tuser WHERE id IN (:itemIds)")
    suspend fun getUser(itemIds: Int): UserDB

    @Query("SELECT * FROM tuser WHERE username IN(:userName)")//TODO Подумаю LIMIT = 1 или поиск в выборке
    suspend fun searchUser(userName:String):List<UserDB>
}