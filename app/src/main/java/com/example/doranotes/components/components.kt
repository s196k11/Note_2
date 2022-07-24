package com.example.doranotes.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp


@Composable
fun SearchBar(){
    var search by remember {mutableStateOf("")}
    val onSearchChange = {value:String ->
        search = value
    }

    Surface(
        modifier = Modifier.fillMaxWidth(),
        elevation = 10.dp,
        shape = RoundedCornerShape(10.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            OutlinedTextField(
                value = "",
                onValueChange = {},
                modifier = Modifier
                    .fillMaxWidth(0.85f)
                    .padding(8.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(backgroundColor = Color.White, unfocusedBorderColor = Color.Gray),
                placeholder = {Text(text = "Search")},
                leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = null, tint = Color.DarkGray)},
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
                keyboardActions = KeyboardActions(onSearch = {})
            )

            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.Menu, contentDescription = null,modifier = Modifier.size(40.dp))
            }
        }
    }
}



@Composable
fun NoteBar(title:String,description:String){

    Surface(
        modifier = Modifier.fillMaxWidth().shadow(elevation = 10.dp, shape = RoundedCornerShape(5.dp)).fillMaxHeight(0.12f),
        color = MaterialTheme.colors.background,
        elevation = 10.dp,
    ) {
        Column(verticalArrangement = Arrangement.Center) {
            Text(text = title, style = MaterialTheme.typography.subtitle1, modifier = Modifier.padding(start = 8.dp))
            Text(text = description, style = MaterialTheme.typography.body2,modifier = Modifier.padding(start = 8.dp))
        }
    }
}