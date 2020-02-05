package com.example.basicnoteapp.di.module

import android.content.Context
import com.example.basicnoteapp.BasicNoteApplication
import dagger.Module
import dagger.Provides

@Module
class ContextModule {

    @Provides
    fun provideContext(application: BasicNoteApplication): Context {
        return application.applicationContext
    }
}