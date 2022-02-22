package com.ambrella.message.presentation.login


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.ambrella.message.R
import com.ambrella.message.data.repository.UserRepositoryImp
import com.ambrella.message.databinding.FragmentLoginBinding
import com.ambrella.message.domain.entity.User
import com.ambrella.message.domain.repository.UserRepository

const val TAG="LoginFragment"
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
//          loginViewModel.loginByUser("test1","passtest")
//
//        loginViewModel.userList.observe(viewLifecycleOwner){
//            for (user in it)
//            {
//
//            }
//        }
//        loginViewModel.searchUsersUseCase.exec("test1").observe(viewLifecycleOwner){
//           for (user in it)
//           {
//               Log.d("TAG", "onViewCreated: $user")
//            }
//        }
//        loginViewModel.searchUsersUseCase.exec(login).observe(viewLifecycleOwner)
//        {
//            checkUser(it, login, password)
//        }
        loginViewModel.searchedUsersList.observe(viewLifecycleOwner) {
            checkUser(it, mBinding.editPersonName.text.toString(), mBinding.editpassword.text.toString())
        }

        mBinding.button.setOnClickListener {
            loginViewModel.searchUsers(mBinding.editPersonName.text.toString())
        }
    }

    private fun checkUser(
        users: List<User>,
        login: String,
        password: String
    ) {
        Log.d(TAG, "onViewCreated3: $users")
        if (users.isEmpty()) {
            loginViewModel.createUser(login, password)
            Log.d(TAG, "onViewCreated5: $users")
            Toast.makeText(
                requireContext(),
                getString(R.string.create_user),
                Toast.LENGTH_SHORT
            ).show()
        } else {
            Log.d(TAG, "onViewCreated6: $users")
            if (users[0].username == login && users[0].password == password) {
                Log.d(TAG, "onViewCreated: Авторизация прошла успешно")
                Toast.makeText(
                    requireContext(),
                    getString(R.string.user_check),
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(requireContext(), getString(R.string.password_error), Toast.LENGTH_SHORT).show()
                Log.d(TAG, "onViewCreated: Неверный пароль")
            }

        }

    }
}