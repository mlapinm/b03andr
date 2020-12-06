package com.example.l2082int

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    var nav_view: NavigationView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nav_view = findViewById(R.id.nav_view)
        nav_view?.setNavigationItemSelectedListener(this)

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.id_fish -> {
                Toast.makeText(this, "id_fish", Toast.LENGTH_LONG).show()
            }
            R.id.id_na -> {
                Toast.makeText(this, "id_na", Toast.LENGTH_LONG).show()
            }
            R.id.id_sna -> {
                Toast.makeText(this, "id_sna", Toast.LENGTH_LONG).show()
            }
            R.id.id_history -> {
                Toast.makeText(this, "id_history", Toast.LENGTH_LONG).show()
            }
        }
        return true
    }
}