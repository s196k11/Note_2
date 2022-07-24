package com.example.doranotes.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.doranotes.components.NoteBar
import com.example.doranotes.components.SearchBar
import com.example.doranotes.navigation.NavRoutes
import com.example.doranotes.viewModel.NoteViewModel



@Composable
fun MainScreen(viewModel: NoteViewModel, navController :NavController){
    val noteList = viewModel.noteList.collectAsState().value
    Scaffold(
        topBar = { TopAppBar {
            SearchBar()
        }},
        content = {
            Box(modifier = Modifier.fillMaxSize().background(color = Color(0xffDCCFEC))){
                LazyColumn{
                    items(noteList){note ->
                        NoteBar(title = note.title, description = note.description)
                    }
                }

                FloatingActionButton(onClick = { navController.navigate("addNote"){popUpTo(NavRoutes.Home.route)} }) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = null, tint = MaterialTheme.colors.onSurface)
                }
            }
        }
    )
}