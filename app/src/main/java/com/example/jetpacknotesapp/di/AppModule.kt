package com.example.jetpacknotesapp.di

import android.app.Application
import androidx.room.Room
import com.example.jetpacknotesapp.feature_note.data.data_source.NoteDatabase
import com.example.jetpacknotesapp.feature_note.data.repository.NoteRepositoryImpl
import com.example.jetpacknotesapp.feature_note.domain.repository.NoteRepository
import com.example.jetpacknotesapp.feature_note.domain.use_case.DeleteNote
import com.example.jetpacknotesapp.feature_note.domain.use_case.GetNotes
import com.example.jetpacknotesapp.feature_note.domain.use_case.NoteUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import javax.inject.Singleton

@Module
@InstallIn(Singleton::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): NoteDatabase {
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db: NoteDatabase): NoteRepository {
        return NoteRepositoryImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun providesNoteUseCase(repository: NoteRepository): NoteUseCases {
        return NoteUseCases(
            getNotes = GetNotes(repository),
            deleteNote = DeleteNote(repository)
        )
    }
}