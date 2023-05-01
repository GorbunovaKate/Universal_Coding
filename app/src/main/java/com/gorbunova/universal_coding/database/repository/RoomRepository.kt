package com.gorbunova.universal_coding.database.repository

import androidx.lifecycle.LiveData
import com.gorbunova.universal_coding.database.DatabaseRepository
import com.gorbunova.universal_coding.database.dao.LessonRoomDao
import com.gorbunova.universal_coding.model.Lesson

class RoomRepository(private val lessonRoomDao: LessonRoomDao) : DatabaseRepository {
    override val readAll: LiveData<List<Lesson>>
        get() = lessonRoomDao.getAllNotes()
}