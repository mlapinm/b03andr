package com.example.freon.l2202notc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.freon.l2202notc.db.MyDbManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        val myDbManager = MyDbManager(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myDbManager.openDb()
        myDbManager.insertToDb("title_1", "content_1")
        val dataList = myDbManager.readDbData()
        for( item in dataList){
            Log.i("info", item)
        }
    }

    fun onClickNew(view: View) {
        var intent = Intent(this, EditActivity::class.java)
        startActivity(intent)
    }
}