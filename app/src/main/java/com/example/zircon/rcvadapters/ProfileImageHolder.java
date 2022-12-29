package com.example.zircon.rcvadapters;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.zircon.R;
import de.hdodenhof.circleimageview.CircleImageView;
import org.jetbrains.annotations.NotNull;

public class ProfileImageHolder extends RecyclerView.ViewHolder{
    CircleImageView imageView;
    View view;

    public ProfileImageHolder(@NonNull @NotNull View itemView) {
        super(itemView);
        imageView=itemView.findViewById(R.id.profile_image);
        view=itemView;
    }
}
