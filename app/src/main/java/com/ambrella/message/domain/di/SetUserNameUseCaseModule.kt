package com.ambrella.message.domain.di

import com.ambrella.message.domain.usecase.user.setusername.SetUserNameUseCase
import com.ambrella.message.domain.usecase.user.setusername.SetUserNameUseCaseImpl
import com.ambrella.message.domain.usecase.user.updateuser.UpdateUserUseCase
import com.ambrella.message.domain.usecase.user.updateuser.UpdateUserUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class SetUserNameUseCaseModule {
    @Provides
    fun provideSetUserNameUseCase(usecase: SetUserNameUseCaseImpl): SetUserNameUseCase = usecase
}