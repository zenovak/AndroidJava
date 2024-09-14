package com.zenovak.adapterview.customAdapter;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.zenovak.adapterview.MainActivity;
import com.zenovak.adapterview.R;
import com.zenovak.adapterview.model.Entry;

public class EntryArrayAdapter extends ArrayAdapter<Entry> {

    private Entry[] entries;
    private LayoutInflater inflater;

    public EntryArrayAdapter(@NonNull Context context, @NonNull Entry[] objects) {
        super(context, R.layout.entry_view_item, objects);
        this.entries = objects;
        this.inflater = LayoutInflater.from(getContext());

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.entry_view_item, parent, false);
        }

        TextView name = convertView.findViewById(R.id.name);
        TextView job = convertView.findViewById(R.id.job);

        name.setText(entries[position].getName());
        job.setText(entries[position].getJob());

        Log.d(MainActivity.MY_TAG, "Get View called");

        return convertView;
    }
}
