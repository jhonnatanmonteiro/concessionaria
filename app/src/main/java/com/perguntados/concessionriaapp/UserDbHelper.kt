package com.perguntados.concessionriaapp

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class UserDbHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "user.db"
        private const val DATABASE_VERSION = 1
    }

    override fun onCreate(db: SQLiteDatabase) {
        val SQL_CREATE_USER_TABLE = "CREATE TABLE " +
                UserContract.UserEntry.TABLE_NAME + " (" +
                UserContract.UserEntry.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                UserContract.UserEntry.COLUMN_NAME + " TEXT NOT NULL, " +
                UserContract.UserEntry.COLUMN_EMAIL + " TEXT NOT NULL, " +
                UserContract.UserEntry.COLUMN_PASSWORD + " TEXT NOT NULL);"

        db.execSQL(SQL_CREATE_USER_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
    }

    fun insertUser(name: String, email: String, password: String): Long {
        val db = writableDatabase

        val values = ContentValues()
        values.put(UserContract.UserEntry.COLUMN_NAME, name)
        values.put(UserContract.UserEntry.COLUMN_EMAIL, email)
        values.put(UserContract.UserEntry.COLUMN_PASSWORD, password)

        return db.insert(UserContract.UserEntry.TABLE_NAME, null, values)
    }

    fun queryUserByEmail(email: String): Cursor {
        val db = readableDatabase

        val projection = arrayOf(
            UserContract.UserEntry.ID,
            UserContract.UserEntry.COLUMN_NAME,
            UserContract.UserEntry.COLUMN_EMAIL,
            UserContract.UserEntry.COLUMN_PASSWORD
        )

        val selection = "${UserContract.UserEntry.COLUMN_EMAIL} = ?"
        val selectionArgs = arrayOf(email)

        return db.query(
            UserContract.UserEntry.TABLE_NAME,
            projection,
            selection,
            selectionArgs,
            null,
            null,
            null
        )
    }
}