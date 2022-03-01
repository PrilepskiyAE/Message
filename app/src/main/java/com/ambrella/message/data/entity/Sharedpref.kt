package com.ambrella.message.data.entity

import android.content.Context
import android.content.SharedPreferences

object Sharedpref {
    private var preferences: SharedPreferences? = null



//    var name: String?
//        get() = preferences.getString("Key_UserName","")
//        set(value) = preferences.edit().putString("Key_id", value).apply()

    private fun getIdInitialized(context: Context) =
        preferences ?: synchronized(this) {
            preferences = context.getSharedPreferences("sh_id", Context.MODE_PRIVATE)

            preferences!!
        }

    fun getId(context: Context) =
        getIdInitialized(context).getInt("Key_id", -1)


    fun setId(context: Context,id:Int){
        getIdInitialized(context).edit().putInt("Key_id", id).apply()
    }

    //=================================



    fun getName(context: Context) =
        getIdInitialized(context).getString("Key_UserName", "")


    fun setName(context: Context,username:String){
        getIdInitialized(context).edit().putString("Key_UserName", username).apply()
    }

}