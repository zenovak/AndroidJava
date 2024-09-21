package com.zenovak.cardsviewexample.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zenovak.cardsviewexample.R;
import com.zenovak.cardsviewexample.model.MobModel;


public class MobRecyclerAdapter extends RecyclerView.Adapter<MobRecyclerAdapter.MobModelViewHolder> {

    private MobModel[] mobModels;
    private Context context;

    /**
     *
     * @param mobModels
     * @param context
     */
    public MobRecyclerAdapter(MobModel[] mobModels, Context context) {
        this.mobModels = mobModels;
        this.context = context;
    }

    @NonNull
    @Override
    public MobModelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        var itemLayout = LayoutInflater.from(context)
                .inflate(R.layout.item_mob_card, parent, false);

        return new MobModelViewHolder(itemLayout);
    }

    @Override
    public void onBindViewHolder(@NonNull MobModelViewHolder holder, int position) {
        var mob = mobModels[position];
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Clicked on " + mob.getName() , Toast.LENGTH_SHORT)
                        .show();
            }
        });

        holder.image.setImageResource(mob.getImageResId());
        holder.name.setText(mob.getName());
        holder.job.setText(mob.getJob());
    }

    @Override
    public int getItemCount() {

        return this.mobModels.length;
    }

    public class MobModelViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name;
        TextView job;

        public MobModelViewHolder(@NonNull View itemView) {
            super(itemView);
            this.image = itemView.findViewById(R.id.image);
            this.name = itemView.findViewById(R.id.name);
            this.job = itemView.findViewById(R.id.job);
        }
    }
}
