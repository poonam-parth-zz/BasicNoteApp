package com.example.basicnoteapp.utils

import android.view.View
import android.widget.EditText

fun View.makeVisible(){
    visibility=View.VISIBLE
}

fun View.makeInVisible(){
    visibility=View.INVISIBLE
}

fun View.makeGone(){
    visibility=View.GONE
}

fun EditText.isFieldEmpty() : Boolean{
    return text.length>0
}