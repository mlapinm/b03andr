package com.example.freon.l3022web

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var webView = findViewById<WebView>(R.id.webView)
        webView.settings.javaScriptEnabled = true

        webView.loadUrl("file:///android_asset/index.html")

    }
}