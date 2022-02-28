package com.ambrella.message.presentation.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import androidx.viewbinding.ViewBinding
import com.ambrella.message.R
import com.ambrella.message.presentation.MainActivity
import com.ambrella.message.presentation.navButton


abstract class BaseFragment<T : ViewBinding> : Fragment() {
    lateinit var  navController:NavController

    private var _binding:T?=null
    val mBinding:T
        get() = _binding?: throw NullPointerException("Erorr Binding!!!")
    abstract fun getBinding(inflater: LayoutInflater,container: ViewGroup?): T

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = getBinding(inflater, container)
        return _binding!!.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
         navController = Navigation.findNavController(requireView())

        navButton.setupWithNavController(navController)

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }

       public fun navigate( nav:Int ){

               navController.navigate(nav)
        }
    fun inVisible(invis:Boolean)
      {
          navButton.isVisible=invis
       }



    }

