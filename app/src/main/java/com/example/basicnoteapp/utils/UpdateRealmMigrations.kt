package com.example.basicnoteapp.utils

import io.realm.DynamicRealm
import io.realm.RealmMigration

class UpdateRealmMigrations : RealmMigration {

    companion object {
        const val SCHEMA_VERSION = 0L
    }

    override fun migrate(
        realm: DynamicRealm,
        oldVersion: Long,
        newVersion: Long
    ) {
        if (oldVersion != SCHEMA_VERSION) {
            throw RuntimeException("unexpected scheme version. expected: $SCHEMA_VERSION, actual: $oldVersion")
        }
    }
}