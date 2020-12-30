package com.rolandoasmat.count

import com.rolandoasmat.count.db.CountDatabase
import com.rolandoasmat.count.db.entities.Count
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CountsRepository @Inject constructor(
        private val db: CountDatabase,
        private val coroutineContextProvider: CoroutineContextProvider) {

    private val scope = CoroutineScope(coroutineContextProvider.io)
    val count: Flow<Int> = db.countEntityDao().get().map { it?.count ?: 0 }

    init {
        scope.launch {
            db.countEntityDao().insert(Count(DEFAULT_COUNT_ID, 0))
        }
    }

    fun updateCount(newCount: Int) {
        scope.launch {
            db.countEntityDao().update(Count(DEFAULT_COUNT_ID, newCount))
        }
    }

    companion object {
        const val DEFAULT_COUNT_ID = 1L
    }

}