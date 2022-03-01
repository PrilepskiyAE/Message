package com.ambrella.message.presentation.login


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import com.ambrella.message.R
import com.ambrella.message.databinding.FragmentLoginBinding
import com.ambrella.message.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding>() {
    private val loginViewModel: LoginViewModel by viewModels()



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        inVisible(false)

        loginViewModel.searchedUsersList.observe(viewLifecycleOwner) { userlist ->
            context?.let {

                loginViewModel.checkUser(
                    userlist,
                    mBinding.editPersonName.text.toString(),
                    mBinding.editpassword.text.toString(),
                    it
                )


            }
        }

        mBinding.btLogin.setOnClickListener {

            if (!(mBinding.editPersonName.text.toString().trim()
                    .isNotEmpty()) || !(mBinding.editpassword.text.toString().trim().isNotEmpty())
            ) {
                context?.let {
                    Toast.makeText(it, getString(R.string.fill_in_the_fields), Toast.LENGTH_SHORT)
                        .show()
                }


            } else {

                loginViewModel.searchUsers(mBinding.editPersonName.text.toString())
                loginViewModel.stest.observe(viewLifecycleOwner){
                   // TODO navigate проскакивает подписка(checkuser не успивает сработать) , сделал через состояние\\временно потом разбирусь че за фигня
                    if (it){
                       navigate(R.id.action_loginFragment_to_registrationFragment)
                   }

                }


//            if (mBinding.checkBox2.isChecked)
//            {
//                //TODO Продумать логики Запомни пароль
//                MainActivity.putSettings(mBinding.editPersonName.text.toString())
//            }


            }

        }

        mBinding.btForgoPassword.setOnClickListener {

            ResetPass().apply {
                arguments = bundleOf(
                    "Callback" to ResetPassHelperCallback(mBinding.editPersonName.text.toString()) {
                        loginViewModel.updateUser(loginViewModel.currenuser.value!!.id,mBinding.editPersonName.text.toString(), it)
                    }
                )
            }.show(requireActivity().supportFragmentManager, "ResetPass")
        }

    }

    override fun getBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentLoginBinding {
        return FragmentLoginBinding.inflate(layoutInflater, container, false)
    }

    companion object {
        const val TAG = "LoginFragment"
    }


}