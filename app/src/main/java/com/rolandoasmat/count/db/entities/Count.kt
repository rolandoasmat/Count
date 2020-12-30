package com.rolandoasmat.count.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Count(
    @PrimaryKey
    val id: Long,
    val count: Int)