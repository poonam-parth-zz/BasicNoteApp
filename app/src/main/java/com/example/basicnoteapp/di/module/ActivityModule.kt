package com.example.basicnoteapp.di.module

import com.example.basicnoteapp.features.AddNoteActivity
import com.example.basicnoteapp.features.NotesPreviewActivity
import com.example.basicnoteapp.features.ShowNoteDetailsActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class  ActivityModule{

    @ContributesAndroidInjector
    internal abstract fun contributePreviewNoteActivity() : NotesPreviewActivity

    @ContributesAndroidInjector
    internal abstract fun contributeAddNoteActivity() : AddNoteActivity

    @ContributesAndroidInjector
    internal abstract fun contributeShowNoteActivity() : ShowNoteDetailsActivity
}