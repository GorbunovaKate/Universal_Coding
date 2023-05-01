package com.gorbunova.universal_coding.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.gorbunova.universal_coding.model.Lesson

@Dao
interface LessonRoomDao {
    @Query("SELECT * FROM LESSONS_TABLE")// ПОЛУЧЕНИЕ ВСЕХ ЗАПИСЕЙ
    fun getAllNotes(): LiveData<List<Lesson>>

    @Insert
    fun addNote(note: Lesson)
}
