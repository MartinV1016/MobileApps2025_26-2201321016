package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class AddNoteActivity : AppCompatActivity() {

    private val viewModel = NotesViewModel()
    private var noteId: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)

        val titleInput = findViewById<EditText>(R.id.titleInput)
        val contentInput = findViewById<EditText>(R.id.contentInput)
        val saveBtn = findViewById<Button>(R.id.saveBtn)

        noteId = intent.getIntExtra("id", -1).takeIf { it != -1 }

        if (noteId != null) {
            titleInput.setText(intent.getStringExtra("title"))
            contentInput.setText(intent.getStringExtra("content"))
        }

        saveBtn.setOnClickListener {
            if (noteId != null) {
                viewModel.updateNote(
                    noteId!!,
                    titleInput.text.toString(),
                    contentInput.text.toString()
                )
            } else {
                viewModel.addNote(
                    titleInput.text.toString(),
                    contentInput.text.toString()
                )
            }
            finish()
        }
    }

}
