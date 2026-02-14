package com.example.myapplication
import androidx.lifecycle.ViewModel

class NotesViewModel : ViewModel() {



    fun getNotes() = NoteRepository.getNotes()

    fun addNote(title: String, content: String) {
        NoteRepository.addNote(title, content)
    }

    fun deleteNote(note: Note){
        NoteRepository.deleteNote(note)
    }

    fun updateNote(id: Int, title: String, content: String){
        NoteRepository.updateNote(id,title,content)
    }

}

