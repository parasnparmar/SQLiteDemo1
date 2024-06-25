package com.example.sqlitedemo1

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteDatabase.CursorFactory
import android.database.sqlite.SQLiteOpenHelper
import androidx.lifecycle.ViewModelProvider

class ProductsDBHelper(context: Context?, name: String?,
                        factory: SQLiteDatabase.CursorFactory?, version: Int)
    : SQLiteOpenHelper(context,name,factory,version) {

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("create table products(id integer primary key, title text NOT NULL,price integer)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }
}