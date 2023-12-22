package com.example.jetpacknotesapp.feature_note.presentation.notes.components

import androidx.lifecycle.ViewModel
import com.example.jetpacknotesapp.feature_note.domain.use_case.NoteUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(
    private val notesUseCases: NoteUseCases
): ViewModel() {



}