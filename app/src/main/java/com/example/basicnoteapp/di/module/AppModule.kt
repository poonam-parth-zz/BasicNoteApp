package com.example.basicnoteapp.di.module

import com.example.basicnoteapp.features.repo.NoteRepo
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule{

    @Provides
    @Singleton
    fun provideNoteRepo() : NoteRepo = NoteRepo()
}