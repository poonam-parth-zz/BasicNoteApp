package com.example.basicnoteapp.features

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.basicnoteapp.R
import com.example.basicnoteapp.features.adapter.NotesAdapter
import com.example.basicnoteapp.features.data.NoteItem
import kotlinx.android.synthetic.main.activity_notes_preview.*

class NotesPreviewActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var notesAdapter: NotesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes_preview)
        setUI()

    }

    private fun setUI() {
        if (getDemoNoteList().size > 0) {
            setRecyclerViewNotes()
        } else {
            clEmptyView.visibility = View.VISIBLE
        }

    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            cvAddNotes.id -> {

            }
        }
    }

    private fun getDemoNoteList(): ArrayList<NoteItem> {
        var demoList = ArrayList<NoteItem>()

        demoList.add(NoteItem().apply {
            title = "note 1"
        })

        demoList.add(NoteItem().apply {
            title = "note 2"
        })

        demoList.add(NoteItem().apply {
            title = "note 3"
        })

        return demoList
    }

    private fun setRecyclerViewNotes() {
        rvNotes.visibility = View.VISIBLE
        val linearLayoutManager = LinearLayoutManager(this)
        notesAdapter = NotesAdapter(getDemoNoteList())
        rvNotes.layoutManager = linearLayoutManager
        rvNotes.adapter = notesAdapter
    }

}
