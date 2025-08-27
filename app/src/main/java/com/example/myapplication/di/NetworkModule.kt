package com.example.myapplication.di

import android.app.Application
import com.example.myapplication.util.networking.connectivity.ConnectivityManager
import com.example.myapplication.util.networking.connectivity.ConnectivityManagerImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

	@Singleton
	@Provides
	fun provideConnectivityManager(application: Application): ConnectivityManager {
		return ConnectivityManagerImpl(application)
	}

	@EntryPoint
	@InstallIn(SingletonComponent::class)
	interface ConnectivityManagerProviderEntryPoint {
		fun connectivityManager(): ConnectivityManager
	}

}
