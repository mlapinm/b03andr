package com.example.l2112content

import android.content.Context
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MyAdapter( listArray:ArrayList<ListItem>, context: Context)
    : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    var listArrR = listArray
    var contextR = context


    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var tvTitle = view.findViewById<TextView>(R.id.tvTitleItem)
        var tvContext = view.findViewById<TextView>(R.id.tvContentItem)
        var im = view.findViewById<ImageView>(R.id.imItem)

        fun bind(listItem:ListItem, context: Context){
            tvTitle.text = listItem.titleText
            var s: String = listItem.contentText
            tvContext.text = s.substring(0, 100) + "..."
            im.setImageResource(listItem.image_id)
            itemView.setOnClickListener(){
                Toast.makeText(context, "${tvTitle.text}", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var inflater = LayoutInflater.from(contextR)
        return ViewHolder(inflater.inflate(R.layout.item_layout, parent, false))
    }

    override fun getItemCount(): Int {
        return listArrR.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var listItem = listArrR.get(position)
        holder.bind(listItem, contextR)
    }

    fun updateAdapter(listArray: List<ListItem>){
        listArrR.clear()
        listArrR.addAll(listArray)
        notifyDataSetChanged()
    }

}