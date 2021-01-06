package com.example.b3325rec;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.LittleHolder> {
    ArrayList<LittleItem> littleItems;

    public class LittleHolder extends RecyclerView.ViewHolder{
        TextView textView;

        public LittleHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
        }
    }

    public Adapter(ArrayList<LittleItem> li) {
        littleItems = li;
    }

    @NonNull
    @Override
    public LittleHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_little_view, parent, false);
        LittleHolder lh = new LittleHolder(v);
        return lh;
    }

    @Override
    public void onBindViewHolder(@NonNull LittleHolder holder, int position) {
        holder.textView.setText(littleItems.get(position).getLittle1());
    }

    @Override
    public int getItemCount() {
        return littleItems.size();
    }
}
