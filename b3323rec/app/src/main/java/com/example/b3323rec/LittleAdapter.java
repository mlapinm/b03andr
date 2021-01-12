package com.example.b3323rec;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LittleAdapter extends RecyclerView.Adapter<LittleAdapter.LittleViewHolder> {
    ArrayList<LittleItem> littleItemList;
    OnClickListenerLittle onClickListenerLittle;

    public interface OnClickListenerLittle {
        void onClick(int position);
    }

    public void setOnClickListener(OnClickListenerLittle listener){
        onClickListenerLittle = listener;
    }

    public class LittleViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public LittleViewHolder(@NonNull View itemView, OnClickListenerLittle onClickListenerLittle) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(onClickListenerLittle != null){
                        int position = getAdapterPosition();
                        onClickListenerLittle.onClick(position);
                    }
                }
            });
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

        LittleViewHolder lvh = new LittleViewHolder(itemView, onClickListenerLittle);
        return lvh;
    }

    @Override
    public void onBindViewHolder(@NonNull LittleViewHolder holder, int position) {
        TextView tv = holder.textView;

        tv.setText(littleItemList.get(position).getLittleItem1());
    }

    @Override
    public int getItemCount() {
        return littleItemList.size();
    }

}
