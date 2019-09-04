package com.example.sepatu;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView rvData;
    private ArrayList<Data_Sepatu> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvData = findViewById(R.id.sepatu);
        rvData.setHasFixedSize(true);

        list.addAll(Sepatu_Data.getListData());
        showRecyclerList();

    }

    private void showRecyclerList() {
        rvData.setLayoutManager(new LinearLayoutManager(this));
        ListSepatuAdapter listSepatuAdapter = new ListSepatuAdapter(list) {
        };
        rvData.setAdapter(listSepatuAdapter);
    }
}
