package com.example.basicnoteapp.features

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.basicnoteapp.R
import com.example.basicnoteapp.features.adapter.NotesAdapter
import com.example.basicnoteapp.features.data.NoteItem
import kotlinx.android.synthetic.main.activity_notes_preview.*
import kotlinx.android.synthetic.main.activity_notes_preview_empty.*
import kotlinx.android.synthetic.main.activity_notes_preview_list_notes.*

class NotesPreviewActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var notesAdapter: NotesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes_preview)
        setUI()
        setClickListeners()

    }

    private fun setClickListeners() {
        cvAddNotes.setOnClickListener(this)
        fabAddNote.setOnClickListener(this)
    }

    private fun setUI() {
        if (getDemoNoteList().size > 0) {
            setRecyclerViewNotes()
        } else {
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

    private fun getDemoNoteList(): ArrayList<NoteItem> {
        var demoList = ArrayList<NoteItem>()

//        demoList.add(NoteItem().apply {
//            title = "note 1"
//        })

//        demoList.add(NoteItem().apply {
//            title = "note 2"
//        })
//
//        demoList.add(NoteItem().apply {
//            title = "note 3"
//        })
//
//        demoList.add(NoteItem().apply {
//            title = "note 1"
//        })
//
//        demoList.add(NoteItem().apply {
//            title = "note 2"
//        })
//
//        demoList.add(NoteItem().apply {
//            title = "note 3"
//        })
//
//
//        demoList.add(NoteItem().apply {
//            title = "note 1"
//        })
//
//        demoList.add(NoteItem().apply {
//            title = "note 2"
//        })
//
//        demoList.add(NoteItem().apply {
//            title = "note 3"
//        })
//
//
//        demoList.add(NoteItem().apply {
//            title = "note 1"
//        })
//
//        demoList.add(NoteItem().apply {
//            title = "note 2"
//        })
//
//        demoList.add(NoteItem().apply {
//            title = "note 3"
//        })


        return demoList
    }

    private fun setRecyclerViewNotes() {
        incNotesListView.visibility = View.VISIBLE
        val linearLayoutManager = LinearLayoutManager(this)
        notesAdapter = NotesAdapter(getDemoNoteList())
        rvNotes.layoutManager = linearLayoutManager
        rvNotes.adapter = notesAdapter
    }

}
