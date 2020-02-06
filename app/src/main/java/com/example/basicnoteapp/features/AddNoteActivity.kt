package com.example.basicnoteapp.features

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.basicnoteapp.R
import com.example.basicnoteapp.base.BaseActivity
import com.example.basicnoteapp.features.data.NoteItem
import kotlinx.android.synthetic.main.activity_add_note.*
import java.util.*

class AddNoteActivity : BaseActivity<NotesViewModel>(), View.OnClickListener {
    override fun provideLayout(): Int = R.layout.activity_add_note

    override fun provideViewModelClass(): Class<NotesViewModel> = NotesViewModel::class.java

    companion object{
        fun newInstance(context : Context) : Intent {
            return Intent(context,AddNoteActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)
        setClickListeners()
    }

    private fun setClickListeners() {
        cvSaveNote.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v!!.id){
          cvSaveNote.id->{
              val currTime = Calendar.getInstance().timeInMillis.toString()
              getViewModel().addNote(NoteItem().apply {
                  id=currTime
                  title=etTitle.text.toString()
                  content=etContent.text.toString()
              }).observe(this,androidx.lifecycle.Observer {
                  startActivity(ShowNoteDetailsActivity.newInstance(this,currTime))
                  finish()
              })

          }
        }
    }

}
