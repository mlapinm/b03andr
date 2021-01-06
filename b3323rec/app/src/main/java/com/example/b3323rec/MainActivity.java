package com.example.b3323rec;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ArrayList<LittleItem> listLittleItems;
    RecyclerView recyclerView;
    LittleAdapter littleAdapter;
    RecyclerView.LayoutManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycleView);

        listLittleItems = new ArrayList<>();
        listLittleItems.add(new LittleItem("little 1"));
        listLittleItems.add(new LittleItem("little 2"));
        listLittleItems.add(new LittleItem("little 3"));
        listLittleItems.add(new LittleItem("little 4"));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        littleAdapter = new LittleAdapter(listLittleItems);
        recyclerView.setAdapter(littleAdapter);


        littleAdapter = new LittleAdapter(listLittleItems);
    }
}