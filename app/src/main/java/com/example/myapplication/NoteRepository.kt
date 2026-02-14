package com.example.myapplication

object NoteRepository {

    private val notes = mutableListOf<Note>()
    private var idCounter=0
    fun getNotes(): MutableList<Note> = notes
    fun addNote(title: String, content: String) {
        notes.add(Note(idCounter++, title, content))
    }

    fun deleteNote(note: Note){
        notes.remove(note)
    }

    fun updateNote(id: Int, title: String, content: String){
        val note = notes.find {it.id==id}
        note?.title=title
        note?.content=content
    }
}
