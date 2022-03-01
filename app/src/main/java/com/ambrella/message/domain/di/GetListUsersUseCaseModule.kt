package com.ambrella.message.domain.di

import com.ambrella.message.domain.usecase.user.deleteuser.DeleteUserUseCase
import com.ambrella.message.domain.usecase.user.deleteuser.DeleteUserUseCaseImpl
import com.ambrella.message.domain.usecase.user.getlistusers.GetListUsersUseCase
import com.ambrella.message.domain.usecase.user.getlistusers.GetListUsersUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class GetListUsersUseCaseModule {
    @Provides
    fun provideGetListUsersUseCase(usecase: GetListUsersUseCaseImpl): GetListUsersUseCase = usecase
}

