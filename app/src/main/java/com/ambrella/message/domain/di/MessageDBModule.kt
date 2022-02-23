package com.ambrella.message.domain.di

import android.content.Context
import androidx.room.Room
import com.ambrella.message.data.db.RoomDatabaseMessage
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ViewModelComponent::class)
class MessageDBModule {
    @Provides
    fun provideDB(@ApplicationContext context: Context):RoomDatabaseMessage = Room.databaseBuilder(context,RoomDatabaseMessage::class.java,"MessageDB").build()
}