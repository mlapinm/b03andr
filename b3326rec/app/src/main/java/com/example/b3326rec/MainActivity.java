package com.example.b3326rec;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<ItemLittle> littleItems;
    RecyclerView recyclerView;
    AdapterLittle adapterLittle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycleView);

        littleItems = new ArrayList<>();
        littleItems.add(new ItemLittle("Little 1"));
        littleItems.add(new ItemLittle("Little 2"));
        littleItems.add(new ItemLittle("Little 3"));
        littleItems.add(new ItemLittle("Little 4"));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapterLittle = new AdapterLittle(littleItems);
        recyclerView.setAdapter(adapterLittle);

    }
}