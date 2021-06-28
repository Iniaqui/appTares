package com.example.taresmobileapp;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.example.taresmobileapp.helpers.ImagesSlideshowAdapter;

import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class CardsActivity extends AppCompatActivity {

    Timer timer;
    Handler handler;
    TextView newBtn;
    Toolbar toolbar;
    Runnable runnable;
    ViewPager viewPager;
    CircleIndicator circleIndicator;
    ImagesSlideshowAdapter imagesSlideshowAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //This method is used so that our activity can cover the entire screen.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.gray));
        }

        setContentView(R.layout.activity_cards);

        // Add Toolbar and Action bar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // hide the action bar
        Objects.requireNonNull(getSupportActionBar()).hide();

        viewPager = findViewById(R.id.card_view_pager);
        circleIndicator = findViewById(R.id.circle_indicator);

        imagesSlideshowAdapter = new ImagesSlideshowAdapter(this);
        viewPager.setAdapter(imagesSlideshowAdapter);
        circleIndicator.setViewPager(viewPager);

        handler = new Handler();
        runnable = () -> {
            int img = viewPager.getCurrentItem();

            if (img == imagesSlideshowAdapter.images.length - 1) {
                img = 0;
            }
            else {
                img++;
            }
            viewPager.setCurrentItem(img, true);
        };

        timer = new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                handler.post(runnable);
            }
        }, 4000, 4000);

        newBtn = findViewById(R.id.new_btn);
        newBtn.setOnClickListener(v -> {
            Intent i = new Intent(getApplicationContext(), AddCardActivity.class);
            startActivity(i);
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}