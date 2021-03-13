package com.saugatrai.runningtracker.di

import android.content.Context
import androidx.room.Room
import com.saugatrai.runningtracker.db.RunDAO
import com.saugatrai.runningtracker.db.RunningDatabase
import com.saugatrai.runningtracker.other.Constants
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

}