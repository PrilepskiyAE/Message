package com.ambrella.message.domain.di

import com.ambrella.message.domain.usecase.user.setiduser.SetIdUserUseCase
import com.ambrella.message.domain.usecase.user.setiduser.SetIdUserUseCaseImpl
import com.ambrella.message.domain.usecase.user.updateuser.UpdateUserUseCase
import com.ambrella.message.domain.usecase.user.updateuser.UpdateUserUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
@Module
@InstallIn(ViewModelComponent::class)
class SetIdUserUseCaseModule {
    @Provides
    fun provideSetIdUserUseCase(usecase: SetIdUserUseCaseImpl): SetIdUserUseCase = usecase
}




