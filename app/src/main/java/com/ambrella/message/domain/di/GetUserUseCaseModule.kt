package com.ambrella.message.domain.di


import com.ambrella.message.domain.usecase.user.getuser.GetUserUseCase
import com.ambrella.message.domain.usecase.user.getuser.GetUserUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class GetUserUseCaseModule {
    @Provides
    fun provideGetUserUseCase(usecase: GetUserUseCaseImpl): GetUserUseCase = usecase
}


