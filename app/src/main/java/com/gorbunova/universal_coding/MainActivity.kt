package com.gorbunova.universal_coding

import android.annotation.SuppressLint
import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.TopAppBar
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.gorbunova.universal_coding.ui.theme.Universal_CodingTheme
import com.gorbunova.universal_coding.navigation.AppNavHost

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Universal_CodingTheme {
                val context = LocalContext.current
                val mViewModel: MainViewModel =
                    viewModel(factory = MainViewModelFactory(context.applicationContext as Application))
                mViewModel.initDatabase()


                androidx.compose.material.Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                androidx.compose.material.Text(text = "Универсальное кодирование")
                            }
                        )
                    },
                    content = {
                        androidx.compose.material.Surface(
                            modifier = Modifier.fillMaxSize(),
                            color = androidx.compose.material.MaterialTheme.colors.background
                        ) {
                            AppNavHost(mViewModel)
                        }
                    }
                )
            }
        }
    }
}