package com.example.basicnoteapp.features

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.example.basicnoteapp.R
import com.example.basicnoteapp.base.BaseActivity
import kotlinx.android.synthetic.main.activity_show_note_details.*
import java.text.SimpleDateFormat

class ShowNoteDetailsActivity : BaseActivity<NotesViewModel>(),View.OnClickListener {

    private var noteId : String = ""
    companion object{
        fun newInstance(context : Context,id:String) : Intent {
            return Intent(context,ShowNoteDetailsActivity::class.java).apply {
                putExtra("id",id)
            }
        }
    }

    override fun provideLayout(): Int = R.layout.activity_show_note_details

    override fun provideViewModelClass(): Class<NotesViewModel> = NotesViewModel::class.java

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_note_details)
        getId()
        setClickListeners()
    }

    fun setClickListeners(){
        ivBack.setOnClickListener(this)
    }

    fun getId(){
        intent?.let {
             it.getStringExtra("id").let { id->
                 noteId=id
                 setUI()
             }
        }
    }

    fun setUI(){
        getViewModel().getNoteById(noteId).observe(this, Observer {
              it?.let {
                  tvTitleNote.text=it.title
                  tvContentNote.text=it.content
                  tvDateTime.text= SimpleDateFormat("dd MMMM yyyy, hh:mm aa").format(it.id.toLong())
              }

        })
    }

    override fun onClick(v: View?) {
       when(v!!.id){
           ivBack.id->{
               finish()
           }
       }
    }

    override fun onPause() {
        super.onPause()
        if (isFinishing) {
            overridePendingTransition(R.anim.fade_in, R.anim.anim_fade_out)
        }
    }
}
