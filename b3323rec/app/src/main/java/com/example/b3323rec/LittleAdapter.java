package com.example.b3323rec;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class LittleAdapter extends RecyclerView.Adapter<LittleAdapter.LittleViewHolder> {
    ArrayList<LittleItem> littleItemList;

    public class LittleViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        RelativeLayout littleItem;

        public LittleViewHolder(@NonNull View itemView) {
            super(itemView);
            littleItem = itemView.findViewById(R.id.itemLittleView);
//            textView = itemView.findViewById(R.id.textView);
        }
    }

    public LittleAdapter(ArrayList<LittleItem> list){
        littleItemList = list;
    }

    @NonNull
    @Override
    public LittleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_little_view, parent, false);

        LittleViewHolder lvh = new LittleViewHolder(itemView);
        return lvh;
    }

    @Override
    public void onBindViewHolder(@NonNull LittleViewHolder holder, int position) {
//        holder.textView.setText(littleItemList.get(position).littleItem1);
        TextView tv = holder.littleItem.findViewById(R.id.textView);

        tv.setText(littleItemList.get(position).getLittleItem1());
    }

    @Override
    public int getItemCount() {
        return littleItemList.size();
    }

}
