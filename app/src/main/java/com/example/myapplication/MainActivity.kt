package com.example.myapplication

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.myapplication.db_sqlite.ContactContract
import com.example.myapplication.db_sqlite.model.Contact

class MainActivity : AppCompatActivity() {

    lateinit var dbWriter: SQLiteDatabase
    lateinit var dbReader: SQLiteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         dbWriter = ContactApplication.instance.contactDBHelper!!.writableDatabase
         dbReader = ContactApplication.instance.contactDBHelper!!.readableDatabase

        //  val db = ContactDBHelper(this).writableDatabase

        val values = ContentValues().apply {
            put(ContactContract.ContacEntry.NAME, "O promissor")
            put(ContactContract.ContacEntry.PHONE, "9999999999")
        }

       val primaryKey =  dbWriter?.insert(ContactContract.ContacEntry.TABLE_NAME, null, values)

        Log.i("KEY", "$primaryKey")

        val contacts = mutableListOf<Contact>()

        var sql = "SELECT * FROM ${ContactContract.ContacEntry.TABLE_NAME}"
        var cursor = dbReader?.rawQuery(sql, null)

        with(cursor) {
            while (moveToNext()) {
                val name = getString(getColumnIndexOrThrow(ContactContract.ContacEntry.NAME))
                val phone = getString(getColumnIndexOrThrow(ContactContract.ContacEntry.PHONE))
                val contact = Contact(phone = phone, name = name)
                contacts.add(contact)
            }
        }

        Toast.makeText(baseContext, contacts.toString(), Toast.LENGTH_LONG)
        Log.i("LIST", "onCreate: " + contacts.toString())

    }

    override fun onDestroy() {
        dbReader.close()
        dbWriter.close()
        super.onDestroy()
    }
}