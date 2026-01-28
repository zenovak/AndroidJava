package com.zenovak.dataStorage.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.zenovak.dataStorage.R;
import com.zenovak.dataStorage.db.entity.Contact;

public class ContactDialogFragment extends DialogFragment {
    public static final String TAG = "ContactDialog";

    // Use this instance of the interface to deliver action events.
    DialogListener listener;

    public interface DialogListener {
        void onEditContact(DialogFragment dialog, Contact oldContact, Contact newContact);
        void onAddContact(DialogFragment dialog, Contact newContact);
        void onDeleteContact(DialogFragment dialogFragment, Contact contact);
    }

    // Override the Fragment.onAttach() method to instantiate the
    // NoticeDialogListener.
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        // Verify that the host activity implements the callback interface.
        try {
            // Instantiate the NoticeDialogListener so you can send events to
            // the host.
            listener = (DialogListener) context;
        } catch (ClassCastException e) {
            // The activity doesn't implement the interface. Throw exception.
            throw new ClassCastException(requireActivity().toString()
                    + " must implement NoticeDialogListener");
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Inflate the custom layout
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_contact, null);

        EditText name = view.findViewById(R.id.name);
        EditText email = view.findViewById(R.id.email);

        // Use the Builder class for convenient dialog construction.
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());

        builder.setMessage("Create Contact")
                .setView(view)
                .setPositiveButton("Save", (DialogInterface dialog, int which) -> {
                    listener.onAddContact(
                            this,
                            new Contact(name.getText().toString(), email.getText().toString())
                    );
                })
                .setNegativeButton("Cancel", (DialogInterface dialog, int id) ->{
                    // User cancels the dialog.
                });
        // Create the AlertDialog object and return it.
        return builder.create();
    }
}
