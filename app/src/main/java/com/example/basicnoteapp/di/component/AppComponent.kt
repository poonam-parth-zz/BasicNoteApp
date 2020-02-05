package com.example.basicnoteapp.di.component

import com.example.basicnoteapp.BasicNoteApplication
import com.example.basicnoteapp.di.module.ActivityModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        ActivityModule::class,
        AndroidSupportInjectionModule::class
    ]
)
interface AppComponent : AndroidInjector<BasicNoteApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: BasicNoteApplication): Builder

        fun build(): AppComponent
    }

}