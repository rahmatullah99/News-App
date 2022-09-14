package com.sensenews.app.domain.di

import com.sensenews.app.data.network.ApiService
import com.sensenews.app.data.repository.GetNewsArticleRepoImpl
import com.sensenews.app.domain.repository.GetNewsArticleRepo
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DomainModule {

    @Provides
     fun getNewsRepo(apiService: ApiService):GetNewsArticleRepo{
        return GetNewsArticleRepoImpl(apiService = apiService)
    }

}