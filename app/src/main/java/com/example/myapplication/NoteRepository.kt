package com.example.myapplication

object NoteRepository {

    private val notes = mutableListOf<Note>()

    fun addNote(note: Note) {
        notes.add(note)
    }

    fun getNotes(): List<Note> {
        return notes
    }
}
