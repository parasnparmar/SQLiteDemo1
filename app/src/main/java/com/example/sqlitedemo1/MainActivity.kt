package com.example.sqlitedemo1

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    var arr: ArrayList<Product> = ArrayList<Product>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        var dBUtil = DBUtil(this)
        dBUtil.addProduct(101,"Product101",995)
        dBUtil.addProduct(102,"Product102",997)
        dBUtil.addProduct(103,"Product103",999)

        for(i in 104..110){
            dBUtil.addProduct(i,"Product$i",i*12)
        }

        arr = dBUtil.retriveProdcut()
        for(eachProduct in arr){
            Log.d("Tag Retrive: ","${eachProduct.id} -- ${eachProduct.title} -- ${eachProduct.price}")
        }

        dBUtil.deleteProduct(101)
        for(eachProduct in dBUtil.retriveProdcut()){
            Log.d("Tag Retrive: ","${eachProduct.id} -- ${eachProduct.title} -- ${eachProduct.price}")
        }

        dBUtil.updateProduct(103,"SmartPhone",25000)
        for(eachProduct in dBUtil.retriveProdcut()){
            Log.d("Tag Retrive: ","${eachProduct.id} -- ${eachProduct.title} -- ${eachProduct.price}")
        }


    }
}