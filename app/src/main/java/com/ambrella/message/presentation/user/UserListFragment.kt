package com.ambrella.message.presentation.user

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.ambrella.message.R
import com.ambrella.message.databinding.FragmentLoginBinding
import com.ambrella.message.databinding.FragmentUserListBinding
import com.ambrella.message.domain.entity.User
import com.ambrella.message.presentation.base.BaseFragment
import com.ambrella.message.presentation.login.LoginViewModel
import com.ambrella.message.presentation.user.adapter.ContactListAdapter
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel

@AndroidEntryPoint
class UserListFragment : BaseFragment<FragmentUserListBinding>() {
    private val userListViewModel: UserListViewModel by viewModels()
    override fun getBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentUserListBinding {
        return FragmentUserListBinding.inflate(layoutInflater,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter= ContactListAdapter()
        mBinding.rcContacr.recycledViewPool.setMaxRecycledViews(R.layout.item_contact,ContactListAdapter.MAX_POOL_SIZE)

        userListViewModel.getUsers()
        mBinding.rcContacr.adapter=adapter
        Log.d("TAG", "onViewCreated: t")
        userListViewModel.usersList.observe(viewLifecycleOwner){
            Log.d("TAG", "onViewCreated: $it")
            adapter.submitList(it)

        }

//        adapter.onUserClickLisener=object : ContactListAdapter.OnUserClickLisener
//        {
//            override fun onUserClick(user: User) {
//
//               // Toast.makeText(requireContext(), "${user.id}", Toast.LENGTH_SHORT).show()
//            }
//
//        }
        adapter.onUserClickLisener={
            Log.d("test", it.toString())
        }
    }
}
