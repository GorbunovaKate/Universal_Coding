package com.gorbunova.universal_coding.utils

import com.gorbunova.universal_coding.database.DatabaseRepository


lateinit var REPOSITORY: DatabaseRepository


object  Constants {
    const val THEORY = "Theory"
    const val TEST = "Test"

    object Keys {
        const val LESSONS_DATABASE = "lessons_database.db"
        const val LESSONS_TABLE = "lessons_table"
        const val ID = "Id"
        const val NONE = "none"
    }

    object Screens {
        const val THEORY_SCREEN = "theory_screen"
        const val TEST_SCREEN = "test_screen"
        const val LESSON_SCREEN = "lesson_screen"
    }
}