package com.example.taresmobileapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.taresmobileapp.domains.User;

import java.util.Objects;

public class InscriptionActivity1 extends AppCompatActivity {

    Toolbar toolbar;
    TextView btnContinue;
    EditText mailUser ;
    EditText passwordUser;
    EditText confirmPasswordUser;
    User u = new User();
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

        setContentView(R.layout.activity_inscription1);
        // Get the user instance of the previous activity
        Intent iOfGetStarted  = getIntent();
        u = (User) iOfGetStarted.getSerializableExtra("user");

        // Instance of variable
        mailUser = (EditText) findViewById(R.id.editTextEmailSignup);
        passwordUser = (EditText) findViewById(R.id.editTextPasswordSignup) ;
        confirmPasswordUser = (EditText) findViewById(R.id.editTextPasswordConfirmSignup);



        // Add Toolbar and Action bar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // hide the action bar
        Objects.requireNonNull(getSupportActionBar()).hide();

        // Buttons values
        btnContinue = findViewById(R.id.continue_button);
        btnContinue.setEnabled(true);
        btnContinue.setOnClickListener(v -> {
            // Active the btn if all field are not empty
            if(mailUser.getText().toString().matches("") || passwordUser.getText().toString().matches("")|| confirmPasswordUser.getText().toString().matches("")){
                Toast.makeText(this,"Vous devez remplir tous les champs !",Toast.LENGTH_SHORT).show();
            }
            else{
                if (passwordUser.getText().toString().equals(confirmPasswordUser.getText().toString())){
                    u.setMail(mailUser.getText().toString());
                    u.setMdp(passwordUser.getText().toString());
                    Intent i = new Intent(getApplicationContext(), InscriptionActivity2.class);
                    i.putExtra("user",u);
                    startActivity(i);
                }
                else{
                    Toast.makeText(this,"Les mots de passe de correspondent pas ",Toast.LENGTH_SHORT).show();
                }
            }

        });



    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}