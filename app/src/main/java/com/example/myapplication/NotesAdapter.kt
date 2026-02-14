package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NotesAdapter(
    private val notes: MutableList<Note>,
    private val onEdit: (Note) -> Unit,
    private val onDelete: (Note) -> Unit
) : RecyclerView.Adapter<NotesAdapter.NoteViewHolder>() {

    private val expandedPositions = mutableSetOf<Int>()

    class NoteViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.titleView)
        val content: TextView = view.findViewById(R.id.contentView)
        val editBtn: Button = view.findViewById(R.id.editBtn)
        val deleteBtn: Button = view.findViewById(R.id.deleteBtn)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.note_item, parent, false)
        return NoteViewHolder(view)
    }

    override fun getItemCount() = notes.size

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {

        val note = notes[position]

        holder.title.text = note.title
        holder.content.text = note.content

        holder.content.visibility =
            if (expandedPositions.contains(position)) View.VISIBLE
            else View.GONE

        holder.itemView.setOnClickListener {
            if (expandedPositions.contains(position))
                expandedPositions.remove(position)
            else
                expandedPositions.add(position)

            notifyItemChanged(position)
        }

        holder.deleteBtn.setOnClickListener {
            onDelete(note)
            notifyDataSetChanged()
        }

        holder.editBtn.setOnClickListener {
            onEdit(note)
        }
    }
}

