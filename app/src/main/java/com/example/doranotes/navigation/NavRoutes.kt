package com.example.doranotes.navigation

sealed class NavRoutes(val route:String){
    object Home:NavRoutes("home")
    object AddNote:NavRoutes("addNote")
}
