package com.example.doranotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.doranotes.navigation.NavRoutes
import com.example.doranotes.screens.AddNoteScreen
import com.example.doranotes.screens.MainScreen
import com.example.doranotes.ui.theme.DoraNotesTheme
import com.example.doranotes.viewModel.NoteViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DoraNotesTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = Color(0xffDCCFEC)) {

                    val noteViewModel = viewModel<NoteViewModel>()
                    SMainScreen(viewModel = noteViewModel)
                }
            }
        }
    }
}

@Composable
fun SMainScreen(viewModel: NoteViewModel){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NavRoutes.Home.route){
        composable("home"){
            MainScreen(viewModel = viewModel, navController = navController)
        }
        composable("addNote"){
            AddNoteScreen(viewModel = viewModel)
        }
    }
}