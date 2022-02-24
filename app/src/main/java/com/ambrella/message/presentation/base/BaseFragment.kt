package com.ambrella.message.presentation.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.viewbinding.ViewBinding
import com.ambrella.message.R
import com.ambrella.message.presentation.MainActivity


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

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }

        fun navigate( nav:Int ){
            val navController = Navigation.findNavController(requireView())
            MainActivity.navigateSetup(navController)
            navController.navigate(nav)
        }
    }

