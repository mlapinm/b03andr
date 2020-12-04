package com.example.l2052list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var listView = findViewById<ListView>(R.id.listView)

        var arrayList = ArrayList<String>()
        arrayList.add("Sunday")
        arrayList.add("Monday")
        arrayList.add("Tuesday")
        arrayList.add("")

        val adapter = ArrayAdapter(this,
                android.R.layout.simple_expandable_list_item_1,
                arrayList)
        listView.adapter = adapter
        listView.setOnItemClickListener{parent, view, position, id ->
            Toast.makeText(this,
                    "Pressed item position $position ${arrayList.get(position)}",
                    Toast.LENGTH_LONG).show()
        }
    }
}