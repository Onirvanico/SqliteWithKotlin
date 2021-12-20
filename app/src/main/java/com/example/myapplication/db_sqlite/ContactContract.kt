package com.example.myapplication.db_sqlite

import android.provider.BaseColumns

object ContactContract {

    object ContacEntry: BaseColumns {
        const val DB_NAME = "contact.db"
        const val TABLE_NAME = "Contacts"
        const val CURRENT_VERSION = 1
        const val NAME = "name"
        const val PHONE = "phone"
    }
}