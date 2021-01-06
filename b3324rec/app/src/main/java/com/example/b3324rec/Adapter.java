package com.example.b3324rec;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.LittleViewHolder> {
    ArrayList<LittleItem> littleItems;

    class LittleViewHolder extends RecyclerView.ViewHolder{
        TextView textView;

        public LittleViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
        }
    }

    public Adapter(ArrayList<LittleItem> arrayList){
        littleItems = arrayList;
    }


    @NonNull
    @Override
    public LittleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_little_view, parent, false);
        LittleViewHolder lvh = new LittleViewHolder(v);
        return lvh;
    }

    @Override
    public void onBindViewHolder(@NonNull LittleViewHolder holder, int position) {
        holder.textView.setText(littleItems.get(position).little1);
    }

    @Override
    public int getItemCount() {
        return littleItems.size();
    }

}
