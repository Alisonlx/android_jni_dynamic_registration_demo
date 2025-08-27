package com.example.myapplication.di

import android.content.Context
import com.example.myapplication.di.qualifiers.IODispatcher
import com.example.myapplication.preferences.PreferencesManager
import dagger.Module
import dagger.Provides
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PreferencesModule {

	@Singleton
	@Provides
	fun providePreferenceManager(
		@ApplicationContext context: Context,
		@IODispatcher preferenceDispatcher: CoroutineDispatcher
	): PreferencesManager {
		return PreferencesManager(context, preferenceDispatcher)
	}

	@EntryPoint
	@InstallIn(SingletonComponent::class)
	interface PreferenceManagerProviderEntryPoint {
		fun providesPreferenceManager(): PreferencesManager
	}

}
