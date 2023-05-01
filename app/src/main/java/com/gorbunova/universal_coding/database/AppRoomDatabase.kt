package com.gorbunova.universal_coding.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.gorbunova.universal_coding.database.dao.LessonRoomDao
import com.gorbunova.universal_coding.model.Lesson
import com.gorbunova.universal_coding.utils.Constants.Keys.LESSONS_DATABASE

@Database(entities = [Lesson::class], version = 1)
abstract class AppRoomDatabase : RoomDatabase(){
    abstract fun  getRoomDao(): LessonRoomDao

    companion object {

        @Volatile
        private var INSTANCE: AppRoomDatabase? = null

        fun getInstance(context: Context) : AppRoomDatabase {
            return if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context,
                    AppRoomDatabase::class.java,
                    LESSONS_DATABASE
                ).createFromAsset(LESSONS_DATABASE)
                    .build()
                INSTANCE as AppRoomDatabase
            } else INSTANCE as AppRoomDatabase
        }
    }
}