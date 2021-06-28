package com.example.taresmobileapp;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.Objects;

public class VerificationActivity extends AppCompatActivity {

    Toolbar toolbar;
    TextView nextBtn, resendBtn;

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

        setContentView(R.layout.activity_verification);

        // Add Toolbar and Action bar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // hide the action bar
        Objects.requireNonNull(getSupportActionBar()).hide();

        nextBtn = findViewById(R.id.nextBtn);
        resendBtn = findViewById(R.id.resend);

        nextBtn.setOnClickListener(v -> {
            Intent i = new Intent(getApplicationContext(), HomeActivity.class);
            startActivity(i);
        });

        resendBtn.setOnClickListener(v -> {
            //
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}