package com.example.taresmobileapp.helpers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.example.taresmobileapp.R;
import com.google.android.material.snackbar.Snackbar;

public class ImagesSlideshowAdapter extends PagerAdapter {

    private final Context context;
    LayoutInflater layoutInflater;

    public int [] images = {
            R.drawable.visa_advance,
            R.drawable.visa_electron,
            R.drawable.visa_fusion,
            R.drawable.visa_infinite,
            R.drawable.visa_revolution,
            R.drawable.mc_rewards,
            R.drawable.mc_premium,
            R.drawable.mc_gold,
            R.drawable.hsbc_diamond,
            R.drawable.hsbc_gpn,
    };

    public ImagesSlideshowAdapter(Context context) {
        this.context = context;
    }


    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (
            view == object
        );
    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slideshow_layout, container, false);

        ImageView image = view.findViewById(R.id.slider_image);
        //image.setImageResource(images[position]);
        Glide.with(context).load(images[position]).into(image);

        image.setOnClickListener(v -> Snackbar.make(view, "Card image " + (position + 1) + " is clicked", Snackbar.LENGTH_LONG).show());

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout) object);
    }

}
