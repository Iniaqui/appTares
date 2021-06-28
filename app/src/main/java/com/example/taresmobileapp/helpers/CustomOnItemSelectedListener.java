package com.example.taresmobileapp.helpers;

import android.graphics.Color;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

public class CustomOnItemSelectedListener implements AdapterView.OnItemSelectedListener {

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        Toast.makeText(parent.getContext(), "Monnaie sélectionnée : "
                        + parent.getItemAtPosition(pos).toString(), Toast.LENGTH_SHORT).show();

        ((TextView) parent.getChildAt(0)).setTextSize(20);
        ((TextView) parent.getChildAt(0)).setTextColor(Color.BLUE);
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

}
