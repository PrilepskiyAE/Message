package com.ambrella.message.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ambrella.message.data.db.RoomDatabaseMessage.Companion.VERSION_SCHEMA
import com.ambrella.message.data.entity.UserDB
import java.lang.RuntimeException

@Database(entities = arrayOf(UserDB::class), version = VERSION_SCHEMA, exportSchema = false)

abstract class RoomDatabaseMessage: RoomDatabase() {
    abstract fun daoUser():DaoUser
    companion object{
        const val VERSION_SCHEMA=1
        private var INSTANCE:RoomDatabaseMessage?=null
        fun getInstance(context: Context):RoomDatabaseMessage
        {
            if (INSTANCE==null){
                synchronized(RoomDatabaseMessage::class){
                    INSTANCE= Room.databaseBuilder(context,RoomDatabaseMessage::class.java,"MessageDB").build()
                }
            }
            return INSTANCE ?: throw RuntimeException("error : DB init")
        }
    }


}