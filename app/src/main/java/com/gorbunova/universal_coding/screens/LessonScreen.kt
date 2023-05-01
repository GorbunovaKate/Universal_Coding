package com.gorbunova.universal_coding.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.gorbunova.universal_coding.MainViewModel
import com.gorbunova.universal_coding.model.Lesson
import com.gorbunova.universal_coding.utils.Constants
import android.view.View
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.viewinterop.AndroidView
import com.gorbunova.universal_coding.R
import ru.noties.jlatexmath.JLatexMathView

@Composable
fun XML_in(text: String) {
    val regex = Regex("\\$+.*?\\$+")
    val matches = regex.findAll(text).toList()
    val parts = regex.split(text)
    Column(modifier = Modifier.fillMaxWidth()) {
        parts.forEachIndexed { index, part ->
            if (part.isNotEmpty()) {
                androidx.compose.material3.Text(text = part)
            }
            if (index < matches.size) {
                AndroidView(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    factory = { View.inflate(it, R.layout.text_layout, null) },
                    update = {
                        val mathView = it.findViewById<JLatexMathView>(R.id.math_view)
                        mathView.setLatex(matches[index].value.replace("\\$".toRegex(), ""))
                    }
                )
            }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun LessonScreen(navController: NavHostController, viewModel: MainViewModel, noteId: String?) {

    val lessons = viewModel.readAllLessons().observeAsState(listOf()).value
    val lesson = lessons.firstOrNull { it.id == noteId?.toInt() } ?: Lesson(
        title = Constants.Keys.NONE,
        subtitle = Constants.Keys.NONE,
        text = Constants.Keys.NONE
    )

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) {

            Column(
                modifier = Modifier
                    .padding(vertical = 14.dp)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                Text(
                    text = lesson.title,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 32.dp)
                )
                Text(
                    text = lesson.subtitle,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Light,
                    modifier = Modifier.padding(top = 16.dp)
                )

                XML_in(lesson.text)
            }
    }
}