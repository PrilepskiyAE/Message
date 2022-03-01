package com.ambrella.message.domain.di

import com.ambrella.message.domain.usecase.user.getuser.GetUserUseCase
import com.ambrella.message.domain.usecase.user.getuser.GetUserUseCaseImpl
import com.ambrella.message.domain.usecase.user.searchuseres.SearchUsersUseCase
import com.ambrella.message.domain.usecase.user.searchuseres.SearchUsersUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
@Module
@InstallIn(ViewModelComponent::class)
class SearchUsersUseCaseModule {
    @Provides
    fun provideSearchUsersUseCase(usecase: SearchUsersUseCaseImpl): SearchUsersUseCase = usecase
}


