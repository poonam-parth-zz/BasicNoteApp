package com.example.basicnoteapp.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.basicnoteapp.di.scope.ViewModelKey
import com.example.basicnoteapp.features.NotesViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import wellthy.care.di.factory.ViewModelFactory

@Module
abstract class ViewmodelModule{


    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(NotesViewModel::class)
    internal abstract fun bindMainViewModel(notesViewModel: NotesViewModel): ViewModel

}