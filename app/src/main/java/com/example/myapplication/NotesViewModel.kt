package com.example.myapplication
import androidx.lifecycle.ViewModel

class NotesViewModel : ViewModel() {

    fun addNote(title: String, content: String) {
        NoteRepository.addNote(Note(title, content))
    }

    fun getNotes(): List<Note> {
        return NoteRepository.getNotes()
    }
}

