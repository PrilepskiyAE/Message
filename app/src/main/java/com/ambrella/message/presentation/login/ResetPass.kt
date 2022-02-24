package com.ambrella.message.presentation.login

import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import com.ambrella.message.R
import com.ambrella.message.databinding.FragmentLoginBinding
import com.ambrella.message.databinding.ResetPassBinding

class ResetPass:  DialogFragment() {
    private val loginViewModel: LoginViewModel by viewModels()
    private var _binding: ResetPassBinding? = null
    private val mBinding get() = _binding ?: throw RuntimeException("Diolog error")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= ResetPassBinding.inflate(inflater)
        return mBinding.root
    }

    override fun onStart() {
        super.onStart()
        val width = (resources.displayMetrics.widthPixels * 0.85).toInt()
       // val height = (resources.displayMetrics.heightPixels * 0.40).toInt()
        dialog!!.window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding.btUpdate.setOnClickListener {
            Log.d("TAG", "onViewCreated: ")
            if (!(mBinding.editPersonName.text.toString().trim().isNotEmpty()) || !(mBinding.editPersonName.text.toString().trim().isNotEmpty()))
            {
                Toast.makeText(requireContext(), getString(R.string.fill_in_the_fields), Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(requireContext(), "Пароль успешно изменен", Toast.LENGTH_SHORT).show()
                loginViewModel.createUser(mBinding.editPersonName.text.toString(),mBinding.editpassword.text.toString())
                //dismiss() //TODO подумаю как его закрыть
        }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }
}