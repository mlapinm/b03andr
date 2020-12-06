package com.example.l2092recyc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    var nav_view: NavigationView? = null
    var rcView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nav_view = findViewById(R.id.nav_view)
        nav_view?.setNavigationItemSelectedListener(this)

        rcView = findViewById(R.id.rcView)

        var list = ArrayList<ListItem>()
        list.add(ListItem(R.drawable.som, "Som", "Som presnyi"))
        list.add(ListItem(R.drawable.caras, "Caras", "Caras presnyi"))
        list.add(ListItem(R.drawable.shuca, "Shuca", "Shuca presnyi"))
        list.add(ListItem(R.drawable.nalim, "nalim", "nalim presnyi"))
        rcView?.hasFixedSize()
        rcView?.layoutManager = LinearLayoutManager(this)

        rcView?.adapter = MyAdapter(list, this)

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