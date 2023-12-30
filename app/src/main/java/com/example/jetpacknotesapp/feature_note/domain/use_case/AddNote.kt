package com.example.jetpacknotesapp.feature_note.domain.use_case

import com.example.jetpacknotesapp.feature_note.domain.model.InValidNoteException
import com.example.jetpacknotesapp.feature_note.domain.model.Note
import com.example.jetpacknotesapp.feature_note.domain.repository.NoteRepository

class AddNote(
    private val repository: NoteRepository
) {

    @Throws(InValidNoteException::class)
    suspend operator fun invoke(note: Note) {
        if (note.title.isBlank()) {
            throw InValidNoteException("The title of the note cant be empty!!!")
        }
        if (note.content.isBlank()) {
            throw InValidNoteException("The content of the note cant be empty!!!")
        }
        repository.insertNote(note)
    }
}