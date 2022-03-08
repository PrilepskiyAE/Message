package com.ambrella.message.domain.di

import com.ambrella.message.domain.usecase.user.getusername.GetUserNameUseCase
import com.ambrella.message.domain.usecase.user.getusername.GetUserNameUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class GetUserNameUseCaseModule {
    @Provides
    fun provideGetUserNameUseCase(usecase:GetUserNameUseCaseImpl):GetUserNameUseCase = usecase
}
