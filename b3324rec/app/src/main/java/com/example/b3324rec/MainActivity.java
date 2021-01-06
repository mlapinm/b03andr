package com.example.b3324rec;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Adapter adapter;
    ArrayList<LittleItem> littleItems;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycleView);

        littleItems = new ArrayList<>();
        littleItems.add(new LittleItem("Little 1"));
        littleItems.add(new LittleItem("Little 2"));
        littleItems.add(new LittleItem("Little 3"));
        littleItems.add(new LittleItem("Little 4"));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Adapter(littleItems);
        recyclerView.setAdapter(adapter);

    }
}