package com.example.taresmobileapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

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

        setContentView(R.layout.home_naviguation_drawer);

        // Add Toolbar and Action bar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        navigationView = findViewById(R.id.navigation_view);
        drawerLayout = findViewById(R.id.drawer_menu_layout);

        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle (
                this, drawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer);

        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();

    }

    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {

            drawerLayout.closeDrawer(GravityCompat.START);
        } else {

            super.onBackPressed();
        }

    }

    /**
     * Called when an item in the navigation menu is selected.
     *
     * @param item The selected item
     * @return true to display the item as the selected item
     */
    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        switch (id) {

            case R.id.nouvelle_transaction:
                Toast.makeText(getApplicationContext(), "Nouvelle Trasaction", Toast.LENGTH_LONG).show();

                Intent nouvelle_transaction = new Intent(getApplicationContext(), SendMoneyActivity.class);
                startActivity(nouvelle_transaction);

                break;

            case R.id.gestion_compte:
                Toast.makeText(getApplicationContext(), "Gestion de Compte", Toast.LENGTH_LONG).show();

                Intent gestion_compte = new Intent(getApplicationContext(), BankAccountsActivity.class);
                startActivity(gestion_compte);

                break;

            case R.id.historique_transaction:
                Toast.makeText(getApplicationContext(), "Historique des Trasactions", Toast.LENGTH_LONG).show();

                Intent historique_transaction = new Intent(getApplicationContext(), HistoryActivity.class);
                startActivity(historique_transaction);

                break;

            case R.id.contacts:
                Toast.makeText(getApplicationContext(), "Contacts", Toast.LENGTH_LONG).show();

                Intent contacts = new Intent(getApplicationContext(), NewPaymentActivity.class);
                startActivity(contacts);

                break;

            case R.id.parametres:
                Toast.makeText(getApplicationContext(), "Paramètres", Toast.LENGTH_LONG).show();

                Intent parametres = new Intent(getApplicationContext(), SettingsActivity.class);
                startActivity(parametres);

                break;

            case R.id.aide:
                Toast.makeText(getApplicationContext(), "Aides|Help", Toast.LENGTH_LONG).show();

                Intent aide = new Intent(getApplicationContext(), HelpActivity.class);
                startActivity(aide);

                break;

            case R.id.quitter:
                Toast.makeText(getApplicationContext(), "Vous avez quitter le menu", Toast.LENGTH_LONG).show();

                drawerLayout.closeDrawer(GravityCompat.START);
                break;
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

}