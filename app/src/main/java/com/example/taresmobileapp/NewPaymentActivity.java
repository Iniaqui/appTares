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

import com.example.taresmobileapp.helpers.Contact;
import com.example.taresmobileapp.helpers.ContactsRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class NewPaymentActivity extends AppCompatActivity {

    Toolbar toolbar;
    ImageView scanBtn, addBtn;
    RecyclerView recyclerView;

    int [] images = {
            R.drawable.girl,
            R.drawable.photo1,
            R.drawable.photo2,
            R.drawable.girl,
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3,
            R.drawable.girl,
    };

    String [] names = {
            "Contact 01",
            "Contact 02",
            "Contact 03",
            "Contact 04",
            "Contact 05",
            "Contact 06",
            "Contact 07",
            "Contact 08",
    };

    String [] nums = {
            "0987654321",
            "1234567890",
            "0192837465",
            "1029384756",
            "1092387456",
            "0129834765",
            "6547389210",
            "5674389201",
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

        setContentView(R.layout.activity_new_payment);

        // Add Toolbar and Action bar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // hide the action bar
        Objects.requireNonNull(getSupportActionBar()).hide();

        recyclerView = findViewById(R.id.contacts_recycler_view);
        List<Contact> samplecontact = new ArrayList<>();

        for (int i = 0; i < names.length; i++) {

            Contact contact = new Contact();
            contact.contactimage = images[i];
            contact.contactname = names[i];
            contact.contactnum = nums[i];

            samplecontact.add(contact);
        }

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new ContactsRecyclerAdapter(getBaseContext(), samplecontact));

        // Buttons Values
        scanBtn = findViewById(R.id.scan);
        scanBtn.setOnClickListener(v -> {
            //
        });

        addBtn = findViewById(R.id.add);
        addBtn.setOnClickListener(v -> {
            //
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}