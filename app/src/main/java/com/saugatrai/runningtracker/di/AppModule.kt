package com.saugatrai.runningtracker.di

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import androidx.room.Room
import com.saugatrai.runningtracker.db.RunDAO
import com.saugatrai.runningtracker.db.RunningDatabase
import com.saugatrai.runningtracker.other.Constants
import com.saugatrai.runningtracker.other.Constants.KEY_FIRST_TIME_TOGGLE
import com.saugatrai.runningtracker.other.Constants.KEY_NAME
import com.saugatrai.runningtracker.other.Constants.KEY_WEIGHT
import com.saugatrai.runningtracker.other.Constants.SHARED_PREFERENCES_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRoomDb(@ApplicationContext context: Context): RunningDatabase =
        Room.databaseBuilder(
            context,
            RunningDatabase::class.java,
            Constants.RUNNING_DATABASE_NAME
        ).build()

    @Provides
    @Singleton
    fun provideRunningDAO(db: RunningDatabase): RunDAO = db.getRunDao()

    @Provides
    @Singleton
    fun provideSharedPreferences(@ApplicationContext app: Context): SharedPreferences =
        app.getSharedPreferences(SHARED_PREFERENCES_NAME, MODE_PRIVATE)

    @Provides
    @Singleton
    fun provideName(sharedPref: SharedPreferences) = sharedPref.getString(KEY_NAME, "") ?: ""

    @Provides
    @Singleton
    fun provideWeight(sharedPref: SharedPreferences) = sharedPref.getFloat(KEY_WEIGHT, 80f)

    @Singleton
    @Provides
    fun provideFirstTimeToggle(sharedPref: SharedPreferences) =
        sharedPref.getBoolean(KEY_FIRST_TIME_TOGGLE, true)

}