package com.example.taresmobileapp;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.Objects;

public class LoginPinActivity extends AppCompatActivity {

    Toolbar toolbar;
    TextView goToFingersprintLogin;
    ImageView fingersprintLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //This method is used so that our activity can cover the entire screen.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }

        //This method is used so that our activity can cover the entire screen.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.app_color));
        }

        setContentView(R.layout.activity_login_pin);

        // Add Toolbar and Action bar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // hide the action bar
        Objects.requireNonNull(getSupportActionBar()).hide();

        goToFingersprintLogin = findViewById(R.id.txt_fingersprint);
        fingersprintLogin = findViewById(R.id.img_fingersprint);

        goToFingersprintLogin.setOnClickListener(v -> {
            Intent i = new Intent(getApplicationContext(), FingerprintLoginActivity.class);
            startActivity(i);
        });

        fingersprintLogin.setOnClickListener(v -> {
            Intent i = new Intent(getApplicationContext(), FingerprintLoginActivity.class);
            startActivity(i);
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}