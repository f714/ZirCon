package com.example.zircon.rcvadapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.zircon.Portfolio;
import com.example.zircon.R;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class ProfileImageAdapter extends RecyclerView.Adapter<ProfileImageHolder> {
    ArrayList<String> usersList;

    public ProfileImageAdapter(Context context, ArrayList<String> usersList) {
        this.context = context;
        this.usersList = usersList;
        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();

    }

    FirebaseStorage storage;
    StorageReference storageReference;

    Context context;

    @NonNull
    @NotNull
    @Override
    public ProfileImageHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        Context context
                = parent.getContext();
        LayoutInflater inflater
                = LayoutInflater.from(context);

        // Inflate the layout

        View photoView
                = inflater
                .inflate(R.layout.community_members_profile_images_view,
                        parent, false);

        return new ProfileImageHolder(photoView);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ProfileImageHolder holder, int position) {
        final int index = holder.getAdapterPosition();
        StorageReference ref
                = storageReference
                .child(
                        "images/");

        ref.child(usersList.get(index)).getDownloadUrl().addOnSuccessListener(uri -> Glide.with(context)
                .load(uri)
                .into(holder.imageView));


//        holder.imageView.setImageResource(R.drawable.book);
//                .setImageDrawable(list.get(position).name);

    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }
}
