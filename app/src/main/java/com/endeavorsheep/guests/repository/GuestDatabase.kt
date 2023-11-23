package com.endeavorsheep.guests.repository

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.endeavorsheep.guests.constants.DatabaseConstants

class GuestDatabase(context: Context) : SQLiteOpenHelper(context, NAME, null, VERSION) {

    companion object {
        private const val NAME = "guestDb"
        private const val VERSION = 1
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("create table ${DatabaseConstants.GUEST.TABLE_NAME} (${DatabaseConstants.GUEST.COLUMNS.ID} integer primary key autoincrement, ${DatabaseConstants.GUEST.COLUMNS.NAME} text, ${DatabaseConstants.GUEST.COLUMNS.PRESENCE} integer)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }
}