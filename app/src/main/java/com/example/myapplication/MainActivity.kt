package com.example.myapplication

import android.os.Bundle
import android.content.Intent
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val viewModel = NotesViewModel()
    private lateinit var adapter: NotesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView=findViewById<RecyclerView>(R.id.recyclerView)
        val button = findViewById<Button>(R.id.addNoteBtn)

        adapter = NotesAdapter(
            viewModel.getNotes(),
            onEdit = { note -> openEdit(note) },
            onDelete = { note -> viewModel.deleteNote(note) }
        )

        recyclerView.layoutManager= LinearLayoutManager(this)
        recyclerView.adapter=adapter

        button.setOnClickListener {
            startActivity(Intent(this, AddNoteActivity::class.java))
        }

    }

    override fun onResume(){
        super.onResume()
        adapter.notifyDataSetChanged()
    }

    private fun openEdit(note: Note){
        val intent = Intent(this, AddNoteActivity::class.java)
        intent.putExtra("id", note.id)
        intent.putExtra("title", note.title)
        intent.putExtra("content", note.content)
        startActivity(intent)
    }
}

