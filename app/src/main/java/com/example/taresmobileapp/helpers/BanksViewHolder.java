package com.example.taresmobileapp.helpers;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.taresmobileapp.R;

public class BanksViewHolder extends RecyclerView.ViewHolder {

    public ImageView image;
    public TextView name;
    public TextView num;
    public ImageView addplus;
    public LinearLayout layout;

    public BanksViewHolder(View itemView)
    {
        super(itemView);

        image = itemView.findViewById(R.id.bank_image);
        name = itemView.findViewById(R.id.bank_name);
        num = itemView.findViewById(R.id.bank_num);
        addplus = itemView.findViewById(R.id.add_plus);
        layout = itemView.findViewById(R.id.bank_recycler_item);
    }

}
