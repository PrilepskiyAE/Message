package com.ambrella.message.domain.di

import com.ambrella.message.domain.usecase.user.searchuseres.SearchUsersUseCase
import com.ambrella.message.domain.usecase.user.searchuseres.SearchUsersUseCaseImpl
import com.ambrella.message.domain.usecase.user.updateuser.UpdateUserUseCase
import com.ambrella.message.domain.usecase.user.updateuser.UpdateUserUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
@Module
@InstallIn(ViewModelComponent::class)
class UpdateUserUseCaseModule {
    @Provides
    fun provideUpdateUserUseCase(usecase: UpdateUserUseCaseImpl): UpdateUserUseCase = usecase
}


