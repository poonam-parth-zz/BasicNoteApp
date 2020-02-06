package com.example.basicnoteapp.features.mapper

import com.example.basicnoteapp.features.data.NoteItem
import com.example.basicnoteapp.realm.NoteEntity


fun mapNoteItemToEntity(noteItem: NoteItem): NoteEntity {
    return NoteEntity().apply {
        id = noteItem.id
        title = noteItem.title
        content = noteItem.content
    }
}

fun mapNoteEntityToItem(noteItem: NoteEntity): NoteItem {
    return NoteItem().apply {
        id = noteItem.id
        title = noteItem.title
        content = noteItem.content
    }
}