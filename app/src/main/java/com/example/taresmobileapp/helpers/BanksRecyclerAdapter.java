package com.example.taresmobileapp.helpers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.taresmobileapp.R;

import java.util.List;

public class BanksRecyclerAdapter extends RecyclerView.Adapter<BanksViewHolder> {

    private final List<Bank> banks;
    private final Context context;

    public BanksRecyclerAdapter(Context context, List<Bank> banks) {
        this.banks = banks;
        this.context = context;
    }

    @NonNull
    @Override
    public BanksViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.banks_recycler_item, parent,false);
        return new BanksViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BanksViewHolder holder, int position) {

        Bank samplebank = banks.get(position);

        holder.image.setImageResource((samplebank.bankimage));
        holder.name.setText((samplebank.bankname));
        holder.num.setText((samplebank.banknum));

        holder.addplus.setImageResource((samplebank.bankaddplus));
        holder.addplus.setOnClickListener(v ->
                Toast.makeText(context, "Bank " + (position + 1)+ " plus add button is clicked", Toast.LENGTH_SHORT).show());

        holder.layout.setOnClickListener(v ->
                Toast.makeText(context, "Bank " + (position + 1) + " is touched", Toast.LENGTH_SHORT).show());

    }

    @Override
    public int getItemCount() {
        return banks.size();
    }

}
