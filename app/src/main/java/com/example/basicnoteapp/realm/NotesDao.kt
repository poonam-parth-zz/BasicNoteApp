package com.example.basicnoteapp.realm

import androidx.lifecycle.MutableLiveData
import io.realm.Realm
import io.realm.RealmList
import io.realm.Sort

class NotesDao(private val mRealm: Realm){

    fun addNote(noteItem: NoteEntity) : MutableLiveData<Boolean>{
        val isSuccess = MutableLiveData<Boolean>()
        mRealm.use {
            it.executeTransactionAsync(
                Realm.Transaction{
                 realm ->
                    realm.insertOrUpdate(noteItem)
                },
                Realm.Transaction.OnSuccess {
                    isSuccess.value=true
                }
            )
        }
        return isSuccess
    }

    fun getNoteById(id:String) : MutableLiveData<NoteEntity>{
        val entity = MutableLiveData<NoteEntity>()
        val res = mRealm
            .where(NoteEntity::class.java)
            .equalTo("id",id)
            .sort("id",Sort.ASCENDING)
            .findFirst()
        res?.let {
            entity.value=mRealm.copyFromRealm(res)
        }
        return entity
    }


    fun getNotesList() : MutableLiveData<List<NoteEntity>>{
        val mutableLiveData = MutableLiveData<List<NoteEntity>>()
        val item = mRealm.where(NoteEntity::class.java).findAllAsync()
        item?.let {
            mutableLiveData.value=mRealm.copyFromRealm(it)
        }
        return mutableLiveData
    }
}