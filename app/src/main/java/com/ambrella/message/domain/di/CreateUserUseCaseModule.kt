package com.ambrella.message.domain.di

import com.ambrella.message.domain.usecase.user.createuser.CreateUserUseCase
import com.ambrella.message.domain.usecase.user.createuser.CreateUserUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import javax.inject.Inject

@Module
@InstallIn(ViewModelComponent::class)
class CreateUserUseCaseModule {
    @Provides
    fun provideCreateUserUseCase(usecase:CreateUserUseCaseImpl): CreateUserUseCase = usecase

}