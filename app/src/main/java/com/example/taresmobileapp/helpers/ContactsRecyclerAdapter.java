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

public class ContactsRecyclerAdapter extends RecyclerView.Adapter<ContactsViewHolder> {

    private final List<Contact> contacts;
    private final Context context;

    public ContactsRecyclerAdapter(Context context, List<Contact> contacts) {
        this.contacts = contacts;
        this.context = context;
    }

    @NonNull
    @Override
    public ContactsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.contacts_recycler_item, parent,false);
        return new ContactsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactsViewHolder holder, int position) {

        Contact samplecontact = contacts.get(position);
        Glide.with(context).load(samplecontact.contactimage).into(holder.image);

        //holder.image.setImageResource((samplecontact.contactimage));
        holder.name.setText((samplecontact.contactname));
        holder.num.setText((samplecontact.contactnum));

        holder.layout.setOnClickListener(v ->
                Toast.makeText(context, "Contact " + (position + 1) + " is clicked", Toast.LENGTH_SHORT).show());

    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

}
