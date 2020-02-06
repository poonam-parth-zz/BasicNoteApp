package com.example.basicnoteapp.di.component

import com.example.basicnoteapp.BasicNoteApplication
import com.example.basicnoteapp.di.module.ActivityModule
import com.example.basicnoteapp.di.module.AppModule
import com.example.basicnoteapp.di.module.ContextModule
import com.example.basicnoteapp.di.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        ActivityModule::class,
        ViewModelModule::class,
        ContextModule::class,
        AppModule::class,
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