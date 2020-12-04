package com.example.l2052activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClickSecond(view: View) {
        val intent = Intent(this, SecondActivity::class.java).apply {
            putExtra("message2", "it's from MainActivity")
        }
        startActivity(intent)
    }
}