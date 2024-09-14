package com.zenovak.adapterview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.zenovak.adapterview.customAdapter.EntryArrayAdapter;
import com.zenovak.adapterview.customAdapter.EntryArrayAdapter2;

public class MainActivity extends AppCompatActivity {

    public static final String MY_TAG = "myTag";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EntryArrayAdapter entryArrayAdapter = new EntryArrayAdapter(
                this,
                DataRegistry.ENTRIES
        );

        // Alternatively more optimized:
        EntryArrayAdapter2 entryArrayAdapter2 = new EntryArrayAdapter2(
                this,
                DataRegistry.ENTRIES
        );

        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(entryArrayAdapter2);
    }
}