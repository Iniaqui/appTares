package com.example.taresmobileapp;

import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.taresmobileapp.helpers.Bank;
import com.example.taresmobileapp.helpers.BanksRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BankAccountsActivity extends AppCompatActivity {

    Toolbar toolbar;
    TextView addNewBtn;
    RecyclerView recyclerView;

    int [] images = {
            R.drawable.ecobank_logo,
            R.drawable.uba_logo,
            R.drawable.nsia_logo,
            R.drawable.boa_logo,
            R.drawable.hsbc_logo,
    };

    String [] names = {
            "Bank 01",
            "Bank 02",
            "Bank 03",
            "Bank 04",
            "Bank 05",
    };

    String [] nums = {
            "*****3654",
            "*****3654",
            "*****3654",
            "*****3654",
            "*****3654",
    };

    int [] addplus = {
            R.drawable.plus,
            R.drawable.plus,
            R.drawable.plus,
            R.drawable.plus,
            R.drawable.plus,
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

        setContentView(R.layout.activity_bank_accounts);

        // Add Toolbar and Action bar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // hide the action bar
        Objects.requireNonNull(getSupportActionBar()).hide();

        addNewBtn = findViewById(R.id.add_new);
        addNewBtn.setOnClickListener(v -> {
            //
        });

        recyclerView = findViewById(R.id.banks_recycler_view);
        List<Bank> samplebank = new ArrayList<>();

        for (int i = 0; i < names.length; i++) {

            Bank bank = new Bank();
            bank.bankimage = images[i];
            bank.bankname = names[i];
            bank.banknum = nums[i];
            bank.bankaddplus = addplus[i];

            samplebank.add(bank);
        }

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new BanksRecyclerAdapter(getBaseContext(), samplebank));

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}