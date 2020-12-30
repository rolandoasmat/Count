package com.rolandoasmat.count.di.modules

import android.content.Context
import androidx.room.Room
import com.rolandoasmat.count.db.CountDatabase
import dagger.Module
import dagger.Provides

@Module
class DatabaseModule {

    @Provides
    fun provideDatabase(context: Context): CountDatabase {
        return Room.databaseBuilder(context,
            CountDatabase::class.java, DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    companion object {
        private const val DATABASE_NAME = "counts-database"
    }
}