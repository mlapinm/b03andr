package com.example.l2052activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        var textView : TextView? = null
        textView = findViewById(R.id.textView)

        var intent = intent
        var string = intent?.getCharSequenceExtra("message2")
        textView?.setText(string)
    }
}