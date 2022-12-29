package com.example.zircon.rcvadapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zircon.R;
import com.example.zircon.api.models.DiseasesModel;
import com.example.zircon.api.models.VersesModel;

import java.util.List;

public class DiseasesRecyclerViewAdapter
        extends RecyclerView.Adapter<DiseasesRecyclerViewAdapter.ViewHolder> {


    private List<DiseasesModel> mData;
    private LayoutInflater mInflater;
    private DiseasesRecyclerViewAdapter.ItemClickListener mClickListener;


    public DiseasesRecyclerViewAdapter(Context context, List<DiseasesModel> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }
    @Override
    @NonNull
    public DiseasesRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.activity_diseases_cure_signle_item_layout, parent, false);
        return new DiseasesRecyclerViewAdapter.ViewHolder(view);
    }



    // binds the data to the TextView in each cell
    @Override
    public void onBindViewHolder(@NonNull DiseasesRecyclerViewAdapter.ViewHolder holder, int position) {
        holder.itemtitle.setText(mData.get(position).getTitle());
        holder.translation.setText(mData.get(position).getTranslation());
//        holder.itemimage.setText(mData.get(position).getimage());
//        Picasso.get().load(ApiClient.BASE_URL + "admin/inspiration_images/" + mData.get(position).getImage()).into(holder.itemimage);
    }


    // total number of cells
    @Override
    public int getItemCount() {
        return mData.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView itemtitle;
        TextView translation;


//    ImageView itemimage;

        ViewHolder(View itemView) {
            super(itemView);
            itemtitle = itemView.findViewById(R.id.titleTV);
            translation = itemView.findViewById(R.id.translationTV);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    DiseasesModel getItem(int id) {
        return mData.get(id);
    }

    // allows clicks events to be caught
    public void setClickListener(DiseasesRecyclerViewAdapter
                                         .ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

    {


    }
}
