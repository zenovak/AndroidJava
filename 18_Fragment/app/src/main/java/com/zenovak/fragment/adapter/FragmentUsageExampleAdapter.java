package com.zenovak.fragment.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zenovak.fragment.R;
import com.zenovak.fragment.model.FragmentUsageExample;

/**
 * Part of the demo class. This adapter shows the Example activities in a list.
 */
public class FragmentUsageExampleAdapter extends RecyclerView.Adapter<FragmentUsageExampleAdapter.ViewHolder> {
    private FragmentUsageExample[] fragmentUsageExamples;
    private Context context;

    public FragmentUsageExampleAdapter(FragmentUsageExample[] fragmentUsageExamples, Context context) {
        this.fragmentUsageExamples = fragmentUsageExamples;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(this.context)
                .inflate(R.layout.item_activity_host, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        FragmentUsageExample usageExample = fragmentUsageExamples[position];

        holder.name.setText(usageExample.getName());
        holder.description .setText(usageExample.getDescription());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, usageExample.getHostActivity());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.fragmentUsageExamples.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView description;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            this.name = itemView.findViewById(R.id.name);
            this.description = itemView.findViewById(R.id.description);
        }
    }
}
