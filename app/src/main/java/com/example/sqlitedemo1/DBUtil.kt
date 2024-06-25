package com.example.sqlitedemo1

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.util.Log

class DBUtil(private val context: Context) {
    private val db: SQLiteDatabase =
        ProductsDBHelper(context,"db_product",null,1).writableDatabase

    fun addProduct(id: Int,title: String,price: Int):Boolean{
        val values = ContentValues()
        values.put("id",id)
        values.put("title",title)
        values.put("price",price)

        val rowNum = db.insert("products",null,values)
        Log.d("Tag","$rowNum")
        return rowNum.toInt() != -1
    }
    fun deleteProduct(id: Int): Boolean{

       var count =  db.delete("products","id=?", arrayOf(id.toString()))
        Log.d("Tag","delete -> $count")
        return count!=0
    }
    fun updateProduct(id: Int, title: String,price: Int): Boolean{
        val values = ContentValues()
        values.put("id",id)
        values.put("title",title)
        values.put("price",price)

        var count = db.update("products",values,"id=?", arrayOf(id.toString()))
        return count != 0

    }
    fun retriveProdcut(): ArrayList<Product>{
        var c = db.query("products",null,null,null,null,null,"id desc")
        val products1 = ArrayList<Product>()
        while (c.moveToNext()){
            val id = c.getInt(0)
            val title = c.getString(1)
            val price = c.getInt(2)

            val newProducts = Product(id,title,price)
            products1.add(newProducts)

        }

        return products1
    }
}