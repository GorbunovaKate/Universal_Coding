package com.gorbunova.universal_coding

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gorbunova.universal_coding.database.AppRoomDatabase
import com.gorbunova.universal_coding.database.repository.RoomRepository
import com.gorbunova.universal_coding.utils.REPOSITORY
import java.lang.IllegalArgumentException

class MainViewModel (application: Application) : AndroidViewModel(application) {

    val context = application

    fun initDatabase() {
        val dao = AppRoomDatabase.getInstance(context = context).getRoomDao()
        REPOSITORY = RoomRepository(dao)
    }

    fun readAllLessons() = REPOSITORY.readAll
}

class MainViewModelFactory(private val application: Application): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(application = application) as T
        }
        throw  IllegalArgumentException("Unknown ViewModel Class")
    }
}