package com.example.basicnoteapp.realm

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass

@RealmClass
class NoteEntity : RealmObject() {
    @PrimaryKey
    var id: String = ""
    var title: String = ""
    var content: String = ""
}