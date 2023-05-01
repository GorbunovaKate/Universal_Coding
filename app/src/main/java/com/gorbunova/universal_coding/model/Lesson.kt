package com.gorbunova.universal_coding.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.gorbunova.universal_coding.utils.Constants.Keys.LESSONS_TABLE

@Entity(tableName = LESSONS_TABLE)
data class Lesson(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo
    val title: String,
    @ColumnInfo
    val subtitle: String,
    @ColumnInfo
    val text: String
)
