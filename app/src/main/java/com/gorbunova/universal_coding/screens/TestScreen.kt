package com.gorbunova.universal_coding.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.gorbunova.universal_coding.components.TopLevelScaffold

@Composable
fun TestScreen(navController: NavHostController){

    TopLevelScaffold(
        navController = navController
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            Text(text = "Test Screen",
                modifier = Modifier.padding(start = 8.dp))
        }
    }
}