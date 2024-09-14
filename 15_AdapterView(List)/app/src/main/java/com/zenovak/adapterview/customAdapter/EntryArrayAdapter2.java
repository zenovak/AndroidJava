package com.zenovak.adapterview.customAdapter;

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

import java.util.logging.Logger;


/**
 * This Custom Array Adapter uses a viewHolder pattern to avoid calling of findViewById which
 * is expensive on some older devices
 */
public class EntryArrayAdapter2 extends ArrayAdapter<Entry> {
    private Entry[] entries;
    private LayoutInflater inflater = LayoutInflater.from(getContext());

    public EntryArrayAdapter2(@NonNull Context context, @NonNull Entry[] objects) {
        super(context, R.layout.entry_view_item, objects);
        this.entries = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        EntityViewHolder viewHolder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.entry_view_item, parent, false);

            viewHolder = new EntityViewHolder();
            viewHolder.name = convertView.findViewById(R.id.name);;
            viewHolder.job = convertView.findViewById(R.id.job);;
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (EntityViewHolder) convertView.getTag();
        }

        viewHolder.name.setText(entries[position].getName());
        viewHolder.job.setText(entries[position].getJob());

        Log.d(MainActivity.MY_TAG, "Get View called from entity array adapter");
        return convertView;
    }

    private class EntityViewHolder {
        public TextView name;
        public TextView job;
    }
}
