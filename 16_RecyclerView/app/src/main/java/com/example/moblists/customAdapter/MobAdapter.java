package com.example.moblists.customAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moblists.R;
import com.example.moblists.model.MobModel;

public class MobAdapter extends RecyclerView.Adapter<MobAdapter.ViewHolder> {
    private MobModel[] mobModels;
    private Context context;

    public MobAdapter(MobModel[] mobModels, Context context) {
        this.mobModels = mobModels;
        this.context = context;
    }


    /**
     * Here is where the mobItem's view are inflated.
     * @param parent The ViewGroup into which the new View will be added after it is bound to
     *               an adapter position. (In this demo its the linear layout manager)
     * @param viewType The view type of the new View.
     *
     * @return viewHolder.
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mobItemView = LayoutInflater.from(context)
                .inflate(R.layout.mob_item_view, parent, false);

        return new ViewHolder(mobItemView);
    }

    /**
     * This is called when an item is scrolled into view. The Recycler view reassigns a set of fields
     * to our view retrieved view holder, based on its index
     * @param holder The ViewHolder which should be updated to represent the contents of the
     *        item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(mobModels[position].getName());
        holder.job.setText(mobModels[position].getJob());
    }

    /**
     * Returns the total number of items within your data collection.
     * @return
     */
    @Override
    public int getItemCount() {
        return mobModels.length;
    }


    /**
     * The ViewHolder implementation. This class is used to reduce the calls of findViewById.
     * ViewHolder objects initialization are triggered by the recycler's onCreateViewHolder callback
     * event.
     */
    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView job;


        /**
         *
         * @param itemView Represents the item's inflated layout resource.
         */
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.name = itemView.findViewById(R.id.name);
            this.job = itemView.findViewById(R.id.job);
        }
    }
}
