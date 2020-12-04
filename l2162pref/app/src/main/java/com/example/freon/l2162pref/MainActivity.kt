package com.example.freon.l2162pref

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    var pref: SharedPreferences? = null

    var editText: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.editText)
        pref = getSharedPreferences("Text", Context.MODE_PRIVATE)

        var s = pref?.getString("Text", "")
        editText?.setText(s)

    }

    override fun onDestroy() {
        super.onDestroy()
        var s : String = editText?.text.toString()
        val editor = pref?.edit()
        editor?.putString("Text", s)
        editor?.apply()

    }
}