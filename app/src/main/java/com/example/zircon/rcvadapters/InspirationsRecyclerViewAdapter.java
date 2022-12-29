package com.example.zircon.rcvadapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zircon.R;
import com.example.zircon.api.ApiClient;
import com.example.zircon.api.models.InspirationModel;
import com.example.zircon.api.models.LoadMyRoomsModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class InspirationsRecyclerViewAdapter extends RecyclerView.Adapter<InspirationsRecyclerViewAdapter.ViewHolder> {

    private List<InspirationModel> mData;
    private LayoutInflater mInflater;
    private InspirationsRecyclerViewAdapter.ItemClickListener mClickListener;


    public InspirationsRecyclerViewAdapter(Context context, List<InspirationModel> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }
    @Override
    @NonNull
    public InspirationsRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.inspirations_list_single_item_layout, parent, false);
        return new ViewHolder(view);
    }


    // binds the data to the TextView in each cell
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.itemtitle.setText(mData.get(position).getTitle());
//        holder.itemimage.setText(mData.get(position).getimage());
        Picasso.get().load(ApiClient.BASE_URL + "admin/inspiration_images/"+mData.get(position).getImage()).into(holder.itemimage);
    }


    // total number of cells
    @Override
    public int getItemCount() {
        return mData.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView itemtitle;
        ImageView itemimage;

        ViewHolder(View itemView) {
            super(itemView);
            itemtitle = itemView.findViewById(R.id.imgTitle);
            itemimage = itemView.findViewById(R.id.imgVi);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    InspirationModel getItem(int id) {
        return mData.get(id);
    }

    // allows clicks events to be caught
    public void setClickListener(InspirationsRecyclerViewAdapter.ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}


