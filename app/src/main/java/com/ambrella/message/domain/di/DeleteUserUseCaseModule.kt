package com.ambrella.message.domain.di

import com.ambrella.message.domain.usecase.user.deleteuser.DeleteUserUseCase
import com.ambrella.message.domain.usecase.user.deleteuser.DeleteUserUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
@Module
@InstallIn(ViewModelComponent::class)
class DeleteUserUseCaseModule {
    @Provides
    fun provideDeleteUserUseCase(usecase: DeleteUserUseCaseImpl): DeleteUserUseCase = usecase
}


