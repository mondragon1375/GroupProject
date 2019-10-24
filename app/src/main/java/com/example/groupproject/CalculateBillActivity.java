package com.example.groupproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class CalculateBillActivity extends AppCompatActivity {

    public static final String COST = "cost";
    public static final String NAME = "name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_bill);
        Intent intent = getIntent();
        String cost = intent.getStringExtra(COST);
        String name = intent.getStringExtra(NAME);
        String message = "You have purchased the " + name +
                " it costs " + cost + " dollars";

        TextView str = (TextView) findViewById(R.id.billMessage);
        str.setText(message);
    }


}