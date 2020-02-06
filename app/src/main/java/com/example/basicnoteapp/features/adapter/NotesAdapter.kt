package com.example.basicnoteapp.features.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.basicnoteapp.R
import com.example.basicnoteapp.features.data.NoteItem
import com.example.basicnoteapp.features.listeners.OnNoteClickListener


class NotesAdapter() :
    RecyclerView.Adapter<NotesAdapter.NotesViewHoolder>() {

    var list: ArrayList<NoteItem> = ArrayList()
    var onNoteClickListener : OnNoteClickListener? = null

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

    fun updateNoteList(noteList : List<NoteItem>){
        list.clear()
        for(item in noteList){
            list.add(NoteItem().apply {
                id=item.id
                title=item.title
                content=item.content
            })
        }
        notifyDataSetChanged()
    }

    fun setOnNoteClickListeners(clickListener: OnNoteClickListener){
           onNoteClickListener=clickListener
    }


    inner class NotesViewHoolder(view: View) : RecyclerView.ViewHolder(view),View.OnClickListener {

        init {
            view.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            onNoteClickListener?.let {
               it.onNoteClicked(list[adapterPosition].id)
            }
        }

        var tvNote = view.findViewById<TextView>(R.id.tvNote)
    }
}