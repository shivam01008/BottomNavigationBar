package com.example.network.di

import com.example.network.Auth.Auth
import com.example.network.Auth.AuthImpl
import com.example.network.Auth.AuthService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ImplModule {
    @Singleton
    @Provides
    fun provideAuth(authService: AuthService): Auth {
        return AuthImpl(authService)
    }

}