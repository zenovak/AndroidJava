package com.zenovak.cardsviewexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.zenovak.cardsviewexample.adapter.MobRecyclerAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        var adapter = new MobRecyclerAdapter(DataRegistry.MOB_MODELS, this);

        recyclerView.setLayoutManager(new GridLayoutManager(
                this,
                GridLayoutManager.DEFAULT_SPAN_COUNT
                ));
        recyclerView.setAdapter(adapter);
    }
}