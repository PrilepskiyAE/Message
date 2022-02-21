package com.ambrella.message.domain.repository

import com.ambrella.message.domain.entity.Message
import com.ambrella.message.domain.entity.User

interface MessageRepository {
    fun createMessage(message: Message)
    fun deleteMessage(message: Message)
    fun getMessage(user: User,user2: User):List<Message>
    fun updateMessage(message: Message)
}