package com.rolandoasmat.count.db.entities

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface CountDao {

    @Query("SELECT * FROM Count limit 1")
    fun get(): Flow<Count?>

    @Update
    fun update(data: Count)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(data: Count)

}