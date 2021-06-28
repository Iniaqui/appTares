package com.example.taresmobileapp.helpers;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.taresmobileapp.R;

public class ContactsViewHolder extends RecyclerView.ViewHolder {

    public ImageView image;
    public TextView name;
    public TextView num;
    public LinearLayout layout;

    public ContactsViewHolder(View itemView)
    {
        super(itemView);

        image = itemView.findViewById(R.id.contact_image);
        name = itemView.findViewById(R.id.contact_name);
        num = itemView.findViewById(R.id.contact_num);
        layout = itemView.findViewById(R.id.contact_recycler_item);
    }

}
