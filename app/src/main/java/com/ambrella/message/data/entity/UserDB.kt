package com.ambrella.message.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tuser")
data class UserDB (
    @PrimaryKey(autoGenerate = true)  var id:Int=0,
    @ColumnInfo var username:String,
    @ColumnInfo val password:String,
    @ColumnInfo val resIdAvatars:String
        )