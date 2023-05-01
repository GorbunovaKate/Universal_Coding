package com.gorbunova.universal_coding.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.gorbunova.universal_coding.MainViewModel
import androidx.compose.runtime.livedata.observeAsState
import com.gorbunova.universal_coding.components.BottomNavBar
import com.gorbunova.universal_coding.components.LessonItem

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun TheoryScreen(navController: NavHostController, viewModel: MainViewModel){

    val lessons = viewModel.readAllLessons().observeAsState(listOf()).value

    Scaffold(
        bottomBar = {
            BottomNavBar(navController)
        }
    ) {
        LazyColumn {
            items(lessons){ lesson->
                LessonItem(lesson = lesson , navController = navController)
            }
        }
    }
}

//    TopLevelScaffold(
//        navController = navController
//    ) { innerPadding ->
//        Surface(
//            modifier = androidx.compose.ui.Modifier
//                .padding(innerPadding)
//                .fillMaxSize()
//        ) {
//            Text(text = "Theory Screen",
//                modifier = Modifier.padding(start = 8.dp))
//        }
//    }
//}