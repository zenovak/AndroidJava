package com.zenovak.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.zenovak.fragment.adapter.FragmentUsageExampleAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        RecyclerView.Adapter usageExampleAdapter = new FragmentUsageExampleAdapter(
                DataRegistry.FRAGMENT_USAGE_EXAMPLES, this);

        RecyclerView.LayoutManager linearLayout = new LinearLayoutManager(this);

        recyclerView.setAdapter(usageExampleAdapter);
        recyclerView.setLayoutManager(linearLayout);
    }
}