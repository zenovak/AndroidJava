package com.zenovak.dataStorage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.zenovak.dataStorage.db.DatabaseHelper;
import com.zenovak.dataStorage.db.entity.Contact;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private View rootView;
    private View snackbarLayout;
    private FloatingActionButton fab;
    private RecyclerView recyclerView;

    private ContactAdapter adapter;
    private ArrayList<Contact> contacts  = new ArrayList<>();
    private DatabaseHelper db;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHelper(this);
        contacts.addAll(db.getAllContacts());

        adapter = new ContactAdapter(contacts);

        rootView = findViewById(android.R.id.content);
        snackbarLayout = findViewById(R.id.snackbar_layout);
        fab = findViewById(R.id.fab);
        recyclerView = findViewById(R.id.recyclerView);


        fab.setOnClickListener(v -> {
            Snackbar.make(snackbarLayout, "Here's a Snackbar", Snackbar.LENGTH_LONG)
                    .setAction("Action", v1 -> {
                    })
                    .show();
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(
                this,
                LinearLayoutManager.VERTICAL,
                false
        ));
        recyclerView.setAdapter(adapter);
    }
}