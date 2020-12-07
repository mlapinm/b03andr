package com.example.l2172db

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.example.l2172db.db.MyDbManager

class MainActivity : AppCompatActivity() {

    var edTitle: EditText? = null
    var edContent: EditText? = null
    var tvTest: TextView? = null
    val myDbManager = MyDbManager(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edTitle = findViewById(R.id.edTitle)
        edContent = findViewById(R.id.edContent)
        tvTest = findViewById(R.id.tvTest)
        tvTest?.text = ""
        myDbManager.openDb()
        val dataList = myDbManager.readDbData()
        for( item in dataList){
            tvTest?.append(item)
            tvTest?.append("\n")
        }
    }

    fun onClickSave(view: View) {
        tvTest?.text = ""
        myDbManager.openDb()
        myDbManager.insertToDb(edTitle?.text.toString(), edContent?.text.toString())
        val dataList = myDbManager.readDbData()
        for( item in dataList){
            tvTest?.append(item)
            tvTest?.append("\n")
        }



    }

    override fun onDestroy() {
        super.onDestroy()
        myDbManager.closeDb()
    }
}