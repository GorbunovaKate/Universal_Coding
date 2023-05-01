package com.gorbunova.universal_coding.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gorbunova.universal_coding.MainViewModel
import com.gorbunova.universal_coding.screens.LessonScreen
import com.gorbunova.universal_coding.screens.TestScreen
import com.gorbunova.universal_coding.screens.TheoryScreen
import com.gorbunova.universal_coding.utils.Constants.Screens.LESSON_SCREEN
import com.gorbunova.universal_coding.utils.Constants.Screens.TEST_SCREEN
import com.gorbunova.universal_coding.utils.Constants.Screens.THEORY_SCREEN
import com.gorbunova.universal_coding.utils.Constants.Keys.ID

sealed class NavRoute(val route: String){
    object Theory: NavRoute(THEORY_SCREEN)
    object Test: NavRoute(TEST_SCREEN)
    object Lesson: NavRoute(LESSON_SCREEN)
}

val screens = listOf(
    NavRoute.Theory,
    NavRoute.Test
)

@Composable
fun AppNavHost(mViewModel: MainViewModel){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NavRoute.Theory.route) {
        composable(NavRoute.Theory.route){TheoryScreen(navController, viewModel = mViewModel)}
        composable(NavRoute.Test.route){TestScreen(navController)}
        composable(NavRoute.Lesson.route + "/{${ID}}") { backStackEntry ->
            LessonScreen(navController = navController, viewModel = mViewModel, noteId = backStackEntry.arguments?.getString(ID))
        }
    }
}
