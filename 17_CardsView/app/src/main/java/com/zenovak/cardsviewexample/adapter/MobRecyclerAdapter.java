package com.zenovak.cardsviewexample.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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
        holder.image.setImageResource(mobModels[position].getImageResId());
        holder.name.setText(mobModels[position].getName());
        holder.job.setText(mobModels[position].getJob());
    }

    @Override
    public int getItemCount() {
        return 0;
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
