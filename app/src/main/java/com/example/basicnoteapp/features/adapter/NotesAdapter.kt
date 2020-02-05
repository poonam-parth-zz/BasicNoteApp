package com.example.basicnoteapp.features.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.basicnoteapp.R
import com.example.basicnoteapp.features.data.NoteItem


class NotesAdapter(var list: ArrayList<NoteItem>) :
    RecyclerView.Adapter<NotesAdapter.NotesViewHoolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHoolder {
        return NotesViewHoolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_rv_note, parent, false)
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: NotesViewHoolder, position: Int) {
        val item = list[position]
        holder.tvNote.text = item.title
    }


    inner class NotesViewHoolder(view: View) : RecyclerView.ViewHolder(view) {
        var tvNote = view.findViewById<TextView>(R.id.tvNote)
    }
}