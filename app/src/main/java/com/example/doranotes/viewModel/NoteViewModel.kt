package com.example.doranotes.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.doranotes.data.Note
import com.example.doranotes.repository.NoteRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class NoteViewModel @Inject constructor(private val noteRepo:NoteRepo) : ViewModel() {
    private val _noteList = MutableStateFlow<List<Note>>(emptyList())
    val noteList = _noteList.asStateFlow()

    init{
        viewModelScope.launch(Dispatchers.IO){
            noteRepo.getAllNote().distinctUntilChanged()
                .collect{listOfNote ->
                    _noteList.value = listOfNote
                }
        }
    }

    fun addNote(note:Note) = viewModelScope.launch { noteRepo.addNote(note)}

    fun removeNote(note:Note) = viewModelScope.launch { noteRepo.removeNote(note) }
}