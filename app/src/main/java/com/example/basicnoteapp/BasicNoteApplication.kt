package com.example.basicnoteapp

import android.content.Context
import com.example.basicnoteapp.di.component.DaggerAppComponent
import com.example.basicnoteapp.utils.Constants.Companion.DB_NAME
import com.example.basicnoteapp.utils.UpdateRealmMigrations
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import io.realm.Realm
import io.realm.RealmConfiguration

class BasicNoteApplication : DaggerApplication(){


    init {
        instance = this
    }

    companion object {
        private var instance: BasicNoteApplication? = null

        fun applicationContext(): Context {
            return instance!!.applicationContext
        }
    }

    override fun onCreate() {
        super.onCreate()

        Realm.init(this)
        val config =
            RealmConfiguration.Builder()
                .name(DB_NAME)
                .schemaVersion(UpdateRealmMigrations.SCHEMA_VERSION)
                .migration(UpdateRealmMigrations())
                .build()
        Realm.setDefaultConfiguration(config)
        Realm.getInstance(config)
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent
            .builder()
            .application(this)
            .build()
    }

}