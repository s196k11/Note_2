package com.example.doranotes.repository

import com.example.doranotes.data.Note
import com.example.doranotes.data.NoteDao

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class NoteRepo @Inject constructor(private val noteDao: NoteDao) {
    fun getAllNote(): Flow<List<Note>> = noteDao.getAllNote().flowOn(Dispatchers.IO).conflate()
    suspend fun addNote(note:Note) = noteDao.addNote(note)
    suspend fun removeNote(note:Note) = noteDao.removeNote(note)
}