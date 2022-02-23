package com.ambrella.message.domain.di

import com.ambrella.message.data.db.RoomDatabaseMessage
import com.ambrella.message.data.repository.MessageRepositoryImp
import com.ambrella.message.data.repository.UserRepositoryImpl
import com.ambrella.message.domain.repository.MessageRepository
import com.ambrella.message.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class UserRepositoryModule {
    @Provides
    fun provideRepositoryModule(db: RoomDatabaseMessage): UserRepository = UserRepositoryImpl(db)
}