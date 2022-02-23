package com.ambrella.message.presentation.login


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.ambrella.message.data.repository.UserRepositoryImpl
import com.ambrella.message.databinding.FragmentLoginBinding
import com.ambrella.message.presentation.MainActivity
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class LoginFragment : Fragment() {
    private val loginViewModel: LoginViewModel by viewModels()


       private var _binding: FragmentLoginBinding? = null
       private val mBinding get() = _binding ?: throw RuntimeException("Main fragment error")



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

    val mcontext=context.let{
         requireContext()
        }
        loginViewModel.searchedUsersList.observe(viewLifecycleOwner) {
            loginViewModel.checkUser(it, mBinding.editPersonName.text.toString(), mBinding.editpassword.text.toString(),mcontext)
        }

        mBinding.button.setOnClickListener {
            loginViewModel.searchUsers(mBinding.editPersonName.text.toString())
            if (mBinding.checkBox2.isChecked)
            {
                //TODO Продумать логики Запомни пароль
                MainActivity.putSettings(mBinding.editPersonName.text.toString())
            }
        }

        mBinding.btForgoPassword.setOnClickListener {
            ResetPass().show(requireActivity().supportFragmentManager,"ResetPass")
        }

    }
companion object{
    const val TAG="LoginFragment"
}

}