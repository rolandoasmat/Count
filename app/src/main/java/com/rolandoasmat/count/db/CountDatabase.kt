package com.rolandoasmat.count.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rolandoasmat.count.db.entities.Count
import com.rolandoasmat.count.db.entities.CountDao

@Database(entities = [Count::class], version = 1)
abstract class CountDatabase : RoomDatabase() {
    abstract fun countEntityDao(): CountDao
}