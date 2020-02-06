package com.example.basicnoteapp.utils

import com.example.basicnoteapp.realm.NotesDao
import io.realm.Realm


fun Realm.noteDao() = NotesDao(this)