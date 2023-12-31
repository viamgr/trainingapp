package com.training.app.data.authorization.signup.di

import com.training.app.data.authorization.signup.dataprovider.SignUpDataProvider
import com.training.app.data.authorization.signup.dataprovider.SignUpDataProviderImpl
import com.training.app.data.authorization.signup.repo.SignUpRepositoryImpl
import com.trainning.app.domain.repository.SignUpRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal class SignUpDIModule {

    @Provides
    fun provideDataProvider(): SignUpDataProvider {
        return SignUpDataProviderImpl()
    }

    @Provides
    fun provideRepository(dataProvider: SignUpDataProvider): SignUpRepository {
        return SignUpRepositoryImpl(dataProvider)
    }

}