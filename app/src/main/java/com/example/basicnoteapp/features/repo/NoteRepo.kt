package com.example.basicnoteapp.features.repo

import androidx.lifecycle.MutableLiveData
import com.example.basicnoteapp.features.data.NoteItem
import com.example.basicnoteapp.features.mapper.mapNoteEntityToItem
import com.example.basicnoteapp.features.mapper.mapNoteItemToEntity
import com.example.basicnoteapp.utils.noteDao
import io.realm.Realm
import javax.inject.Singleton

@Singleton
class NoteRepo(){

    fun insertorUpdateNote(noteItem : NoteItem){
        Realm.getDefaultInstance().use{
             it.noteDao().addNote(mapNoteItemToEntity(noteItem))
        }
    }

    fun getNoteById(id:String) : MutableLiveData<NoteItem>{
        val item = MutableLiveData<NoteItem>()
       Realm.getDefaultInstance().use{
            it.noteDao().getNoteById(id).observeForever {
                item.value = mapNoteEntityToItem(it)
            }
        }
        return item
    }


}