package com.ambrella.message.presentation

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.ambrella.message.R
import dagger.hilt.android.AndroidEntryPoint
lateinit var mSettings: SharedPreferences

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @SuppressLint("CommitPrefEdits")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE)


    }




    companion object {
        const val APP_PREFERENCES="mysettings"

        fun putSettings(userNameLogin:String){
            val e: SharedPreferences.Editor = mSettings.edit()
            e.putString("userName", userNameLogin)
            e.apply()
        }
        fun getSettings(): String
        {
           return mSettings.getString(APP_PREFERENCES,"")?:""
        }
    }
}
