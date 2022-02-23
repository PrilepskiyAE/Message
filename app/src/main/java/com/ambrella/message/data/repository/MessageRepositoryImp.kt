package com.ambrella.message.data.repository

import com.ambrella.message.Message
import com.ambrella.message.domain.entity.Messages
import com.ambrella.message.domain.entity.User
import com.ambrella.message.domain.repository.MessageRepository

class MessageRepositoryImp : MessageRepository {
    override fun createMessage(message: Messages) {
        TODO("Not yet implemented")
    }

    override fun deleteMessage(message: Messages) {
        TODO("Not yet implemented")
    }
//User 1 и User 2 это выборка
    override fun getMessage(user: User, user2: User): List<Messages> {
        TODO("Not yet implemented")
    }

    override fun updateMessage(message: Messages) {
        TODO("Not yet implemented")
    }
}