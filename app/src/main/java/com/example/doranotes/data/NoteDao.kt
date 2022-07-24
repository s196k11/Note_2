package com.example.doranotes.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface NoteDao {
    @Query("select * from NoteTbl")
    fun getAllNote(): Flow<List<Note>>

    @Insert
    suspend fun addNote(note:Note)

    @Delete
    suspend fun removeNote(note:Note)
}