package com.example.taresmobileapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import java.util.Objects;

public class HelpActivity extends AppCompatActivity {

    Toolbar toolbar;
    LinearLayout referralBonus, payment, refund,
            statementsDue, rewards, cardManage, cashback, moreHelp;

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

        setContentView(R.layout.activity_help);

        // Add Toolbar and Action bar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // hide the action bar
        Objects.requireNonNull(getSupportActionBar()).hide();

        referralBonus = findViewById(R.id.referral_bonus_layout);
        referralBonus.setOnClickListener(v -> {
            //
        });

        payment = findViewById(R.id.payment_layout);
        payment.setOnClickListener(v -> {
            Intent i = new Intent(getApplicationContext(), NewPaymentActivity.class);
            startActivity(i);
        });

        refund = findViewById(R.id.refund_layout);
        refund.setOnClickListener(v -> {
            //
        });

        statementsDue = findViewById(R.id.statements_due_layout);
        statementsDue.setOnClickListener(v -> {
            //
        });

        rewards = findViewById(R.id.rewards_layout);
        rewards.setOnClickListener(v -> {
            //
        });

        cardManage = findViewById(R.id.card_manage_layout);
        cardManage.setOnClickListener(v -> {
            Intent i = new Intent(getApplicationContext(), CardsActivity.class);
            startActivity(i);
        });

        cashback = findViewById(R.id.cashback_layout);
        cashback.setOnClickListener(v -> {
            //
        });

        moreHelp = findViewById(R.id.more_help_layout);
        moreHelp.setOnClickListener(v -> {
            Intent i = new Intent(getApplicationContext(), AboutActivity.class);
            startActivity(i);
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}