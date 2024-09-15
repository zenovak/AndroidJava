package com.example.moblists;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.moblists.customAdapter.MobAdapter;
import com.example.moblists.model.MobModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<MobModel> mobs;
    private MobAdapter mobAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        // Adapter
        RecyclerView.Adapter mobItemsRecyclerAdapter = new MobAdapter(
                DataRegistry.MOB_MODELS,
                getApplicationContext()
        );
        // Layout Manager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(
                this,
                LinearLayoutManager.VERTICAL,
                false
        );

        // Assemble!
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mobItemsRecyclerAdapter);
    }
}