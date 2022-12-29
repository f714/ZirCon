package com.example.zircon.rcvadapters;



import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zircon.All_Community_Rooms;
import com.example.zircon.NotificationModel;
import com.example.zircon.PersonalRoom;
import com.example.zircon.ProgressTarget;
import com.example.zircon.R;
import com.example.zircon.api.ApiClient;
import com.example.zircon.api.ApiInterface;
import com.example.zircon.api.models.LoadMyRoomsModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.ViewHolder> {

    private final ArrayList<NotificationModel> mData;
    private final LayoutInflater mInflater;
    Context mContext;
//    private ItemClickListener mClickListener;

    // data is passed into the constructor
    public NotificationAdapter(Context context, ArrayList<NotificationModel> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        this.mContext = context;
    }

    // inflates the cell layout from xml when needed
    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.notification_itemview, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each cell
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String data = "Your room is created with title '"+mData.get(position).getTitle() +"' and it's type is '"+ mData.get(position).getType()+"'.";
        holder.itemTitle.setText(data);

        if(mData.get(position).getType().equals("community")){

            holder.joinBtn.setVisibility(View.VISIBLE);
        }else{
            holder.joinBtn.setVisibility(View.GONE);
        }
        holder.joinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

                Call<List<LoadMyRoomsModel>> myRoomCall = apiInterface.loadMyRoomByTitle(mData.get(position).getTitle());


                myRoomCall.enqueue(new Callback<List<LoadMyRoomsModel>>() {
                    @Override
                    public void onResponse(Call<List<LoadMyRoomsModel>> call, Response<List<LoadMyRoomsModel>> response) {
                        if(response.isSuccessful()) {
                            List<LoadMyRoomsModel> allRooms = response.body();

                            for (LoadMyRoomsModel myRoom: allRooms) {
                                Log.d("TAG", "onResponse:"+myRoom.getNarrator());
//                        Toast.makeText(My_Rooms.this, myRoom.getTitle(), Toast.LENGTH_SHORT).show();
                            }
                            Intent personalIntent = new Intent(mContext, PersonalRoom.class);
                            if(allRooms.size() >0) {
                                personalIntent.putExtra("title", allRooms.get(0).getTitle());
                                personalIntent.putExtra("id", "15");
                                personalIntent.putExtra("start_date", allRooms.get(0).getStart_date());
                                personalIntent.putExtra("status", allRooms.get(0).getStatus());

                                personalIntent.putExtra("zikr_counting", allRooms.get(0).getZikr_counting());


                                mContext.startActivity(personalIntent);
                            } else {
                                Toast.makeText(mContext, "No Room Found", Toast.LENGTH_SHORT).show();
                            }

                        } else {
                            Toast.makeText(mContext , "Error in loading rooms", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<List<LoadMyRoomsModel>> call, Throwable t) {
                        Toast.makeText(mContext, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
    }

    // total number of cells
    @Override
    public int getItemCount() {
        return mData.size();
    }

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView itemTitle;
 Button joinBtn;
        ViewHolder(View itemView) {
            super(itemView);
            itemTitle = itemView.findViewById(R.id.noti_tv);
            joinBtn= itemView.findViewById(R.id.joinBtn);



        }

//        @Override
//        public void onClick(View view) {
//            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
//        }
    }

    // convenience method for getting data at click position
//    NotificationModel getItem(int id) {
//        return mData.get(id);
//    }

    // allows clicks events to be caught
//    public void setClickListener(ItemClickListener itemClickListener) {
//        this.mClickListener = itemClickListener;
//    }

    // parent activity will implement this method to respond to click events
//    public interface ItemClickListener {
//        void onItemClick(View view, int position);
//    }
}
