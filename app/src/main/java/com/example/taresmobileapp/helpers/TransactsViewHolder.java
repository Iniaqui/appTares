package com.example.taresmobileapp.helpers;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.taresmobileapp.R;

public class TransactsViewHolder extends RecyclerView.ViewHolder {

    public ImageView image;
    public TextView name;
    public TextView desc;
    public TextView mount;
    public LinearLayout layout;

    public TransactsViewHolder(View itemView)
    {
        super(itemView);

        image = itemView.findViewById(R.id.contact_image);
        name = itemView.findViewById(R.id.contact_name);
        desc = itemView.findViewById(R.id.contact_desc);
        mount = itemView.findViewById(R.id.transact_mount);
        layout = itemView.findViewById(R.id.transact_recycler_item);
    }

}
