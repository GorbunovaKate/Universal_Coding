package com.gorbunova.universal_coding.database

import androidx.lifecycle.LiveData
import com.gorbunova.universal_coding.model.Lesson

interface DatabaseRepository {

    val readAll: LiveData<List<Lesson>>
}