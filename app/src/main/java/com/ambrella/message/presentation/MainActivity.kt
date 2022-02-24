package com.ambrella.message.presentation

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.ambrella.message.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
lateinit var mSettings: SharedPreferences
lateinit var navButton: BottomNavigationView
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @SuppressLint("CommitPrefEdits")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE)
        navButton=findViewById(R.id.bottomNavigationView)

    }




    companion object {
        const val APP_PREFERENCES="mysettings"

        fun putSettings(userNameLogin:String){
            val e: SharedPreferences.Editor = mSettings.edit()
            e.putString("userName", userNameLogin)
            e.apply()
        }

        fun navigateSetup(navController:NavController){

            navButton.setupWithNavController(navController)

        }
        fun getSettings(): String
        {
           return mSettings.getString(APP_PREFERENCES,"")?:""
        }
        fun inVisible(invis:Boolean)
        {
            navButton.isVisible=invis
        }
    }
}
