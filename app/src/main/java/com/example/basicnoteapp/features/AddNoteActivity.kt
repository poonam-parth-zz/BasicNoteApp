package com.example.basicnoteapp.features

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.basicnoteapp.R
import com.example.basicnoteapp.base.BaseActivity

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
    }

    override fun onClick(v: View?) {
        when(v!!.id){

        }
    }

}
