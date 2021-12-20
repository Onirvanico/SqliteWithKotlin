package com.example.myapplication

import android.app.Application
import com.example.myapplication.db_sqlite.ContactDBHelper

class ContactApplication: Application() {

    var contactDBHelper: ContactDBHelper? = null
    private set

    companion object {
        lateinit var instance: ContactApplication
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        contactDBHelper = ContactDBHelper(this)
    }
}