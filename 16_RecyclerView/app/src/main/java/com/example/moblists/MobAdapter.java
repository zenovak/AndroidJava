package com.example.moblists;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class MobAdapter extends ArrayAdapter<MobModel> {
    private ArrayList<MobModel> items;

    public MobAdapter(Context context, ArrayList<MobModel> items) {
        super(context, R.layout.itemview, items);
        this.items = items;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        MobModel item = this.getItem(position);

        MobViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new MobViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(
                    R.layout.itemview,
                    parent,
                    false
            );
            viewHolder.name = (TextView) convertView.findViewById(R.id.name);
            viewHolder.health = (TextView) convertView.findViewById(R.id.health);
            viewHolder.image = (ImageView) convertView.findViewById(R.id.image);

            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (MobViewHolder) convertView.getTag();
        }
        viewHolder.image.setImageResource(item.getImage());
        viewHolder.name.setText(item.getName());
        viewHolder.health.setText(item.getHealth());

        return convertView;
    }
}
