package com.ambrella.message.domain.repository

import com.ambrella.message.Message
import com.ambrella.message.domain.entity.Messages
import com.ambrella.message.domain.entity.User

interface MessageRepository {
    fun createMessage(message: Messages)
    fun deleteMessage(message: Messages)
    fun getMessage(user: User,user2: User):List<Messages>
    fun updateMessage(message: Messages)
}