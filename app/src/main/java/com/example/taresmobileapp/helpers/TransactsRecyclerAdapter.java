package com.example.taresmobileapp.helpers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.taresmobileapp.R;

import java.util.List;

public class TransactsRecyclerAdapter extends RecyclerView.Adapter<TransactsViewHolder> {

    private final List<Transact> transacts;
    private final Context context;

    public TransactsRecyclerAdapter(Context context, List<Transact> transacts) {
        this.transacts = transacts;
        this.context = context;
    }

    @NonNull
    @Override
    public TransactsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.transacts_recycler_item, parent,false);
        return new TransactsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TransactsViewHolder holder, int position) {

        Transact sampletransact = transacts.get(position);
        Glide.with(context).load(sampletransact.contactimage).into(holder.image);

        //holder.image.setImageResource((sampletransact.contactimage));
        holder.name.setText((sampletransact.contactname));
        holder.desc.setText((sampletransact.contactdesc));
        holder.mount.setText((sampletransact.transactmount));

        holder.layout.setOnClickListener(v ->
                Toast.makeText(context, "Transact " + (position + 1) + " is clicked", Toast.LENGTH_SHORT).show());

    }

    @Override
    public int getItemCount() {
        return transacts.size();
    }

}
