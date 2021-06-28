package com.example.taresmobileapp.helpers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.taresmobileapp.R;

public class CustomSpinnerAdapter extends BaseAdapter {

    int [] images;
    String [] codes;
    String [] names;
    Context context;
    LayoutInflater layoutInflater;

    public CustomSpinnerAdapter (Context context, int [] images, String [] codes, String [] names) {
        this.codes = codes;
        this.names = names;
        this.images = images;
        this.context = context;
        layoutInflater = (LayoutInflater.from(context));
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @SuppressLint({"ViewHolder", "InflateParams"})
    @Override
    public View getView(int position, View convertView, ViewGroup parentView) {
        convertView = layoutInflater.inflate(R.layout.custom_spinner_items, null);

        TextView code = convertView.findViewById(R.id.country_code);
        TextView name = convertView.findViewById(R.id.country_name);
        ImageView image = convertView.findViewById(R.id.country_image);

        code.setText(codes[position]);
        name.setText(names[position]);
        image.setImageResource(images[position]);

        return convertView;
    }

}
