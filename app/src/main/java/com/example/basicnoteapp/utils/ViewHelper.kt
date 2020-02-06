package com.example.basicnoteapp.utils

import android.view.View

fun View.makeVisible(){
    visibility=View.VISIBLE
}

fun View.makeInVisible(){
    visibility=View.INVISIBLE
}

fun View.makeGone(){
    visibility=View.GONE
}