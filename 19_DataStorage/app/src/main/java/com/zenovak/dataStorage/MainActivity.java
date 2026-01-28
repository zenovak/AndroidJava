package com.zenovak.dataStorage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.zenovak.dataStorage.adapter.ContactAdapter;
import com.zenovak.dataStorage.db.DatabaseHelper;
import com.zenovak.dataStorage.db.entity.Contact;
import com.zenovak.dataStorage.dialog.ContactDialogFragment;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements
        ContactDialogFragment.DialogListener {
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

        snackbarLayout = findViewById(R.id.snackbar_layout);
        fab = findViewById(R.id.fab);
        recyclerView = findViewById(R.id.recyclerView);


        fab.setOnClickListener(v -> {
            ContactDialogFragment dialog = new ContactDialogFragment();
            dialog.show(getSupportFragmentManager(), ContactDialogFragment.TAG);
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(
                this,
                LinearLayoutManager.VERTICAL,
                false
        ));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onEditContact(DialogFragment dialog, Contact oldContact, Contact newContact) {

    }

    @Override
    public void onAddContact(DialogFragment dialog, Contact newContact) {
        long id = db.insertContact(newContact.getName(), null, newContact.getEmail());
       Contact addedContact = db.getContact(id);

       if (addedContact != null) {
           contacts.add(addedContact);
           adapter.notifyItemInserted(contacts.size() - 1);

           Snackbar.make(snackbarLayout, "New Contact added", Snackbar.LENGTH_LONG)
            .setAction("Ok", v1 -> {

            })
            .show();
       }
    }

    @Override
    public void onDeleteContact(DialogFragment dialogFragment, Contact contact) {

    }
}