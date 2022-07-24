package com.example.doranotes.di

import android.content.Context
import androidx.room.Room
import com.example.doranotes.data.NoteDao
import com.example.doranotes.data.NoteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Singleton
    @Provides
    fun providesNoteDatabase(@ApplicationContext context: Context): NoteDatabase = Room.databaseBuilder(context,NoteDatabase::class.java,"noteDatabase").fallbackToDestructiveMigration().build()

    @Singleton
    @Provides
    fun providesNoteDao(noteDatabase: NoteDatabase): NoteDao = noteDatabase.noteDao()
}