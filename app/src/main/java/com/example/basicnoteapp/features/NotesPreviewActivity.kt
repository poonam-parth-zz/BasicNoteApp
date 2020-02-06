package com.example.basicnoteapp.features

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.basicnoteapp.R
import com.example.basicnoteapp.base.BaseActivity
import com.example.basicnoteapp.features.adapter.NotesAdapter
import com.example.basicnoteapp.features.data.NoteItem
import kotlinx.android.synthetic.main.activity_notes_preview.*
import kotlinx.android.synthetic.main.activity_notes_preview_empty.*
import kotlinx.android.synthetic.main.activity_notes_preview_list_notes.*

class NotesPreviewActivity : BaseActivity<NotesViewModel>(), View.OnClickListener {
    override fun provideLayout(): Int = R.layout.activity_notes_preview

    override fun provideViewModelClass(): Class<NotesViewModel> = NotesViewModel::class.java

    private var notesAdapter = NotesAdapter()
    private var noteList : ArrayList<NoteItem> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setUI()
        setClickListeners()
        setRecyclerViewNotes()

    }

    override fun onResume() {
        super.onResume()
        observerNotesList()
    }

    private fun setClickListeners() {
        cvAddNotes.setOnClickListener(this)
        fabAddNote.setOnClickListener(this)
    }

    private fun setUI() {
        if (noteList.size > 0) {
            incNotesListView.visibility = View.VISIBLE
            incEmptyView.visibility = View.INVISIBLE
        } else {
            incNotesListView.visibility = View.INVISIBLE
            incEmptyView.visibility = View.VISIBLE
        }

    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            cvAddNotes.id -> {
                startActivity(AddNoteActivity.newInstance(this))
            }
            fabAddNote.id -> {
                startActivity(AddNoteActivity.newInstance(this))
            }
        }
    }

    private fun observerNotesList(){
        getViewModel().getNotesList().observe(this, Observer {
            it?.let {
                noteList.clear()
                noteList.addAll(it)
                notesAdapter.updateNoteList(noteList)
                setUI()
            }
        })
    }

    private fun setRecyclerViewNotes() {
        val linearLayoutManager = LinearLayoutManager(this)
        rvNotes.layoutManager = linearLayoutManager
        rvNotes.adapter = notesAdapter
    }

}
