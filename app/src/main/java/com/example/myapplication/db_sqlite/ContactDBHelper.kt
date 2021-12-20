package com.example.myapplication.db_sqlite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns

class ContactDBHelper(context: Context): SQLiteOpenHelper(
    context, ContactContract.ContacEntry.DB_NAME, null,
    ContactContract.ContacEntry.CURRENT_VERSION) {

    private  val CREATE_TABLE = "CREATE TABLE ${ContactContract.ContacEntry.TABLE_NAME} (" +
            "${BaseColumns._ID} INTEGER NOT NULL," +
            "${ContactContract.ContacEntry.NAME} TEXT," +
            "${ContactContract.ContacEntry.PHONE} TEXT," +
            "PRIMARY KEY(${BaseColumns._ID} AUTOINCREMENT) )"

    private val DROP_TABLE = "DROP TABLE IF EXISTS ${ContactContract.ContacEntry.DB_NAME}"

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

        if(oldVersion != newVersion) db?.execSQL(DROP_TABLE)

        onCreate(db)
    }
}