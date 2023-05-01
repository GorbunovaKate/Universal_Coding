package com.gorbunova.universal_coding.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopLevelScaffold(
    navController: NavHostController,
    pageContent: @Composable (innerPadding: PaddingValues) -> Unit = {}
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {androidx.compose.material.Text(text = "Универсальное кодирование")}
            )
        },
        bottomBar = {
            BottomNavBar(navController)
        },
        content = { innerPadding ->
            pageContent(innerPadding)
        }
    )
}