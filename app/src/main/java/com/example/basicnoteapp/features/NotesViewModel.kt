package com.example.basicnoteapp.features

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.basicnoteapp.features.data.NoteItem
import com.example.basicnoteapp.features.repo.NoteRepo
import javax.inject.Inject

class NotesViewModel @Inject constructor(var repo: NoteRepo) : ViewModel(){

    fun getNotesList()  = repo.getNotesList()

    fun addNote(noteItem: NoteItem)  = repo.insertorUpdateNote(noteItem)

    fun getNoteById(id:String) = repo.getNoteById(id)

}