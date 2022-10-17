package com.bootcamp.kisileruygulamasi.di

import com.bootcamp.kisileruygulamasi.data.datasource.KisilerDataSource
import com.bootcamp.kisileruygulamasi.data.repo.KisilerRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideKisilerRepository(kds: KisilerDataSource): KisilerRepository {
        return KisilerRepository(kds)
    }

    @Provides
    @Singleton
    fun provideKisilerDataSource(): KisilerDataSource{
        return KisilerDataSource()
    }
}