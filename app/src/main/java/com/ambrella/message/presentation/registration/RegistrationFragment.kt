package com.ambrella.message.presentation.registration

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.ambrella.message.R
import com.ambrella.message.databinding.FragmentLoginBinding
import com.ambrella.message.databinding.FragmentRegistrationBinding
import com.ambrella.message.presentation.MainActivity
import com.ambrella.message.presentation.base.BaseFragment
import com.ambrella.message.presentation.user.adapter.loadImage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegistrationFragment : BaseFragment<FragmentRegistrationBinding>() {
    lateinit var activityResultLauncher: ActivityResultLauncher<Intent>
    private  var url:String="empty"
    override fun getBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentRegistrationBinding {
        return FragmentRegistrationBinding.inflate(layoutInflater,container,false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            it.data?.apply {
                loadImage(mBinding.imgAvatarReg
                    ,data.toString())
                url=data.toString()
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        inVisible(true)
       // var setRes=1
        mBinding.btUpdate.setOnClickListener {

        }

        mBinding.imgBtSet.setOnClickListener {
        //    setRes=0
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "image/*"
            activityResultLauncher.launch(intent)
        }
    }


}
