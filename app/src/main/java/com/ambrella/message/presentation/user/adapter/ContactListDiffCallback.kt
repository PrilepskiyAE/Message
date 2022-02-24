package com.ambrella.message.presentation.user.adapter

import androidx.recyclerview.widget.DiffUtil
import com.ambrella.message.domain.entity.User

class ContactListDiffCallback: DiffUtil.ItemCallback<User>() {
    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean = oldItem.id == newItem.id


    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean = oldItem == newItem
}