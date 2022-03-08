package com.ambrella.message.presentation.login


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
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
        mBinding.editPersonName.setText(loginViewModel.getUserNameUseCase.exec(requireContext()))
        mBinding.btForgoPassword.isVisible=false
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


           if (mBinding.checkBox2.isChecked)
           {
             loginViewModel.setUserNameUseCase.exec(mBinding.editPersonName.text.toString(),requireContext())
           }


            }
            mBinding.btForgoPassword.isVisible=true

        }

        mBinding.btForgoPassword.setOnClickListener {
            Log.d("TAG", "onViewCreated: ${loginViewModel.getIdUserUseCase.exec(requireContext())}")
            ResetPass().apply {
                arguments = bundleOf(
                    "Callback" to ResetPassHelperCallback(mBinding.editPersonName.text.toString()) {
                        loginViewModel.createUser(loginViewModel.getIdUserUseCase.exec(requireContext()),mBinding.editPersonName.text.toString(), it)
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