package com.example.doranotes.screens

import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.doranotes.viewModel.NoteViewModel
import com.example.notes.data.Note






@Composable
fun AddNoteScreen(viewModel: NoteViewModel) {
    val focusManger = LocalFocusManager.current
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    val onTitleChange = { value: String ->
        title = value
    }
    val onDescriptionChange = { value: String ->
        description = value
    }
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(10.dp)
        .background(color = MaterialTheme.colors.primary),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(value = title, onValueChange = onTitleChange,
            placeholder = { Text(text = "Title") },
            colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.White),
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(onNext = {focusManger.moveFocus(focusDirection = FocusDirection.Down)})

        )

        TextField(value = description, onValueChange = onDescriptionChange,
            placeholder = { Text(text = "Description") },
            colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.White),
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(onDone = {
                viewModel.addNote(Note(title = title, description = description))
            })
        )

        Button(onClick = {
            viewModel.addNote(Note(title = title, description = description))
        }) {
            Text(text = "Save")
        }

    }
}

