package com.example.taresmobileapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Objects;

public class SettingsActivity extends AppCompatActivity {

    Toolbar toolbar;
    TextView modifyProfil;
    LinearLayout partagerProfil, centreMessage, parametresSecurite,
            notifications, newsLetters, aidesContacts, mentionsLegales;

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

        setContentView(R.layout.activity_settings);

        // Add Toolbar and Action bar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // hide the action bar
        Objects.requireNonNull(getSupportActionBar()).hide();

        modifyProfil = findViewById(R.id.modifier_profil);
        modifyProfil.setOnClickListener(v -> {
            Intent i = new Intent(getApplicationContext(), ModifyProfilActivity.class);
            startActivity(i);
        });

        partagerProfil = findViewById(R.id.partager_layout);
        partagerProfil.setOnClickListener(v -> {

            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Trouvez ci-dessous le lien pour mon profil sur Tares");

            String app_url = "https://otakufr.co/";
            shareIntent.putExtra(Intent.EXTRA_TEXT, app_url);
            startActivity(Intent.createChooser(shareIntent, "Partager via"));

        });

        centreMessage = findViewById(R.id.message_layout);
        centreMessage.setOnClickListener(v -> {
            //
        });

        parametresSecurite = findViewById(R.id.parametres_layout);
        parametresSecurite.setOnClickListener(v -> {
            Intent i = new Intent(getApplicationContext(), LicenseActivity.class);
            startActivity(i);
        });

        notifications = findViewById(R.id.notifications_layout);
        notifications.setOnClickListener(v -> {
            //
        });

        newsLetters = findViewById(R.id.news_letters_layout);
        newsLetters.setOnClickListener(v -> {
            //
        });

        aidesContacts = findViewById(R.id.aides_contacts_layout);
        aidesContacts.setOnClickListener(v -> {
            Intent i = new Intent(getApplicationContext(), HelpActivity.class);
            startActivity(i);
        });

        mentionsLegales = findViewById(R.id.mentions_legales_layout);
        mentionsLegales.setOnClickListener(v -> {
            Intent i = new Intent(getApplicationContext(), AboutActivity.class);
            startActivity(i);
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}