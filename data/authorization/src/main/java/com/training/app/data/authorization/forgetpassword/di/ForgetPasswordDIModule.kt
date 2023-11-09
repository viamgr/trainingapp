package com.training.app.data.authorization.forgetpassword.di

import com.training.app.data.authorization.forgetpassword.dataprovider.ForgetPasswordDataProvider
import com.training.app.data.authorization.forgetpassword.dataprovider.ForgetPasswordDataProviderImpl
import com.training.app.data.authorization.forgetpassword.repo.ForgetPasswordRepositoryImpl
import com.trainning.app.domain.repository.ForgetPasswordRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal class ForgetPasswordDIModule {

    @Provides
    fun provideDataProvider(): ForgetPasswordDataProvider {
        return ForgetPasswordDataProviderImpl()
    }

    @Provides
    fun provideRepository(dataProvider: ForgetPasswordDataProvider): ForgetPasswordRepository {
        return ForgetPasswordRepositoryImpl(dataProvider)
    }

}