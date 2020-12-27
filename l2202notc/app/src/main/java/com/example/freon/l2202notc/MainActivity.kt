package com.example.freon.l2202notc

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.freon.l2202notc.db.MyDbManager

class MainActivity : AppCompatActivity() {

    var myDbManager: MyDbManager? = MyDbManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        myDbManager?.insertToDb("title_1", "content_1", "uri")
//        val dataList = myDbManager?.readDbData()!!
//        for( item in dataList){
//            Log.i("info", item)
//        }
    }


    fun onClickNew(view: View) {
        var intent = Intent(this, EditActivity::class.java)
        startActivity(intent)
    }

    override fun onResume() {
        super.onResume()
        myDbManager?.openDb()
    }

    override fun onDestroy() {
        super.onDestroy()
        myDbManager?.closeDb()
    }
}