package com.example.taresmobileapp;

import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.taresmobileapp.helpers.Transact;
import com.example.taresmobileapp.helpers.TransactsRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HistoryActivity extends AppCompatActivity {

    Toolbar toolbar;
    ImageView menuTune;
    RecyclerView recyclerView1, recyclerView2, recyclerView3;

    int [] images1 = {
            R.drawable.girl,
            R.drawable.photo1,
            R.drawable.photo2,
    };

    String [] names1 = {
            "Amazon Pantry",
            "Risa Midyette",
            "PayTM Auto",
    };

    String [] descs1 = {
            "Subscription payment",
            "Gift for Christmas",
            "Weekly Transaction...",
    };

    String [] mounts1 = {
            "-1,200",
            "+6,950",
            "-3,476",
    };


    int [] images2 = {
            R.drawable.photo2,
            R.drawable.photo1,
    };

    String [] names2 = {
            "Starbucks",
            "Katy Perry",
    };

    String [] descs2 = {
            "Foods & Drunks",
            "Singer Actress",
    };

    String [] mounts2 = {
            "+5,438",
            "-2,487",
    };


    int [] images3 = {
            R.drawable.girl,
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3,
    };

    String [] names3 = {
            "Amazon AWS",
            "MTN Pay",
            "Ecobank",
            "Heroku",
    };

    String [] descs3 = {
            "Amazon Web Services",
            "Mtn Momo Payment",
            "Ecobank Benin Side",
            "Deployment Cloud Services",
    };

    String [] mounts3 = {
            "-10,346",
            "+30,467",
            "-700",
            "+23,679",
    };


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

        setContentView(R.layout.activity_history);

        // Add Toolbar and Action bar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // hide the action bar
        Objects.requireNonNull(getSupportActionBar()).hide();

        // Buttons Values
        menuTune = findViewById(R.id.menu_tune);
        menuTune.setOnClickListener(v -> {
            //
        });

        recyclerView1 = findViewById(R.id.transacts_recycler_view1);
        List<Transact> sampletransact1 = new ArrayList<>();

        for (int i = 0; i < names1.length; i++) {

            Transact transact1 = new Transact();
            transact1.contactimage = images1[i];
            transact1.contactname = names1[i];
            transact1.contactdesc = descs1[i];
            transact1.transactmount = mounts1[i];

            sampletransact1.add(transact1);
        }

        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(this);
        recyclerView1.setLayoutManager(linearLayoutManager1);

        recyclerView1.setHasFixedSize(true);
        recyclerView1.setAdapter(new TransactsRecyclerAdapter(getBaseContext(), sampletransact1));


        recyclerView2 = findViewById(R.id.transacts_recycler_view2);
        List<Transact> sampletransact2 = new ArrayList<>();

        for (int i = 0; i < names2.length; i++) {

            Transact transact2 = new Transact();
            transact2.contactimage = images2[i];
            transact2.contactname = names2[i];
            transact2.contactdesc = descs2[i];
            transact2.transactmount = mounts2[i];

            sampletransact2.add(transact2);
        }

        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this);
        recyclerView2.setLayoutManager(linearLayoutManager2);

        recyclerView2.setHasFixedSize(true);
        recyclerView2.setAdapter(new TransactsRecyclerAdapter(getBaseContext(), sampletransact2));


        recyclerView3 = findViewById(R.id.transacts_recycler_view3);
        List<Transact> sampletransact3 = new ArrayList<>();

        for (int i = 0; i < names3.length; i++) {

            Transact transact3 = new Transact();
            transact3.contactimage = images3[i];
            transact3.contactname = names3[i];
            transact3.contactdesc = descs3[i];
            transact3.transactmount = mounts3[i];

            sampletransact3.add(transact3);
        }

        LinearLayoutManager linearLayoutManager3 = new LinearLayoutManager(this);
        recyclerView3.setLayoutManager(linearLayoutManager3);

        recyclerView3.setHasFixedSize(true);
        recyclerView3.setAdapter(new TransactsRecyclerAdapter(getBaseContext(), sampletransact3));

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}