package com.ambrella.message.presentation.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.ambrella.message.R
import com.ambrella.message.data.repository.UserRepositoryImp
import com.ambrella.message.databinding.FragmentLoginBinding
import com.ambrella.message.domain.repository.UserRepository


class LoginFragment : Fragment() {
   // val loginViewModel: LoginViewModel by viewModels()

       //LoginViewModel(repository = UserRepositoryImp(requireContext()))
       private var _binding: FragmentLoginBinding? = null
       private val mBinding get() = _binding ?: throw RuntimeException("Main fragment error")
       private lateinit var loginViewModel: LoginViewModel
       private lateinit var viewModelFactory: ViewModelProvider.Factory


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding=FragmentLoginBinding.inflate(layoutInflater,container,false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModelFactory=LoginViewModelFactory(UserRepositoryImp(requireContext()))
        loginViewModel=ViewModelProvider(this,viewModelFactory)[LoginViewModel::class.java]
          loginViewModel.loginByUser("test","passtest")

    }
}