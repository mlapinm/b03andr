package com.example.l2112content

import android.content.res.TypedArray
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
    var adapter: MyAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nav_view = findViewById(R.id.nav_view)
        nav_view?.setNavigationItemSelectedListener(this)

        rcView = findViewById(R.id.rcView)

        var list = ArrayList<ListItem>()
        rcView?.hasFixedSize()
        rcView?.layoutManager = LinearLayoutManager(this)
        adapter = MyAdapter(list, this)
        adapter?.updateAdapter(fillArrays(resources.getStringArray(R.array.fish),
            resources.getStringArray(R.array.fish_content),
            getImageId(R.array.fish_image_array)))



        rcView?.adapter = adapter

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.id_fish -> {
                Toast.makeText(this, "id_fish", Toast.LENGTH_LONG).show()
                adapter?.updateAdapter(fillArrays(resources.getStringArray(R.array.fish),
                    resources.getStringArray(R.array.fish_content),
                    getImageId(R.array.fish_image_array)))
            }
            R.id.id_na -> {
                Toast.makeText(this, "id_na", Toast.LENGTH_LONG).show()
                adapter?.updateAdapter(fillArrays(resources.getStringArray(R.array.na),
                    resources.getStringArray(R.array.na_content),
                    getImageId(R.array.na_image_array)))
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

    fun fillArrays(titleArray:Array<String>, contentArray:Array<String>,
                   imageArray:IntArray):List<ListItem>{
        var listItemArray = ArrayList<ListItem>()
        for(i in 0..titleArray.size - 1){
            var listItem = ListItem(imageArray[i],titleArray[i],contentArray[i])
            listItemArray.add(listItem)
        }
        return listItemArray
    }

    fun getImageId(imageArrayId:Int):IntArray
    {
        var tArray: TypedArray = resources.obtainTypedArray(imageArrayId)
        val count = tArray.length()
        val ids = IntArray(count)
        for(i in ids.indices)
        {
            ids[i] = tArray.getResourceId(i,0)
        }
        tArray.recycle()
        return ids
    }
}